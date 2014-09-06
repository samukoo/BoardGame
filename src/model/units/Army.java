package model.units;
import java.util.ArrayList;
import java.util.List;

import model.game.Player;

/**
 * @author kotissa
 * This Class describes the army. Player has certain amount of points to spend in units
 * For example. Player has 5 points to spend and a tank cost 2 points. Player can have two tanks and spend
 * one point left to one Infantry unit. Or the player can just buy 5 infantry units and hope for the best.
 */

public class Army{

	private int armySize = 0;
	private int armyPoints = 5;
	private List<Unit> army = new ArrayList<Unit>();
	
	protected List<Unit> addUnit(Unit unit){
		army.add(unit);
		return army;
	}

	public List getArmyAsList(){
		return army;
	}
		
	public int getPoints(){
		return armyPoints;
	}
	
	protected void setPoints(Unit unit){
		armyPoints = armyPoints - unit.getCost();
	}
		
	



}
