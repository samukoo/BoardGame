package model.world.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import model.world.Hex;
import model.world.World;

import org.junit.Test;

public class testWorld {

	ArrayList<String>testCharMap = new ArrayList<String>();
	
	@Test
	public void testLoadMap() throws IOException {
		assertTrue(testCharMap.isEmpty());
		World SUT = new World();
			testCharMap = SUT.loadMap("src/resources/kartta.txt");
				assertFalse(testCharMap.isEmpty());
	}

	@Test
	public void testCreateMap() {
		World SUT = new World();
		ArrayList<Hex> testHexWorld = new ArrayList<Hex>();
		
		testHexWorld = SUT.createMap();
			assertFalse(testHexWorld.isEmpty()); //..että kartta ei ole tyhjä
				for(int i=0; i<testHexWorld.size(); i++){
					//luodaan kartta ja tarkistetaan että siinä ei ole " " tyypin hexoja
					assertNotEquals(testHexWorld.get(i).getType()," ");
		}
	}

	@Test
	public void testConvertEmptyHex() {
		
		Hex hex = new Hex(0, 0, " ");
		ArrayList<Hex>testWorld = new ArrayList<Hex>();
			testWorld.add(hex);
		
		World SUT = new World();
		testWorld = SUT.convertEmptyHex(testWorld);
			assertEquals("Should be null, not space", testWorld.get(0).getType(), "null");
	}
	
	@Test
	public void testNotConvertGoodHex(){
		
		Hex hex = new Hex(0, 0, "s");
		ArrayList<Hex>testWorld = new ArrayList<Hex>();
			testWorld.add(hex);
		
		World SUT = new World();
		testWorld = SUT.convertEmptyHex(testWorld);
			assertEquals("Should be still 's', not anything else", testWorld.get(0).getType(), "s");
		
		
		
	}
	
	
}