package model.battlefield;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.units.Tank;
import model.units.Unit;

public class Field {

	private List<Unit>foo = new ArrayList<Unit>();
	
	public Field(){
		
	}
	
	public List orderToField(Unit unit){
		
		foo.add(unit);
		
		return foo;
	}
	
	
	
	public void printFoo(){
		 
		for(Iterator<Unit>bar = foo.iterator();bar.hasNext();){
			System.out.println(bar.next().getType());
		}
		
	}
	
	public void drawUnits(Graphics2D g2d) {
		g2d.drawRect(200, 200, 200, 200);
		
	}

	
	
	
}
