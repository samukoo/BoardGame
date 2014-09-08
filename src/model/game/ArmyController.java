package model.game;

import model.units.Unit;


public class ArmyController extends Army{

	public Army getArmy(){
		return this;
	}
	
	public int checkPoints(int points, Unit mockTank)throws Exception{

		if(points >= mockTank.getCost()){
			points=points-mockTank.getCost();
			addUnit(mockTank);
		}
			
		else{
			throw new Error("Not enough points!");
		}
	return points;
	}
}
