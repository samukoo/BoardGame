package model.battlefield;

import java.util.ArrayList;

import model.units.Infantry;
import model.units.Tank;
import model.units.Unit;
import model.world.World;

public class BattleField {

	public ArrayList<Unit> unitList = new ArrayList();
	
	
	
	
	public void addUnit(){
		
		unitList.add(new Tank(2,3));
		unitList.add(new Infantry(2,4));
		
	}
	

}
