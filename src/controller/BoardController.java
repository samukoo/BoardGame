package controller;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import model.battlefield.BattleField;
import model.units.Tank;
import model.world.World;


public class BoardController extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private World world;
	private BattleField bf;
	private Mouse mouse;
	
	public BoardController(){
		world = new World();
		bf = new BattleField();
		addMouseListener(new Mouse(world));
	
	//Kehitystestit:
	
		bf.addUnit();
		for(int i =0; i<bf.unitList.size();i++)
		System.out.println(bf.unitList.get(i).getType() + " Y:"+bf.unitList.get(i).getyLocation() + " X:" + bf.unitList.get(i).getxLocation());
	
	
	
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		world.paint(g2d);
	}
	public void updateGameLogic(){
		
		
		
	}
}