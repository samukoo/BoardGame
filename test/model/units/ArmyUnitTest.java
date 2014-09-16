package model.units;

/**
 * @author kotissa
 * TankTestit
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class ArmyUnitTest {

	@Test
	public void test_tank_gets_owner(){
		String expected = "sauli";
		Tank tank = new Tank(expected);
		String res = tank.getOwner();
		assertEquals(expected, res);
	}

	@Test
	public void test_calculateUnitSpeed(){
		//Given
		Tank SUT = new Tank("owner");
		assertEquals(Movement.stationary, SUT.getSpeed()); //Aluksi vaunu on paikoillaan
		int i=2;
		for(Movement move : Movement.values()){ //moveFast, move, stationary -järjestys
		//When
		SUT.setMovePoints(i);	//asetetaan ensin 2 (movefast), sitten 1 jnejne
		SUT.calculateUnitSpeed();	//lasketaan nopeus. jos 2 pistettä, vaunu ei ole liikkunut, jos 0 pistettä, vaunu liikkuu tosilujaa
		//Then
		assertEquals(move, SUT.getSpeed()); //tarkistus
		i--;	//ja seuraava iteraatio
		}
	}
	
	
	@Test
	public void test_getSpeed(){
		//Given
		Movement testData = Movement.move;
		Tank SUT = new Tank("owner");
		//When
		SUT.setSpeed(testData);
		Movement res = SUT.getSpeed();
		//Then
		assertEquals(testData, res);
		
	}

}
