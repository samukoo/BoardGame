package model.game;

import java.util.List;

import model.units.Unit;

public interface iMatch {

	public abstract void setPlayers(Player player);
	public abstract List<Player> shopUnit(Unit unit);
	public abstract Player endTurn();
	public abstract List<Player> getPlayers();
	public abstract void setCurrent(Player current);
	public abstract Player getCurrentPlayer();
	public abstract int getCurrentPlayerPoints();
	public abstract int getTurnNr();
}