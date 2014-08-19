package model.battlefield;

import java.awt.Graphics;
import java.util.ArrayList;

import model.units.Infantry;
import model.units.Tank;
import model.units.Unit;
import model.world.World;

public class BattleField extends World {
//Luokan resurssit
	public ArrayList<Unit> unitList = new ArrayList<Unit>();

	//konst.
	public BattleField(){
	}
	
	
	public ArrayList<Unit> addUnit(){
		unitList.add(new Tank(2,3));
		unitList.add(new Infantry(2,4));
		return unitList;
	}
	
	public String moveUnit(int y, int x){
		//1: ei saa liikkua mereen
		if(!getWorldType(y,x).equals("s") && isNextHex(y, x)){
			unitList.get(0).move(x, y);		//index nolla!
			return "ok";}
		
		else{return "Hexaan ei voi liikkua";}
	}
	
	public boolean isNextHex(int y,int x){
		int xO=3;
		int res = xO-x;
		
		if( res < 0){
			res=res*-1;		
			}
		if (res > 1){
			return false;
		}
		else 
			return true;
	
	}
		
	
	
	
	
	
	public String getWorldType(int y, int x){
		for(int i = 0; i<world.size(); i++){
			if(world.get(i).getyId() == y && world.get(i).getxId() == x){
				return world.get(i).getType();
			}
		}
		return null;
	}
	
	public void drawUnits(Graphics g){
		
	}
}
