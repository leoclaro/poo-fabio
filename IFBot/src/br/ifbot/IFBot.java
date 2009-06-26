package br.ifbot;

import java.awt.Color;

import robocode.*;

public class IFBot extends Robot {

	int turnDirection = 1; // Flag para mudança de sentido: horário e anti-horário
	double moveAmount; // Quanto o robô deve se mover
	boolean peek; // Não se mover caso exista um robô por perto
	double tirosLevados = 0;

	/**
	 * Alterando as cores do robô para personalizar. Faz o movimento inicial para começar andar perto das paredes sem bater.
	 */
	public void run(){

		setBodyColor(Color.black);
		setGunColor(Color.white);
		setRadarColor(Color.blue);
		setBulletColor(Color.cyan);
		setScanColor(Color.cyan);
		turnLeft(getHeading() % 90);
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		while(true){

			ahead(moveAmount);
			peek = true;
			// Movendo para a parede
			ahead(moveAmount);
			// Não faz scan agora
			peek = false;
			// Indo para outra parede
			turnRight(90);


		}

	}

	/**
	 * Evento usado ao se encontrar um robô no scan. Disparamos um tiro e mudamos de posição para se esquivar de alguma mira
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {

		mira(e.getBearing());
		fogo(e.getDistance());
		ahead(e.getDistance() + 10);

		//turnRight(e.getBearing());
		//ahead(e.getDistance() + 5);
	}

	/**
	 * Não faz nada ao ganhar
	 */
	@Override
	public void onWin(WinEvent e) {

	}

	/**
	 * Evento que ocorre quando o robô bater em outro. No nosso caso, 
	 * ele efetua um disparo mais potente aproveitando que está mais perto. 
	 * Se for o IFBot que bateu, então ele abre uma distância antes. 
	 */
	public void onHitRobot(HitRobotEvent e) {
		
		if (e.getBearing() > -10 && e.getBearing() < 10) {
			fire(3);
		}
		if (e.isMyFault()) {
			turnRight(20);
			back(30);
		}
		mira(e.getBearing());
		fogo(3);
	}

	/**
	 * Evento que ocorre quando o robô é atingido por um tiro. Nesa hora ele tenta sair da posição e inicia o scan novamente
	 * para procurar o inimigo mais próximo
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		
		this.tirosLevados+= 1 * e.getPower();
		
		if(this.tirosLevados > 3){
			turnRight(150);
			back(200);
			
		}else{
			turnRight(100);
			back(80);
		}
		scan();
	}


	/**
	 * Evento que ocorre quando o IFBot erra o tiro. Então, mira novamente
	 */
	@Override
	public void onBulletMissed(BulletMissedEvent e) {

	//	back(15);
	//	turnRight(5);
		scan();
		mira(e.getBullet().getHeading());
		fogo(20);
	}

	/**
	 * Função de mira usada na apostila
	 * @param Adv
	 */
	public void mira(double Adv)
	{
		double A=getHeading()+Adv-getGunHeading();
		if (!(A > -180 && A <= 180))
		{
			while (A <= -180)
				A += 360;
			while (A > 180)
				A -= 360;
		}
		turnGunRight(A);
	}

	/**
	 * Efetua calibração do tiro data uma certa distância
	 * @param Distancia
	 */
	public void fogo(double Distancia)
	{
		if (Distancia> 200 || getEnergy() < 15)
			fire(2);
		else
			fire(3);
	}

	/**
	 * Quando acertar o tiro, recalibra a quantidade de tiros que já levou,
	 * faz um disparo maior e retorna ao scan
	 */
	@Override
	public void onBulletHit(BulletHitEvent e) {
		this.tirosLevados = 1;
		fogo(3);
		scan();
		
	}

	@Override
	public void onBulletHitBullet(BulletHitBulletEvent arg0) {
		// TODO Auto-generated method stub
		super.onBulletHitBullet(arg0);
	}


}
