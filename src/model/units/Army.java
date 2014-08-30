package model.units;

import java.util.ArrayList;

public class Army {

	public int armySize = 0;
	public ArrayList<Unit> army = new ArrayList<Unit>();

	public Army(){
		
	}
	
	public void addArmyUnit(Unit unit){
		army.add(unit);
		armySize++;
		
	}
	
	
	
}
