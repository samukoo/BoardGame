package model.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kotissa
 * Match luokka.
 * Teht‰v‰t:
 * Aloittaa ja lopettaa itse taistelun
 * Pit‰‰ kirjaa vuorojen m‰‰r‰st‰ 
 * Hoitaa vuoron vaihdon
 *
 */
public class Match{

	private List<Player>players = new ArrayList<Player>();
	private Player current = null;
	private int turnNr = 0;
	
	public Match(){
	}
	
	public Match(String arg){
	
		Player player1 = new Player("Sauli");
		Player player2 = new Player("Foobar");
		setPlayers(player1);
		setPlayers(player2);
	}
	
	public void setPlayers(Player player) {
		if(current ==  null){
			this.current=player;
		}
		players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getCurrentPlayer() {
		return current;
	}

	public Player endTurn() {
		turnNr++;
		for(Player player : players){
			Player candidate = player;
			if(!current.equals(candidate)){
				setCurrent(candidate);
				return current;
			}
		}
		return null;
	}

	public void setCurrent(Player current) {
		this.current = current;
	}

	public int getCurrentPlayerPoints() {
		return current.getPoints();
	}

	public int getTurnNr() {
		return turnNr;
	}
	
	
}
