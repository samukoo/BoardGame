package model.units;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import model.game.Army;
import model.game.ArmyController;
import model.game.Player;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArmyTest {

	private Army armyCUT; //Class under test
	private ArmyController armyControllerCUT;
	private String owner;
	
	
	@Before
	public void setup(){
		armyCUT = new Army();
		armyControllerCUT = new ArmyController();
		owner = "fooBar";
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test_Player_has_not_enough_points(){
		//Given
		
		Player player = new Player(owner);
		Tank mockTank = mock(Tank.class);
		int cost = 6;
		//When
		when(mockTank.getCost()).thenReturn(cost);
		
		//Then Error.class error is thrown
		exception.expect(Error.class);
		player.buyUnit(mockTank);
	}
	
	@Test
	public void test_Player_Add_new_unit(){
		Player player = new Player(owner);
		Tank mockTank = mock(Tank.class);
		when(mockTank.getCost()).thenReturn(2);
		
		player.buyUnit(mockTank);

		Army res = player.getArmy();
		
		assertEquals( 1, res.getArmySize()); //Armeijan koko on 1
		assertEquals(owner, res.getOwner() );
	}
	
	
	
	
	@Test
	public void test_Player_points_are_decreased(){
		//Given
		Player player = new Player(owner);
		Tank mockTank = mock(Tank.class);
		int cost = 2;
		int expectedCost = player.getPoints()-cost;
		//When
		when(mockTank.getCost()).thenReturn(cost);
		player.buyUnit(mockTank);
		
		//Then
		assertEquals(expectedCost, player.getPoints());
	}
	
	@Test
	public void test_Player_has_armyPoints(){
		int expectedPoints = 5;
		
		Player player = new Player(owner);
		
		int res = player.getPoints();
		assertEquals(expectedPoints, res);
	}
	
	@Test
	public void test_player_army_initialization(){
		String owner = "foobar";
		Player playerSUT = new Player(owner);
		assertEquals(owner, playerSUT.getOwner());
		
	}
	
	@Test
	public void controller_returns_armyObject(){
		Army res = armyControllerCUT.getArmy();
		assertNotNull(res);
	}
		
	@Test
	public void test_Add_ArmyUnit() {
		//Given setup
		Tank mockTank = mock(Tank.class);
		//When
		int res = armyCUT.addUnit(mockTank);
		//Then
		assertEquals(1, res);
	}
	
	@Test
	public void test_Army_has_owner(){
		String owner = "fooBar";
		armyCUT.setOwner(owner);
		String res = armyCUT.getOwner();
		assertEquals(owner, res);
	}
}
