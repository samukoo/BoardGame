package model.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUnitTypes {

	private UnitTypes SUT;
	
	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void test_FromString() {
	//Given	
	String unit=null;
	for(UnitTypes item:UnitTypes.values()){
		unit = item.toString();
	
		//When
		UnitTypes res = SUT.fromString(unit);
		
		//Then
		assertNotNull(res);
		assertEquals(item, res);
		}
	}

	@Test
	public void test_FromString_return_NULL() {
	//Given	
	String unit="foobar";
	//When
		UnitTypes res = SUT.fromString(unit);
		//Then
		assertNull(res);
	}
	}
