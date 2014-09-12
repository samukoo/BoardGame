/**
 * @author kotissa
 * Toolbar element. This contains all control buttons for the board. 
 * Uses Grid Bag layout.
 *
 */

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import model.game.Army;
import model.game.Match;
import model.game.Player;
import model.game.iMatch;
import model.units.Infantry;
import model.units.Tank;


public class ToolBar extends JPanel implements ActionListener{
	
	private Color bgColor = Color.lightGray;
	private JButton deploy;
	private JButton move;
	private JButton buy;
	private JButton endTurn;
	private JRadioButton tank;
	private JRadioButton infantry;
	private ButtonGroup unitGroup;
	private JLabel inventory;
	private JLabel playerName;
	private JLabel turnNr;
	private JTextArea textArea;
	private EventListener event;
	private iMatch match;
	
	
	public ToolBar(){
		
		deploy = new JButton("DeployUnit");
		move = new JButton("MoveUnit");
		buy = new JButton("Buy Unit");
		endTurn = new JButton("End Turn");
		
		tank = new JRadioButton("Tank");
		tank.setBackground(bgColor);
		infantry = new JRadioButton("Infantry");
		infantry.setBackground(bgColor);
		
			tank.setSelected(true);
		tank.setActionCommand("Tank");
		infantry.setActionCommand("Infantry");
		unitGroup = new ButtonGroup();
		unitGroup.add(tank);
		unitGroup.add(infantry);
		inventory = new JLabel("Inventory:");
		
		textArea = new JTextArea(3,7);
		textArea.setBorder(BorderFactory.createEtchedBorder());
		
		playerName = new JLabel();
		turnNr = new JLabel("Turn: 2");
		turnNr.setFont(new Font("ITALIC", Font.BOLD, 14));
		match = new Match("Alusta peli");
		
		turnNr.setText("Turn: "+match.getTurnNr());
		playerName.setText("Player " + match.getCurrentPlayer().getOwner() + " has control");
		
		
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
		if(e.getSource() == endTurn){
			match.endTurn();
			turnNr.setText("Turn: "+match.getTurnNr());
			playerName.setText("Player " + match.getCurrentPlayer().getOwner() + " has control");
		}
		
		if(e.getSource() == move){
			System.out.println("move unit");
			boolean isMove = true;
			event.moveListener(isMove);
		}
		if(e.getSource() == buy){
		
			String unit = unitGroup.getSelection().getActionCommand();
			if(unit == "Tank"){
				Tank tank = new Tank(match.getCurrentPlayer().getOwner());
				match.shopUnit(tank);
			}
			if(unit == "Infantry"){
				Infantry infantry = new Infantry(match.getCurrentPlayer().getOwner());
				match.shopUnit(infantry);
			}
		}
		if(e.getSource() == deploy){
			Army army = match.getCurrentPlayer().getArmy();
			event.deployListener(army);
			}
		}
	
	public void layOutSetup(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		setBackground(bgColor);
		
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
		add(tank, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(infantry, gc);
	
////////Fourth row ///////////
		gc.weightx = 1;
		gc.weighty = 0.05;
		
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
		
////////Fourth row ///////////
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(turnNr, gc);

		
	
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
