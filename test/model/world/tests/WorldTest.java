package model.world.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import model.world.Hex;
import model.world.World;

import org.junit.Test;
import static org.mockito.Mockito.mock;

public class WorldTest {

	
	
	@Test
	public void testGetHexCenter(){
		//Given
		World SUT = new World();
		int[] testHex = {3,3};
		int[] res;
		
		//When
		res = SUT.getHexCenterPosition(testHex);
		//then
		System.out.println("mit: " +res[0]+" vit: " + res[1]);
		assertNotNull(res);
	}
	
	
	
	@Test
	public void testLoadMap() throws IOException {
		//given
		ArrayList<String>mockCharMap = mock(ArrayList.class);
		World SUT = new World();
		//when
		mockCharMap = SUT.loadMap("src/resources/kartta.txt");
		//then		
		assertFalse(mockCharMap.isEmpty());
	}

	@Test
	public void testCreateMap() {
		//given
		World SUT = new World();
		ArrayList<Hex> testHexWorld = new ArrayList<Hex>();
		//when
		testHexWorld = SUT.createMap();
		//then	
		assertFalse(testHexWorld.isEmpty()); //..että kartta ei ole tyhjä
	}
	
	@Test
	public void testCreateMapNoEmptyHexas(){
		//given
		World SUT = new World();
		ArrayList<Hex> testHexWorld = new ArrayList<Hex>();
		//when
		testHexWorld = SUT.createMap();
		//then
		for(int i=0; i<testHexWorld.size(); i++){
		assertNotEquals(testHexWorld.get(i).getType()," ");
		}
	}

	@Test
	public void testConvertEmptyHex() {
		//given
		Hex hex = new Hex(0, 0, " ");
		ArrayList<Hex>testWorld = new ArrayList<Hex>();
			testWorld.add(hex);
		//when
		World SUT = new World();
		testWorld = SUT.convertEmptyHex(testWorld);
		//then	
		assertEquals("Should be null, not space", testWorld.get(0).getType(), "null");
	}
	
	@Test
	public void testNotConvertGoodHex(){
		//given
		Hex hex = new Hex(0, 0, "s");
		ArrayList<Hex>testWorld = new ArrayList<Hex>();
			testWorld.add(hex);
		//when
		World SUT = new World();
		testWorld = SUT.convertEmptyHex(testWorld);
		//them	
		assertEquals("Should be still 's', not anything else", testWorld.get(0).getType(), "s");
		
		
		
	}
	
	
}