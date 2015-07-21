import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class TestGame {

  //Test whether the game is case-insensitive
  //Enter command "d" and "D"
  //They should both run the drink() method in player for once and the return value of the method should be 1
  @Test
  public void testDoSomething(){
	  Player p = mock(Player.class); 
	  House h = mock(House.class);
	  Game g = new Game(p, h);
	
	  when(p.drink()).thenReturn(true); 
	
	  int lower = g.doSomething("d");
	  int upper = g.doSomething("D");
	
	  assertEquals("The game is case-sensitive", lower, upper);
      assertEquals(1, lower);
      assertEquals(1, upper);
  }
  
  //Test moveNorth()
  //When the input of doSomething is "N", the function moveNorth() should be called once. And the return value should be 0.
  @Test
  public void testMoveNorth(){
	  Player p = mock(Player.class);
	  House h = mock(House.class);
	  Game g = new Game(p, h);
	  
	  int actual = g.doSomething("N");
	  
	  Mockito.verify(h, times(1)).moveNorth(); 
	  assertEquals(0, actual);
  }
  
  //Test moveSouth
  //When the input of doSomething is "S", the function moveSouth() should be called once. And the return value should be 0.
  @Test
  public void testMoveSouth(){
	  Player p = mock(Player.class);
	  House h = mock(House.class);
	  Game g = new Game(p, h);
	  
	  int actual = g.doSomething("S");
	  
	  Mockito.verify(h, times(1)).moveSouth();
	  assertEquals(0, actual);
  }
  
  //When users enter an invalid command, they should be informed with "What?".
  @Test
  public void testDoSomethingWithInvalidCommand(){
	  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	  System.setOut(new PrintStream(outContent));
		
	  Player p = mock(Player.class);
	  House h = mock(House.class);
	  Game g = new Game(p, h);
	
	  int actual = g.doSomething("&");
	  String separator = System.getProperty("line.separator");
	  
	  assertEquals(0, actual);
	  assertEquals("What?" + separator, outContent.toString());
  }
  
  
}
