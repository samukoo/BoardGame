package model.units;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ArmyController {

	private Army army = new Army();
		
	public void printAll(){
		List<Unit>armyList;
		armyList = army.getArmyAsList();
		
		int count = 0;
		for(Iterator<Unit> unit = armyList.iterator(); unit.hasNext();){
			Unit item = unit.next();
			count++;
			System.out.println(count +": " + item.getType());
		}
		
		
		
		
		System.out.println("pisteet: " + army.getPoints());
	}
	
	public List addUnits(Unit unit){
		List<Unit>armyList = new ArrayList<Unit>();
		if(army.getPoints()>=unit.getCost()){
		armyList= army.addUnit(unit);	
		army.setPoints(unit);
		}
		printAll();
		return armyList;
	}
	
}
