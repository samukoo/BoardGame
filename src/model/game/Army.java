package model.game;
import java.util.ArrayList;
import java.util.List;

import model.units.Tank;
import model.units.Unit;

/**
 * @author kotissa
 * This Class describes the army. Player has certain amount of points to spend in units
 * For example. Player has 5 points to spend and a tank cost 2 points. Player can have two tanks and spend
 * one point left to one Infantry unit. Or the player can just buy 5 infantry units and hope for the best.
 */

public class Army{

	private List<Unit>army = new ArrayList<Unit>();
	private String owner;
	
	public int addUnit(Unit unit) {
		army.add(unit);
		return army.size();
	}

	public int getArmySize() {
		return army.size();
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public List<Unit> getArmyAsList() {
		
		return army;
	}
	
	

}
