package controller;

import static org.mockito.Mockito.*;

import java.awt.Point;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import model.battlefield.Field;
import model.game.Army;
import model.game.Match;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

public class TestBoardController {

	private BoardController SUT;
	private Army army;
	private Field field;
	private Match match;
	
	@Before
	public void setUp() throws Exception {
		field = mock(Field.class);
		army = mock(Army.class);
		match = mock(Match.class);
		SUT = new BoardController(army,field,match);
	}

	@Test
	public void test_moveUnit(){
	Point point = new Point();
		int[]res={3,3};
	when(field.selectHex(point)).thenReturn(res);
	int index=0;
		
	int[] result = SUT.moveUnit(index, point);
	
	System.out.println(result[1]);
	}

	


}
