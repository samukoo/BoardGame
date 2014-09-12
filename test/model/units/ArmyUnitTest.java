package model.units;

/**
 * @author kotissa
 * TankTestit
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.io.IOException;

import org.junit.Test;


public class ArmyUnitTest {

	@Test
	public void test_tank_gets_owner(){
		String expected = "sauli";
		Tank tank = new Tank(expected);
		String res = tank.getOwner();

		assertEquals(expected, res);
	}
}
