package gui;

import model.game.Army;

public interface EventListener {
	public void deployListener(Army army);
	public void moveListener(boolean isMove);
}
