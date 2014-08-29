package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.battlefield.BattleField;

public class Mouse implements MouseListener {

	private BattleField bf;
	private MouseActions mouseActions = new MouseActions();
	int[]XY=new int[2];	
	
	public Mouse(BattleField bf){
		this.bf = bf;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		XY[0]=e.getX();
		XY[1]=e.getY();
		if(e.getButton() == MouseEvent.BUTTON1 ){
			bf = mouseActions.addUnit(bf , XY);
		}
		if(e.getButton() == MouseEvent.BUTTON3 ){
			bf = mouseActions.moveUnit(bf, XY);
		}
		//mouseActions.moveUnit(XY);
		//mouseActions.selectHex(bf, XY);
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
