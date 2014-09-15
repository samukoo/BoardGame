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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import model.units.UnitTypes;


public class ToolBar extends JPanel implements ActionListener{
	
	private Color bgColor = Color.lightGray;
	private JButton deploy;
	private JButton move;
	private JButton shoot;
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
	
	
	public ToolBar(){
		
		deploy = new JButton("DeployUnit");
		move = new JButton("MoveUnit");
		shoot = new JButton("Shoot!");
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
		
		
		//ToDo: listener BC controllerilta mainframelle, joka v‰litt‰‰ current player tiedon t‰nne funktiolle joka p‰ivitt‰‰ infon
//		turnNr.setText("Turn: "+match.getTurnNr());
//		playerName.setText("Player " + match.getCurrentPlayer().getOwner() + " has control");
		
		
		deploy.addActionListener(this);
		move.addActionListener(this);
		shoot.addActionListener(this);
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
			event.turnListener();
		}
		
		if(e.getSource() == move){
			boolean isMove = true;
			event.moveListener(isMove);
		}
		if(e.getSource() == shoot){
			System.out.println("KA-BOOOOM!");
		}
		
		if(e.getSource() == buy){
			UnitTypes unit =  UnitTypes.fromString(unitGroup.getSelection().getActionCommand());	//Treidataan napin getAction String ENUM:KSI (Ei jaksanut p‰ivitt‰‰ java 8:)

			event.buyListener(unit);
		}
		if(e.getSource() == deploy){
			event.deployListener();
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
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0, 5, 0, 5);
		add(shoot, gc);

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
