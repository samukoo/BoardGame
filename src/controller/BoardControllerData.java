package controller;

import model.battlefield.Field;
import model.game.Army;
import model.game.Match;

public class BoardControllerData {
	public Army army;
	public Field field;
	public Match match;
	public int[] selectedHex;
	public boolean move;
	public Integer index;

	public BoardControllerData(int[] selectedHex, boolean move, Integer index) {
		this.selectedHex = selectedHex;
		this.move = move;
		this.index = index;
	}
}