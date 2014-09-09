package model.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.units.Unit;

/**
 * @author kotissa
 * Match luokka.
 * Tehtavat:
 * Aloittaa ja lopettaa itse taistelun
 * Pitaa kirjaa vuorojen maarasta 
 * Hoitaa vuoron vaihdon
 *
 */
public class Match implements iMatch{

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
	
	@Override
	public void setPlayers(Player player) {
		if(current ==  null){
			this.current=player;
		}
		players.add(player);
	}

	@Override
	public List<Player> shopUnit(Unit unit){
		Player current = getCurrentPlayer();
		for(Player player : players)
			if(player.equals(current)){
				player.buyUnit(unit);
				return players;
			}
		return null;
	}
	
	@Override
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
	
	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void setCurrent(Player current) {
		this.current = current;
	}
	
	@Override
	public Player getCurrentPlayer() {
		return current;
	}

	@Override
	public int getCurrentPlayerPoints() {
		return current.getPoints();
	}

	@Override
	public int getTurnNr() {
		return turnNr;
	}
}
