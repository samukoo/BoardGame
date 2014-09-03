package model.battlefield;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.units.Unit;
import model.world.Hex;
import model.world.World;

public class Field extends World{

	private List<Unit>deployedUnits = new ArrayList<Unit>();
	
	public List<Unit> orderToField(Unit unit){ 
		deployedUnits.add(unit);
		return deployedUnits;
	}
	
	public void printDeployedUnits(){
		Iterator<Unit>units = deployedUnits.iterator();
		while(units.hasNext()){
			System.out.println("Field units: " + units.next().getType());
		}
	}
	
	public void drawUnits(Graphics g){
		for(Unit unit : deployedUnits){
			int[] center = getHexCenterPosition(unit.getXyHex()); //laskeskellaan hexan center unitin piirtoa varten
			int[] dim = unit.getImageDimension(); //pyydet‰‰n kuvan dimensiot, ett‰ voidaan keskitt‰‰ kuva keskelle hexaa
			g.drawImage(unit.getImage(),
						center[0]-dim[0]/2,		//x piste
						center[1]-dim[1]/2,		//y piste
						null);
		}
	}
}














