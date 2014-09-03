package controller;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.battlefield.Field;
import model.units.Army;
import model.units.Unit;

public class BoardController extends JPanel implements MouseListener{
	
	private Army army;
	private Field field = new Field();
	private int selectedHex[] = new int[2];
	
	
	public BoardController(){
		
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		setPreferredSize(new Dimension(800, 630));
		addMouseListener(this);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		field.drawWorld(g2d);
		field.drawUnits(g2d);
	}
	
	public void setArmy(Army army){
		List<Unit>recruits = army.getArmyAsList();	//Puretaan armeija recruiment listaan uniteiksi
		
		recruits.get(0).setXyHex(selectedHex);
		
		
		field.orderToField(!recruits.isEmpty() ? recruits.get(0) : null ); //jos lista ei ole tyhjä, komenna ensimmäinen yksikkö kentälle
		recruits.remove(0);			//ja poista se listasta
	
		
	
	}
	
	public void showArmy(){
		Iterator<Unit> res = army.getArmyAsList().iterator();
		while(res.hasNext())
			System.out.println(res.next().getType());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		selectedHex = field.selectHex(new Point(e.getPoint()));
		System.out.println("X: " +selectedHex[0] + " Y: " +selectedHex[1]);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}