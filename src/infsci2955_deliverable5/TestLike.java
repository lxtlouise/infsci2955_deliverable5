package infsci2955_deliverable5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLike {
	
    WebDriver driver = new FirefoxDriver();
	
	//Log in Facebook first
	@Before
	public void setup(){
		String email = "2014shufehey@gmail.com";
		String pass = "2014shufe";
		  
		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys(email);
		username.submit();
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(pass);
		password.submit();
	}
	
	//Click the "Like" button,
	//after clicking the button, the color will be changed from grey to blue.
	@Test
	public void testLike(){
		driver.get("https://www.facebook.com/");
		WebElement likeButton = driver.findElement(By.className("_4l5"));
		WebElement clickLike = driver.findElement(By.tagName("a"));
		clickLike.click();
		String actual = clickLike.getCssValue("color");
		String expected = "rgba(59, 89, 152, 1)";
		assertEquals(expected, actual);
		
	}
}
