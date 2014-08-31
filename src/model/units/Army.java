package model.units;

import java.util.ArrayList;

public class Army {

	public int armySize = 0;
	public int armyPoints = 5;
	public ArrayList<Unit> army = new ArrayList<Unit>();

	public Army(){
		
	}
	
	public void addArmyUnit(Unit unit){
		if(checkPointsLeft(unit)){
		army.add(unit);
		armySize++;
		}
	}
	
	public boolean checkPointsLeft(Unit unit){
		if(armyPoints > unit.getCost()){
			armyPoints = armyPoints - unit.getCost();
			return true;
		}
		else{
			
			System.out.println("pisteet ei riitä");
			return false;
			}
		
	}
	
	
}
