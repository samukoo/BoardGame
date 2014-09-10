package model.battlefield;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
			int[] dim = unit.getImageDimension(); //pyydetaan kuvan dimensiot, etta voidaan keskittaa kuva keskelle hexaa
			int extraWidth = 0;
			
			int h = dim[1];
			int w = unit.getOwner()=="Foobar" ? -dim[0]:dim[0]; //jos player 2, flippaa kuva -> "-dim[0]". dim[0] on kuvan width
			if(unit.getOwner()=="Foobar"){
				extraWidth=dim[0];
			}
			
			g.drawImage(unit.getImage(),
						center[0]-dim[0]/2 + extraWidth,	//x piste (lis‰t‰‰n extraWidth jos player2 koska kuva flipataan horisontaalisti 
						center[1]-dim[1]/2,		//y piste
						w,h,	//kuvan width ja height
						null);
		}
	}

	public Unit selectUnit(int[] hex) {
		
		for(Unit unit : deployedUnits){
			if(hex.equals(unit.getXyHex()))
				return unit;
		}
		return null;
	}
}














