package br.ifbot;

import java.awt.Color;

import robocode.*;

public class IFBot extends Robot {

	int turnDirection = 1; // Clockwise or counterclockwise
	double moveAmount; // How much to move
	boolean peek; // Don't turn if there's a robot there
	
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
			// Move up the wall
			ahead(moveAmount);
			// Don't look now
			peek = false;
			// Turn to the next wall
			turnRight(90);
		
			
		}
		
	}


	@Override
	public void onScannedRobot(ScannedRobotEvent e) {

		fire(1);
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan(); // Might want to move ahead again!
	}

	@Override
	public void onWin(WinEvent e) {
		// TODO Auto-generated method stub
		super.onWin(e);
	}
	
	/**
	 * onHitRobot:  Move away a bit.
	 */
	public void onHitRobot(HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -10 && e.getBearing() < 10) {
			fire(10);
		}
		if (e.isMyFault()) {
			turnRight(10);
		}
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(90 - e.getBearing());
	}


	@Override
	public void onBulletMissed(BulletMissedEvent e) {
		back(20);
		scan();
	}
	
	

}
