package infsci2955_deliverable5;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTest {
	@Test
	public void testSearchFriendNotExist(){
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
		
		WebElement search=driver.findElement(By.className("_586i"));
		search.sendKeys("$abcd");
		driver.findElement(By.className("_5b1w")).click();
	    String strs = driver.findElement(By.className("_1bar")).findElement(By.tagName("span")).getText();
	    
		assertTrue(strs.contains("We didn't find any posts from your friends and groups matching"));	  
	}
}
