package model.game;
/**
 * Pelaaja luokka. Tieto pelaajasta, ja hänen joukoista
 */
import model.units.Army;

public class Player {

	private String name;
	boolean current;
	
	public Player(String name, boolean current){
		this.name = name;
		this.current = current;
	}
	
	public String getName(){
		return name;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}
	
	
}
