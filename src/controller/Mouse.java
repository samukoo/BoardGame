package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.battlefield.BattleField;

public class Mouse implements MouseListener {

	private BattleField bf;
	private MouseActions mouseActions = new MouseActions();
	UserAction userAction = new UserAction();
	int[]XY=new int[2];	
	
	public Mouse(BattleField bf){
		this.bf = bf;
	}
	
	public void setSelection(UserAction userAction){
		this.userAction = userAction;
	}
	



	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		XY[0]=e.getX();
		XY[1]=e.getY();
		
		
		if(e.getButton() == MouseEvent.BUTTON1 && userAction.isAddUnit()){
			bf = mouseActions.addUnit(bf , XY);
		}
		if(e.getButton() == MouseEvent.BUTTON1 && userAction.isMoveUnit()){
			bf = mouseActions.moveUnit(bf, XY);
		}
		else{
			bf = mouseActions.selectHex(bf, XY);
		}
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
