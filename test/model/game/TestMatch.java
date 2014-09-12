package model.game;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.Assert.*;
import model.units.Infantry;
import model.units.Tank;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestMatch {

	private iMatch testMatch;
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
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test_init_match(){
		//Given data
		String expected = "Sauli";
		//When
		Match initMatch = new Match("init");
		//Then
		assertEquals(expected, initMatch.getCurrentPlayer().getOwner());
		//And when
		initMatch.endTurn();
		//Then current should not be "expected"
		assertNotEquals(expected, initMatch.getCurrentPlayer().getOwner());
	}
	
	@Test
	public void test_Player_tries_exceed_his_points(){
		//Given
		testMatch.setPlayers(new Player("foobar"));
		Tank mockTank = mock(Tank.class);
		when(mockTank.getCost()).thenReturn(6);
		//When
		exception.expect(Error.class);
		testMatch.shopUnit(mockTank);
		//Then Error exception is thrown!		
	}
	
	@Test
	public void test_player_shall_buy_aTank(){
		//Given
		testMatch.setPlayers(new Player("current Player"));
		Tank mockTank = mock(Tank.class);
		//When
		List<Player> result = testMatch.shopUnit(mockTank);
		//Then
		assertEquals(1, result.get(0).getArmySize());
	}
	
	@Test
	public void test_after_turnChange_other_player_buys_aTank(){
		//Given players and other data
		testMatch.setPlayers(new Player("current Player"));
		testMatch.setPlayers(new Player("Not current Player"));
		Tank mockTank = mock(Tank.class);
		when(mockTank.getType()).thenReturn("Tank");
		
		//When player1 ends his turn
		testMatch.endTurn();
		//and player2 buys a unit
		List<Player> result = testMatch.shopUnit(mockTank);
		
		//Then player 1 army size=0 and player 2 armysize=1
		assertEquals("armysize should be zero", 0 , result.get(0).getArmySize());
		assertEquals("armysize should be one", 1 , result.get(1).getArmySize());
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
		//Given turn
		for(int i=1; i<5;i++){
			//When turn ends
			testMatch.endTurn();
			
			//Then turn number is incremented
			assertEquals(i, testMatch.getTurnNr());
		}
	}
	
	@Test
	public void test_get_Player_points(){
		//Given
		testMatch.setCurrent(mockPlayer1);
		when(mockPlayer1.getPoints()).thenReturn(5);
		
		//When
		int res = testMatch.getCurrentPlayerPoints();
		
		//Then
		assertEquals(5, res);
		}
	}
