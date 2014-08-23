package model.units;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class testTank {

	@Test
	public void testGetImage() throws IOException {
		//given Tank Under the Test
		int[]xyHex = {4,7};
		int[]xyLoc = {100,100};
		Tank TUT = new Tank(xyHex, xyLoc);
		Image resultImage = null;
		//when
		resultImage = TUT.getImage();
		//then
		assertNotNull(resultImage);
	}

	@Test
	public void testTankHex(){
		//Given
		int[]xyHex = {4,7};
		int[]xyLoc = {100,100};
		Tank TUT = new Tank(xyHex, xyLoc);
		//When
		int[]res = TUT.getXyHex();
		//Then
		for(int i=0;i<res.length;i++){
			assertEquals(xyHex[i], res[i]);
		}
		
	}


}
