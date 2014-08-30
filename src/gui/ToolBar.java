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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.SelectedAction;


public class ToolBar extends JPanel implements ActionListener{

	private JButton btn1 = new JButton("AddUnit");
	private JButton btn2 = new JButton("MoveUnit");
	private EventListener event;
	
	public ToolBar(){
		layOutSetup();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if(source == btn1){
			SelectedAction sa = new SelectedAction();
			sa.setAddUnit(true);
			
			event.btnListener(sa);
		}
		if(source == btn2){
			SelectedAction sa = new SelectedAction();
			sa.setMoveUnit(true);
			
			event.btnListener(sa);
		}
		
		
	}
	
	public void setEventListener(EventListener event) {
		this.event = event;
	}

	public void layOutSetup(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		setBackground(Color.gray);
		
////////FIrst row ///////////
		
		gc.weightx = 1;
		gc.weighty = 0.05;
		
//		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(5, 5, 0, 5);
		add(btn1, gc);
/*		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(btn2, gc);
*/	
////////Second row ///////////
		
//		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 10;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(btn2, gc);
/*		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(btn4, gc);		
*/	
		
		
		
		
		
		
	}



	
	
	
	
}
