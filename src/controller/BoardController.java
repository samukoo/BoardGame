package controller;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import model.battlefield.BattleField;
import model.world.World;


public class BoardController extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private World world;
	private BattleField bf;
	
	public BoardController(){
		world = new World();
		bf = new BattleField(world);
		addMouseListener(new Mouse(world));
	
	//Kehitystestit:
	
		
		
		bf.addUnit();
		
		System.out.println(bf.getWorldType(0, 4));
		System.out.println(bf.moveUnit(0, 3));
		
		for(int i =0; i<bf.unitList.size();i++)
		System.out.println(bf.unitList.get(i).getType() + " Y:"+bf.unitList.get(i).getyLocation() + " X:" + bf.unitList.get(i).getxLocation());
	
	
	
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		world.paint(g2d);
		bf.paint(g2d);
	}
	public void updateGameLogic(){
		
		
		
	}
}