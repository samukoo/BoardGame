package gui;

import model.game.Army;
import model.units.UnitTypes;

public interface EventListener {
	public void deployListener();
	public void moveListener(boolean isMove);
	public void turnListener();
	public void buyListener(UnitTypes unit);
}
