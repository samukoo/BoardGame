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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import model.game.Match;
import model.game.Player;
import model.units.Army;
import model.units.ArmyController;
import model.units.Infantry;
import model.units.Tank;


public class ToolBar extends JPanel implements ActionListener{
	
	private JButton deploy;
	private JButton move;
	private JButton buy;
	private JButton endTurn;
	private JRadioButton rad1;
	private JRadioButton rad2;
	private ButtonGroup unitGroup;
	private JLabel inventory;
	private JLabel playerName = new JLabel("Player 1");
	private JTextArea textArea;
	private ArmyController armyController;
	private EventListener event;
	private Match match;
	
	
	public ToolBar(){
		
		deploy = new JButton("DeployUnit");
		move = new JButton("MoveUnit");
		buy = new JButton("Buy Unit");
		endTurn = new JButton("End Turn");
		rad1 = new JRadioButton("Tank");
		rad2 = new JRadioButton("Infantry");
		rad1.setSelected(true);
		rad1.setActionCommand("Tank");
		rad2.setActionCommand("Infantry");
		unitGroup = new ButtonGroup();
		unitGroup.add(rad1);
		unitGroup.add(rad2);
		inventory = new JLabel("Inventory:");
		textArea = new JTextArea(3,7);
		armyController = new ArmyController();
		match = new Match();
		
		
		
		deploy.addActionListener(this);
		move.addActionListener(this);
		buy.addActionListener(this);
		endTurn.addActionListener(this);
		
		layOutSetup();
	}
	
	public void setEventListener(EventListener event) {
		this.event = event;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == move)
			System.out.println("move unit");
		
		if(e.getSource() == endTurn){
			
			match.getCurrentPlayer();
		}
		
		if(e.getSource() == buy){
		
			String unit = unitGroup.getSelection().getActionCommand();
			if(unit == "Tank"){
				Tank tank = new Tank();
				armyController.addUnits(tank);
			}
			if(unit == "Infantry"){
				Infantry infantry = new Infantry();
				armyController.addUnits(infantry);
			}
		}
		if(e.getSource() == deploy){
			Army res = armyController.getArmy();
			event.btnListener(res);
		}
	}
	
	
	
	public void layOutSetup(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		setBackground(Color.gray);
		
////////FIrst row ///////////
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(playerName, gc);
		
		
////////FIrst +1 row ///////////
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(deploy, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(move, gc);
////////Second row ///////////
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(buy, gc);

////////Third row ///////////
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(rad1, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(rad2, gc);
	
////////Fourth row ///////////
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(inventory, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(textArea, gc);
	
////////Fifth row ///////////
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(endTurn , gc);
	}
}
