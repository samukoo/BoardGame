/*
package controller;

import model.battlefield.BattleField;
import model.world.Hex;

public class MouseActions{


	public BattleField selectHex(BattleField bf, int[] XY) {
		for(int i=0;i<bf.world.size();i++){
//			bf.world.get(i).selectHex(XY);
		}
		return bf;
	}
	
	public BattleField addUnit(BattleField bf, int[] XY){
		
		int xyLoc[] = new int[2];
		int hexLoc[] = new int[2];
		xyLoc[0] = XY[0];
		xyLoc[1] = XY[1];
		
		for(int i = 0; i<bf.world.size(); i++){
		//iteroidaan oikea hexa	xy pistekoordinaattien mukaan
			Hex hex = bf.world.get(i);
//			if(hex.selectHex(xyLoc) !=null){
//				hexLoc = hex.selectHex(xyLoc);
				xyLoc = hex.hexCenter();
			}
		}
//		bf.addUnit(hexLoc, xyLoc);
//		return bf;
//	}

public BattleField moveUnit(BattleField bf, int[] xY){
	
	int[]purkka = new int[2];
	
	for(int i=0; i < bf.world.size(); i++){
	
	if(bf.world.get(i).hexHit(xY[0], xY[1])!=null){
	purkka = bf.world.get(i).hexHit(xY[0], xY[1]);
	bf.moveUnit(purkka[1],purkka[0]);
	}
	}
	return bf;
}


	
}
*/