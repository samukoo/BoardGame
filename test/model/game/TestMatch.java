package model.game;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMatch {

	private Match testMatch;
	private Player mockPlayer1;
	private Player mockPlayer2;
	private String expectedName;
	
	@Before
	public void setup(){
		testMatch = new Match();
		
		//Test Material
		expectedName = "Player 1";
		mockPlayer1 = mock(Player.class);
		mockPlayer2 = mock(Player.class);
		when(mockPlayer1.getOwner()).thenReturn(expectedName);
		when(mockPlayer2.getOwner()).thenReturn("Player 2");
	
	}
	
	@Test
	public void test_setup_twoPlayer_match(){
		//Given testData @setup
		testMatch.setPlayers(mockPlayer1);
		testMatch.setPlayers(mockPlayer2);
		//When
		List<Player> res = testMatch.getPlayers();
		//Then
		assertNotNull(res);
		assertEquals(2, res.size());
	}
	
	@Test
	public void test_set_first_player(){
		//Given testmaterial @setup
		testMatch.setPlayers(mockPlayer1);
		//When
		Player result = testMatch.getCurrentPlayer();
		//Then
		assertEquals(expectedName, result.getOwner());
	}
	
	@Test
	public void test_get_current_player(){
		//Given data
		testMatch.setPlayers(mockPlayer1);
		testMatch.setPlayers(mockPlayer2);
		//When
		Player result = testMatch.getCurrentPlayer();
		//Then
		assertNotNull(result);
		assertEquals(expectedName, result.getOwner());
	}
	
	@Test
	public void test_end_turn(){
		//Given data
		testMatch.setPlayers(mockPlayer1);
		testMatch.setPlayers(mockPlayer2);
		
		//When
		Player result = testMatch.endTurn();
		
		//Then
		assertNotEquals(expectedName, result.getOwner());
	}

	@Test
	public void test_bug_continuous_turnEnd_doesnt_work(){
		//Given data
		testMatch.setPlayers(mockPlayer1);
		testMatch.setPlayers(mockPlayer2);
			
		//When change turn twice, result should be the original player (player1)
		testMatch.endTurn();
		Player result = testMatch.endTurn();
				
		//Then
		assertEquals(expectedName, result.getOwner());
	}
	
	@Test
	public void test_get_turnNr(){
	
		for(int i=1; i<5;i++){
			testMatch.endTurn();
			assertEquals(i, testMatch.getTurnNr());
		}
		
	}
	
	@Test
	public void test_get_Player_points(){
		testMatch.setCurrent(mockPlayer1);
		testMatch.getCurrentPlayerPoints();
	}
}
