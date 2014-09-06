package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainMenu extends JFrame{
	
	private JFrame mainMenu;
	private JLabel name;
	private JTextField nameField; 
	private JPanel panel;
	private JRadioButton tank;
	private JRadioButton infantry;
	private JRadioButton artillery;
	private ButtonGroup unitGroup;
	
	
	public MainMenu(){
		
		mainMenu = new JFrame("Main Menu V.01");
		setSize(1040, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JLabel("MAIN MENU"), BorderLayout.NORTH);
		add(menuPanel(), BorderLayout.CENTER);
	
		
		setVisible(true);
	
	
	
	}

	public JPanel menuPanel(){
		//Elementit
		Color menuColor = Color.orange;
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		tank = new JRadioButton();
		tank.setBackground(menuColor);
		infantry = new JRadioButton();
		infantry.setBackground(menuColor);
		artillery = new JRadioButton();
		artillery.setBackground(menuColor);
		
		unitGroup  = new ButtonGroup();
		
		unitGroup.add(tank);
		unitGroup.add(infantry);
		unitGroup.add(artillery);
		
		
		GridBagConstraints gc = new GridBagConstraints();
		
		panel.setBackground(menuColor);
		
		name = new JLabel("Player name:");
		nameField = new JTextField(10);
		
		//First Row
		
		gc.weighty = 0.1;
		
		gc.gridx=0;
		gc.gridy=0;
		panel.add(name,gc);
		
		gc.gridx=1;
		panel.add(nameField,gc);
		
		//second row
		
		gc.weighty = 0.1;
		
		gc.gridx=0;
		gc.gridy++;
		panel.add(new JLabel("Tank"),gc);
		
		gc.gridx=1;
		panel.add(tank,gc);
		
		//third row
		
		gc.weighty = 0.1;
				
		gc.gridx=0;
		gc.gridy++;
		panel.add(new JLabel("Infantry"),gc);
				
		gc.gridx=1;
		panel.add(infantry,gc);
				
		//fourth row
		
		gc.weighty = 0.1;
			
		gc.gridx=0;
		gc.gridy++;
		panel.add(new JLabel("Artillery"),gc);
				
		gc.gridx=1;
		panel.add(artillery,gc);
		
		//fifth row
		
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridx=0;
		gc.gridy++;
		panel.add(new JButton("Buy unit"),gc);
						
				
		
		
		
		
		
		
		
		return panel;
	}
}
