package gui;

import javax.swing.JFrame;

import controller.BoardController;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private BoardController bC = new BoardController();
	
	public MainFrame() throws InterruptedException{
		
		new JFrame("HexBoard");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(bC);
		setVisible(true);
	
		while(true){
			bC.updateGameLogic();
			bC.repaint();
			Thread.sleep(1000);
		}
	}
}
