package model.units;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.Test;

public class testTank {

	@Test
	public void testGetImage() throws IOException {
		//given Tank Under the Test
		Tank TUT = new Tank(0, 0);
		BufferedImage res = null;
		//when
		res = TUT.getImage();
		//then
		assertNotNull(res);
	}
}
