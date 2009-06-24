package br.ifbot;

import java.awt.Color;

import robocode.*;

public class IFBot extends Robot {

	int turnDirection = 1; // Flag para mudança de sentido: horário e anti-horário
	double moveAmount; // Quanto o robô deve se mover
	boolean peek; // Não se mover caso exista um robô por perto

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
		mira(e.getBearing());
		fogo(2);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		back(10);
		turnRight(10);
		scan();
	}


	@Override
	public void onBulletMissed(BulletMissedEvent e) {
		mira(e.getBullet().getHeading());
		scan();
	}

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

	public void fogo(double Distancia)
	{
		if (Distancia> 200 || getEnergy() < 15)
			fire(1);
		else if (Distancia > 50)
			fire(2);
		else
			fire(3);
	}

	public double anguloRelativo(double ANG)
	{
		if (ANG> -180 && ANG<= 180)
			return ANG;
		double REL = ANG;
		while (REL<= -180)
			REL += 360;
		while (ANG> 180)
			REL -= 360;
		return REL;
	}

}
