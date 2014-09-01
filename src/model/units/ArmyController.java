package model.units;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ArmyController {

	private Army army = new Army();
	List<Unit>armyList = new ArrayList<Unit>();
	
	public void printAll(){
		armyList = army.getArmyAsList();
		int count = 0;
		for(Iterator<Unit> unit = armyList.iterator(); unit.hasNext();){
			Unit item = unit.next();
			count++;
			System.out.println(count +": " + item.getType());
		}
	}
	
	public List<Unit> addUnits(Unit unit){
		if(army.getPoints()>=unit.getCost()){
		armyList= army.addUnit(unit);	
		army.setPoints(unit);
		}
		printAll();
		return armyList;
	}
	
	public Army getArmy(){
		return army;
	}
	
	
	
}
