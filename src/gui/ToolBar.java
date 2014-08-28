/**
 * @author kotissa
 * Toolbar element. This contains all control buttons for the board. 
 * Uses Grid Bag layout.
 *
 */

package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ToolBar extends JPanel {

	private JButton btn1 = new JButton("Testi0");
	private JButton btn2 = new JButton("Testi2");
	private JButton btn3 = new JButton("Testi3");
	private JButton btn4 = new JButton("Testi4");
	
	private JScrollPane scroll = new JScrollPane();
	
	
	public ToolBar(){
		layOutSetup();
		buttonActions();
		
	}
	
	public void buttonActions(){
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn1 printtaa!");
			}
		});
	}

	
	
	
	
	
	
	public void layOutSetup(){
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		setBackground(Color.gray);
		
////////FIrst row ///////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 5, 0, 5);
		add(btn1, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(btn2, gc);
		
////////Second row ///////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(btn3, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(btn4, gc);		
		
		
		
		
		
		
		
	}
	
	
	
}
