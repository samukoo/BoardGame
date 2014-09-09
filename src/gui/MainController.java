package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.game.Army;
import controller.BoardController;

public class MainController extends JFrame{

	private static final long serialVersionUID = 1L;
	private BoardController bC = new BoardController();
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
			public void btnListener(Army army) {
				bC.setArmy(army);				
			}
		});
		
		setVisible(true);
		while(true){
			bC.repaint();
			Thread.sleep(1000);
		}
	}
}


