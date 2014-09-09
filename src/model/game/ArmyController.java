package model.game;

import model.units.Unit;


public class ArmyController extends Army{
	
	public Army getArmy(){
		return this;
	}
	
	public int checkPoints(int points, Unit unit)throws Exception{

		if(points >= unit.getCost()){
			points=points-unit.getCost();
			addUnit(unit);
		}
			
		else{
			throw new Error("Not enough points!");
		}
	return points;
	}
}
