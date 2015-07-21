import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestPlayer{

	//Test whether user can get sugar
	//When user finds some sugar, he should be able to get the sugar and be informed with the message "You found some sweet sugar!".
	@Test 
	public void testGetSugar(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Player p = new Player();
		p.getSugar();
		String separator = System.getProperty("line.separator");
		
		assertEquals("You found some sweet sugar!" + separator, outContent.toString());
		
	}
	
	//Test whether user can get cream
	//When user finds some cream, he should be able to get the cream and be informed with the message "You found some creamy cream!".
    @Test
    public void testGetCream(){
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Player p = new Player();
		p.getCream();
		String separator = System.getProperty("line.separator");
		
		assertEquals("You found some creamy cream!" + separator, outContent.toString());
    }
    
    //Test whether user can get coffee
    //When user finds some coffee, he should be able to get the coffee and be informed with the message "You found some caffeinated coffee!".
    @Test
    public void testGetCoffee(){
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Player p = new Player();
		p.getCoffee();
		String separator = System.getProperty("line.separator");
		
		assertEquals("You found some caffeinated coffee!" + separator, outContent.toString());
    }
    
    //When the user doesn't have anything in his inventory, he should be shown that he doesn't have any item.
    @Test 
    public void testHasNothing(){
    	Player p = new Player(false, false, false);
    	boolean actual = p.hasAllItems();
    	
    	assertFalse(actual);
    	
    }
    
    //When there's coffee, sugar and cream in user's inventory, he should be shown that he has all the items.
    @Test
    public void testHasAllItems(){
    	Player p = new Player(true, true, true);
    	boolean actual = p.hasAllItems();
    	
    	assertTrue(actual);
    }
    
    
    //Test user's inventory
    //If the user doesn't collect anything, there should be nothing in his inventory
    @Test
    public void testShowInventory(){
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
    	Player p = new Player(false, false, false);
    	p.showInventory();
    	String separator = System.getProperty("line.separator");
    	assertEquals("YOU HAVE NO COFFEE!" + separator + "YOU HAVE NO CREAM!" + separator + "YOU HAVE NO SUGAR!" + separator, outContent.toString());
    	
    }
    
    //Test user's inventory
    //If the user has collected sugar but hasn't collected coffee or cream, there should be only sugar in his inventory.
    @Test 
    public void testShowInventoryWithSugar(){
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
    	Player p = new Player(true, false, false);
    	p.showInventory();
    	String separator = System.getProperty("line.separator");
    	assertEquals("YOU HAVE NO COFFEE!" + separator + "YOU HAVE NO CREAM!" + separator + "You have some tasty sugar." + separator, outContent.toString());
    }
	
    //When there's nothing in user's inventory, he can't drink anything and will be informed that he's lost the game.
	@Test
	public void testDrinkWithNothing(){
		Player p = new Player(false, false, false);
		boolean actual = p.drink();
		
		assertFalse(actual);
	}
	
	//When there's only sugar in user's inventory, he can't drink the coffee and will be informed that he's lost the game.
	@Test
	public void testDrinkWithOnlySugar(){
		Player p = new Player(true, false, false);
		boolean actual = p.drink();
		
		assertFalse(actual);
	}
	
	//When there's sugar, coffee and cream in user's inventory, he can drink the coffee and will be informed that he's won the gamem.
	@Test
	public void testDrinkWithEverything(){
		Player p = new Player(true, true, true);
		boolean actual = p.drink();
		
		assertTrue(actual);
	}
}
