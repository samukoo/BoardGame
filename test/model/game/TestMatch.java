package model.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestMatch {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_change_current_player(){
		//Given
		Match CUT = new Match();
		//When
		Player result = CUT.changeCurrent_player();
		//Then
		assertNotNull(result);
	}
	
	
	
	
	@Test
	public void test_Get_Current_Player() {
		//Given
		String expectedName ="foobar"; 
		Player currentPlayer = mock(Player.class);
		Player not_currentPlayer = mock(Player.class);
		Match CUT = new Match();
		CUT.addPlayer(currentPlayer);
		CUT.addPlayer(not_currentPlayer);
		
		//TestMaterial
		when(currentPlayer.isCurrent()).thenReturn(true);
		when(not_currentPlayer.isCurrent()).thenReturn(false);
		when(currentPlayer.getName()).thenReturn(expectedName);
		when(not_currentPlayer.getName()).thenReturn("for testing purposes, something has went frong!");
		
		//When
		Player result = CUT.getCurrentPlayer();	
		
		//Then
		assertEquals(result.getName(),currentPlayer.getName());
	}

	@Test
	public void test_Add_Players_To_Match(){
		//Given
		Match CUT = new Match();
		Player mPlayer = mock(Player.class);
		String name = "testiPelaaja";
		when(mPlayer.getName()).thenReturn(name);
		//When
		CUT.addPlayer(mPlayer);
		//Then
		assertEquals(name, CUT.getPlayer(0));
	}
}
