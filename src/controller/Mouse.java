package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.battlefield.BattleField;
import model.world.Hex;

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

		//mouseActions.selectHex(XY);
		bf = mouseActions.addUnit(bf , XY);
		//mouseActions.moveUnit(XY);
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
