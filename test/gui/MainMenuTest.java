package gui;

import static org.junit.Assert.*;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

public class MainMenuTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMenuPanel() {
		//CUT
		MainMenu menu = new MainMenu();
		JPanel result = menu.menuPanel();
		assertNotNull(result);
		
		Component[] components = result.getComponents();
		
		System.out.println(components[0]);
		
		
		
		
	}

}
