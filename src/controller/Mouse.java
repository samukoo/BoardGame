package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.battlefield.BattleField;
import model.world.Hex;

public class Mouse implements MouseListener {

	private BattleField bf;
	//private World world;
	private JMenuItem menu = new JMenuItem("testiMenu");
	private JPopupMenu popup = new JPopupMenu();
	
	
	
	public Mouse(BattleField bf){
		this.bf = bf;
		popup.add(menu);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3){
			popup.setLocation(e.getX(), e.getY());
			popup.setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xyLoc[] = new int[2];
		int hexLoc[] = new int[2];
		xyLoc[0] = e.getX();
		xyLoc[1] = e.getY();
		
		for(int i = 0; i<bf.world.size(); i++){
		//iteroidaan oikea hexa	
			Hex hex = bf.world.get(i);
			if(hex.selectHex(xyLoc[0], xyLoc[1]) !=null){
				hexLoc = hex.selectHex(xyLoc[0], xyLoc[1]);
				xyLoc = bf.world.get(i).hexCenter();
			}
		
		}
			
			bf.addUnit(hexLoc, xyLoc);
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
