package infsci2955_deliverable5;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestSearch {
	
	//Type in the name of the user that we're looking for, 
	//and the search result must contain the user's name.
	@Test
	public void testSearchValid(){
		
		//Log in Facebook first.
		String email = "2014shufehey@gmail.com";
		String pass = "2014shufe";
		WebDriver driver = new FirefoxDriver();
		  
		driver.get("https://www.facebook.com/");
	    
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys(email);
		username.submit();
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(pass);
		password.submit();
		
		//Type in the name of the user that we're looking for,
		//there should be the user's name in the returned result.
		WebElement search=driver.findElement(By.className("_586i"));
		search.sendKeys("Jie Chen");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.className("_5b1w")).click();
	        String strs=driver.findElement(By.className("clearfix")).getText();
		assertTrue(strs.contains("jie chen"));

	}
}
