package model.battlefield;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.units.Tank;
import model.units.Unit;

import org.junit.Before;
import org.junit.Test;


public class TestField {
	private Field testField;
	
	@Before
	public void setUp() throws Exception {
		testField = new Field();
	}

	@Test
	public void test_OrderToField() {
		//Given data
		String unit = "Tank";
		
		Tank tank = mock(Tank.class);
		when(tank.getType()).thenReturn(unit);
		//When order to field
		List<Unit> res = testField.orderToField(tank);
		//Then unit is deployed
		assertEquals(unit, res.get(0).getType());
	}

	@Test
	public void test_selectUnit(){
		//Given test data
		int[][]testData = {{1,1},{3,3},{4,4}}; //1st tank location 1,1. 2nd tank location 3,3. 3rd tank location 4,4
		List<Unit>testArmy = new ArrayList<Unit>();	//Luodaan test army
		
		for(int i=0;i<3;i++){					//Ja test armyyn unitteja
			testArmy.add(new Tank("foobar"));
			testArmy.get(i).setXyHex(testData[i]);	//Asetetaan uniteille hex location
		}
		
		for(Unit unit : testArmy){				//order units to testField
			testField.orderToField(unit);
		}
		//When
		int res = testField.selectUnit(testData[2]);	//Locate the unit index, who is in the target hex
		//Then
		assertEquals(2, res);
	}

	@Test
	public void test_selectUnit_emptyHex(){
		//Given test data
		int[][]testData = {{1,1},{3,3},{4,4}}; //1st tank location 1,1. 2nd tank location 3,3. 3rd tank location 4,4
		int[]emptyHex = {3,4};
		List<Unit>testArmy = new ArrayList<Unit>();	//Luodaan test army
				
		for(int i=0;i<3;i++){					//Ja test armyyn unitteja
			testArmy.add(new Tank("foobar"));
			testArmy.get(i).setXyHex(testData[i]);	//Asetetaan uniteille hex location
			}
				
			for(Unit unit : testArmy){				//order units to testField
				testField.orderToField(unit);
			}
		//When
		Integer res = testField.selectUnit(emptyHex);	//Locate the unit index, who is in the target hex
		//Then
		assertNull(res);
	}
	
	@Test
	public void test_print_DeployedUnits(){
		testField.printDeployedUnits();
	}
}
