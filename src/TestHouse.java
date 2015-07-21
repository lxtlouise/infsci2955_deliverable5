import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import org.junit.Test;



public class TestHouse {
	//Use Reflection to get access to the private variables to test getCurrentRoomInfo().
	//When _currentRoom equals to -1, which means a user enters a room that is not existed,
	//he should be informed with the message "You are in a magical land! But you are returned to the beginning!".
	@Test
	public void testGetCurrentRoomInfo() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		House h = new House(6);
		Class<?> secretClass = h.getClass();
        String cr = "_currentRoom";
	    Field f = secretClass.getDeclaredField(cr);
	    f.setAccessible(true);
	    f.setInt(h, -1);
	    
		String actual = h.getCurrentRoomInfo();
		assertEquals("You are in a magical land!  But you are returned to the beginning!", actual);
	}
	
	//Test getCurrentRoomInfo without using Reflection
	//When _currentRoom equals to -1, which means a user enters a room that is not existed,
	//he should be informed with the message "You are in a magical land! But you are returned to the beginning!". 
	@Test
	public void testCurrentRoomInfo2(){
	    Room r = mock(Room.class); 
	    Room[] rooms = new Room[1];
	    rooms[0] = r;
	    
	    House h = new House(rooms);
	    h.moveNorth();
	    String actual = h.getCurrentRoomInfo();
	    
	    assertEquals("You are in a magical land!  But you are returned to the beginning!", actual);
	    
	}
	
	
	//Test getDescription()
	//When users are in an existed room, they should be able to see the description of the room that they're currently in. 
	@Test
	public void testGetDescription(){
		Room r = mock(Room.class); 
		Room[] rooms = new Room[1];
		rooms[0] = r;
		
		House h = new House(rooms);
		when(r.getDescription()).thenReturn("foo"); 
		String actual = h.getCurrentRoomInfo();
		
		assertEquals("foo", actual);
	}
	
	//Test generateRoom()
	//When we generate 2 rooms, we should be able to get an array of rooms and length of the array should be 2. 
	@Test
	public void testGenerateRoom(){
		
		House h = new House(6);
		Room[] rooms = h.generateRooms(2);
		
		assertEquals(rooms.length, 2);
	}
	
	//Test generateRoom()
	//When we generate 6 rooms, the first room should have cream.
	@Test
	public void testFirstRoomHasCream() {
		House h = new House(6);
		Room[] rooms = h.generateRooms(6);
		
		assertTrue(rooms[0].hasCream());
		
	}
	
}
