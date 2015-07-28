package infsci2955_deliverable5;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLikePage {
	
	static WebDriver driver=new FirefoxDriver(); 

	@Before
	public void setup() {
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
	
	//precondition: if the page has been liked before, remember to set it as "unlike" before running this
	//go to an interested page, and click "Like"
	//the color of the thumb will change
	@Test
	public void testLikePage(){		
		driver.get("https://www.facebook.com/AdoreABullResuceCincinnati");
		driver.findElement(By.id("u_0_2g")).click();
		String actual = driver.findElement(By.id("u_0_2j")).getCssValue("color");
		String expect="rgba(78, 86, 101, 1)";
		System.out.println(actual);
		assertEquals(expect,actual);
	}

}
