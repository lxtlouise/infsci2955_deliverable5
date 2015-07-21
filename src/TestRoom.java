import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;


public class TestRoom {
	
	//Test getDescription()
	//When the user is in the Smart room and the room's exit is facing south, 
	//the user should see a smart room which has a dumb board game and the room has a door leads South.
	@Test
	public void testGetDescription(){
		Room r = new Room(false, false, false, false, true);
		String actual = r.getDescription();
		String expected = "\nYou see a Smart room.\n" + "It has a Dumb board game.\n" + "A Bumpy door leads South.\n";
	
	    assertEquals(expected, actual);
	}
		
	//Test whether the room has coffee, cream or sugar.
	//Suppose the room has no coffee, no cream and no sugar, when we call the function hasItem(), the return value should be false.
	@Test
	public void testHasItem(){
		Room r = new Room(false, false, false, false, false);
	    boolean actual = r.hasItem();
	   
	    assertFalse(actual);
	}
	
	//Test whether the room has coffee.
	//Suppose the room has coffee but no sugar or cream, when we call the function hasCoffee(), the return value should be true.
	@Test
	public void testHasCoffee(){
		Room r = new Room(true, false, false, false, false);
		boolean actualCoffee = r.hasCoffee();
		
		assertTrue(actualCoffee);
	}
	
	//Test whether the room has sugar.
	//Suppose the room has sugar but no coffee or cream, when we call the function hasSugar(), the return value should be true.
	@Test
	public void testHasSugar(){
		Room r = new Room(false, false, true, false, false);
		boolean actualSugar = r.hasSugar();
		
		assertTrue(actualSugar);
	}
	
	//Test whether the room has cream.
	//Suppose the room has cream but no coffee or sugar, when we call the function hasCream(), the return value should be true.
	@Test
	public void hasCream(){
		Room r = new Room(false, true, false, false, false);
		boolean actualCream = r.hasCream();
		 
		assertTrue(actualCream);
	}
	
	//Test whether the room's exit is facing north
	//Suppose the room's exit is not facing north, when we call the function northExit(), the return value should be false.
	@Test
	public void testNorthExit(){
		Room r = new Room(false, false, false, false, false);
		boolean actualNorth = r.northExit();
		
		assertFalse(actualNorth);
	}
	
	//Test whether the room's exit is facing south
	//Suppose the room's exit is facing south, when we call the function southExit(), the return value should be true.
	@Test
	public void testSouthExit(){
		Room r = new Room(false, false, false, false, true);
		boolean actualSouth = r.southExit();
		
		assertTrue(actualSouth);
	}

}
