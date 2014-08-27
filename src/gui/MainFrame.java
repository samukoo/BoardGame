package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.BoardController;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private BoardController bC = new BoardController();
	private ToolBar tb = new ToolBar();
	
public MainFrame() throws InterruptedException{
		
		new JFrame("HexBoard");
		setLayout(new BorderLayout());
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		add(new JScrollPane(bC), BorderLayout.CENTER);
		add(new JScrollPane(tb), BorderLayout.WEST);
		
		setVisible(true);
		while(true){
			bC.updateGameLogic();
			bC.repaint();
			Thread.sleep(1000);
		}
	}
		
        
        
			
			
		
        
        
	}





//////////
/*

package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.BoardController;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private BoardController bC = new BoardController();
	
	private JPanel panel;
	
	
	
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


*/









