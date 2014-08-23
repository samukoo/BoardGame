package controller;

import java.util.ArrayList;

import model.battlefield.BattleField;
import model.units.Unit;
import model.world.Hex;

public class MouseActions{

	private BattleField bf;
	
	public MouseActions(BattleField bf) {
		this.bf = bf;
	}
 
	public ArrayList<Unit> addUnit(int[]XY){
		
		//Add unit toiminto. pit�� wrapata omaksi luokaksi
		
				int xyLoc[] = new int[2];
				int hexLoc[] = new int[2];
				xyLoc[0] = XY[0];
				xyLoc[1] = XY[1];
				
				for(int i = 0; i<bf.world.size(); i++){
				//iteroidaan oikea hexa	xy pistekoordinaattien mukaan
					Hex hex = bf.world.get(i);
					if(hex.selectHex(xyLoc[0], xyLoc[1]) !=null){
						hexLoc = hex.selectHex(xyLoc[0], xyLoc[1]);
						xyLoc = hex.hexCenter();
					}
				}
				return bf.addUnit(hexLoc, xyLoc);
	}
	
	public void moveUnit(int[]XY){
		
	}

	
	
	
}
