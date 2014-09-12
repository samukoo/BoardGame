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

import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.stubbing.answers.ThrowsException;

import model.battlefield.Field;
import model.game.Army;
import model.game.Match;
import model.units.Unit;

public class BoardController extends JPanel implements MouseListener{
	
	private Army army;
	private Field field = new Field();
	private int selectedHex[] = new int[2];
	boolean move = false;
	Integer index = null;
	
	public BoardController(){
		
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		setPreferredSize(new Dimension(800, 630));
		addMouseListener(this);
	}
	
	//piirto
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		field.drawWorld(g2d);
		field.drawUnits(g2d);
	}
	//Armeijan purku ja asetus kentalle
	public void setArmy(Army army){
		List<Unit>recruits = army.getArmyAsList();	//Puretaan armeija recruiment listaan uniteiksi
		
			recruits.get(0).setXyHex(selectedHex);
			field.orderToField(!recruits.isEmpty() ? recruits.get(0) : null ); //jos lista ei ole tyhj�, komenna ensimmainen yksikk� kentalle
			recruits.remove(0);			//ja poista se listasta
	}
	
	//tulostusfunktio
	public void showArmy(){
		Iterator<Unit> res = army.getArmyAsList().iterator();
		while(res.hasNext())
			System.out.println(res.next().getType());
	}

	//valitaan hexa ja sen sisaltama mahdollinen unit
	private void selectHexContent(MouseEvent e) {
		
		if(index==null||!move){
		selectedHex = field.selectHex(new Point(e.getPoint()));
			System.out.println("X: " +selectedHex[0] + " Y: " +selectedHex[1]); //debugin takia
		index = field.selectUnit(selectedHex);
			System.out.println("index: "+index + " move: " + move);
		}	
		if(index!=null&&move){
			moveUnit(index,new Point(e.getPoint()));
			setMove(false);
		}
		if(index==null&&move){
			selectedHex = field.selectHex(new Point(e.getPoint()));
			System.out.println("X: " +selectedHex[0] + " Y: " +selectedHex[1]); //debugin takia
		index = field.selectUnit(selectedHex);
			System.out.println("index: "+index);
		}
	}

	//Move funktio 
	public void moveUnit(Integer index, Point point){
		int[] destHex = field.selectHex(point);
		field.moveUnit(index, destHex);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getterit ja setterit
	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}
	
	//mouselistener. siirr� omaan luokkaan
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			selectHexContent(e);
			
		}
		
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