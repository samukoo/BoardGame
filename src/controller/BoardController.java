package controller;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.battlefield.BattleField;

public class BoardController extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BattleField bf;
	
	public BoardController(){
		bf = new BattleField();
		addMouseListener(new Mouse(bf));
		
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		setPreferredSize(new Dimension(800, 630));
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		bf.drawWorld(g2d);
		bf.drawUnits(g2d);
	}
	public void updateGameLogic(){
		

		
	}
}