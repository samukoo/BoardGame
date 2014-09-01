package controller;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.battlefield.Field;
import model.units.Army;
import model.units.Unit;

public class BoardController extends JPanel{
	
	private Army army;
	private Field field = new Field();
	
	public BoardController(){
		
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		setPreferredSize(new Dimension(800, 630));
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		bf.drawWorld(g2d);
//		bf.drawUnits(g2d);
		field.drawUnits(g2d);
	}
	
	public void setArmy(Army army){
		this.army = army;
		List<Unit>units = army.getArmyAsList();
		field.orderToField(units.get(0));
		units.remove(0);
		field.printFoo();
	}
	
	public void showArmy(){
		List<Unit>units = army.getArmyAsList();
		for(Iterator<Unit>res = units.iterator();res.hasNext();){
			System.out.println(res.next().getType());
		}
	}
	
}