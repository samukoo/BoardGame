package model.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
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
	private int turnNumber;
	private boolean deployPhase;
	private List<Turn> turn = new ArrayList<Turn>();
	private List<Player> players = new ArrayList<Player>();
	
	public Match(){
		turnNumber = 0;
	}

	public Player getCurrentPlayer(){
		Player current;
		/**
		 * Kaksi eri toteutusta. Iterator & for/while. sama asia
		 */
		/*Iterator<Player> list = players.iterator();
		while(list.hasNext()){
			current = list.next();
			if(current.isCurrent()){
				return current;
			}
		}*/
		
		for(Iterator<Player> iter = players.iterator();iter.hasNext();){
			current = iter.next();
			if(current.isCurrent())
				return current;
		}
		
		
		
		return null;
	}
	
	public int incTurn(){
		return turnNumber++;
	}
	
	public String getPlayer(int i){
		return players.get(i).getName();
	}
	
	public List addPlayer(Player player){
		players.add(player);
		return players;
	}

	public Player changeCurrent_player() {
		
		return new Player("foo", true);
	}
	
	
}
