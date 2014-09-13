package controller;

import gui.EventListener;
import gui.ToolBar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.battlefield.Field;
import model.game.Army;
import model.game.Match;

public class MainController extends JFrame{

	private static final long serialVersionUID = 1L;
	private BoardController bC = new BoardController(new Army(), new Field(), new Match("arg"));
	private ToolBar tb = new ToolBar();
	
public MainController() throws InterruptedException{
		
		new JFrame("HexBoard");
		setLayout(new BorderLayout());
		setSize(1040, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JScrollPane(bC), BorderLayout.CENTER);
		add(new JScrollPane(tb), BorderLayout.WEST);
		
		tb.setEventListener(new EventListener() {
			
			@Override
			public void deployListener() {
				bC.setArmy();				
			}

			@Override
			public void moveListener(boolean isMove) {
				bC.setMove(isMove);
				System.out.println("move: "+bC.isMove());
			}

			@Override
			public void turnListener() {
				bC.match.endTurn();
			}

			@Override
			public void buyListener(String unit) {
				bC.shopUnit(unit);
			}
		});
		
		setVisible(true);
		while(true){
			bC.repaint();
			Thread.sleep(100);
		}
	}
}


