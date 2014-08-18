package model.battlefield;

import java.awt.Graphics;
import java.util.ArrayList;

import model.units.Infantry;
import model.units.Tank;
import model.units.Unit;
import model.world.World;

public class BattleField {
//Luokan resurssit
	public World w;
	public ArrayList<Unit> unitList = new ArrayList<Unit>();

	//konst.
	public BattleField(World w){
		this.w = w;
	}
	
	
	public void addUnit(){
		unitList.add(new Tank(2,3));
		unitList.add(new Infantry(2,4));
	}
	
	public String moveUnit(int y, int x){
		//1: ei saa liikkua mereen
		if(!getWorldType(y,x).equals("s")){
			unitList.get(0).move(x, y);
			return "ok";}
		else{return "Hexaan ei voi liikkua";}
	
	}
	
	public String getWorldType(int y, int x){
		
		for(int i = 0; i<w.world.size(); i++){
			if(w.world.get(i).getyId() == y && w.world.get(i).getxId() == x){
				return w.world.get(i).getType();
			}
		}
		return null;
	}
	
	
	
	
	
	public void paint(Graphics g){
		
	}
}
