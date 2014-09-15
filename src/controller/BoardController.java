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
import model.game.Army;
import model.game.Match;
import model.units.Infantry;
import model.units.Tank;
import model.units.Unit;
import model.units.UnitTypes;

public class BoardController extends JPanel implements MouseListener{
	
	public BoardControllerData data = new BoardControllerData(new int[2], false,
			null);

	public BoardController(Army army, Field field, Match match){
		this.data.army = army;
		this.data.field = field;
		this.data.match = match;
		
		
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
		data.field.drawWorld(g2d);
		data.field.drawUnits(g2d);
	}
	//Armeijan purku ja asetus kentalle
	public void setArmy(){
		List<Unit>recruits = data.match.getCurrentPlayer().getArmy().getArmyAsList();	//Puretaan armeija recruiment listaan uniteiksi
			recruits.get(0).setXyHex(data.selectedHex);
			data.field.orderToField(!recruits.isEmpty() ? recruits.get(0) : null ); //jos lista ei ole tyhjä, komenna ensimmainen yksikko kentalle
			recruits.remove(0);			//ja poista se listasta
	}
	
	//tulostusfunktio
	public void showArmy(){
		Iterator<Unit> res = data.army.getArmyAsList().iterator();
		while(res.hasNext())
			System.out.println(res.next().getType());
	}

	//valitaan hexa ja sen sisaltama mahdollinen unit
	private void selectHexContent(MouseEvent e) {
		
		if(data.index==null||!data.move){
			data.selectedHex = data.field.selectHex(new Point(e.getPoint()));
			data.index = data.field.selectUnit(data.selectedHex);
		}	
		if(data.index!=null&&data.move){
			moveUnit(data.index,new Point(e.getPoint()));
			setMove(false);
		}
		if(data.index==null&&data.move){
			data.selectedHex = data.field.selectHex(new Point(e.getPoint()));
			data.index = data.field.selectUnit(data.selectedHex);
		}
	}

	//Move funktio 
	public int[] moveUnit(Integer index, Point point){ //Index on valitun unitin index army listassa
		int[] destHex = data.field.selectHex(point);
		data.field.moveUnit(index, destHex);
		return destHex;
	}
	
	public void shopUnit(UnitTypes unit){
		
		switch (unit) {
		case Tank :
			data.match.shopUnit(new Tank(data.match.getCurrentPlayer().getOwner()));
			break;
		
		case Infantry :
			data.match.shopUnit(new Infantry(data.match.getCurrentPlayer().getOwner()));
			break;
			
		default:
			break;
		}
	}
	
	//Getterit ja setterit
	
	public boolean isMove() {
		return data.move;
	}

	public void setMove(boolean move) {
		this.data.move = move;
	}
	
	//mouselistener. siirrä omaan luokkaan
	
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
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
}