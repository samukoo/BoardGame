package gui;

import model.game.Army;

public interface EventListener {
	public void deployListener();
	public void moveListener(boolean isMove);
	public void turnListener();
	public void buyListener(String unit);
}
