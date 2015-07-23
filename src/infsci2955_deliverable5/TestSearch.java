package infsci2955_deliverable5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestSearch {
	
	@Test
	public void testSearchValid(){
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
		  
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('inputtext _586f hidden_elem').item(0).value = 'jie chen pittsburgh';");
//        WebElement s = driver.findElement(By.tagName("button"));
//        s.click();
//		try {
//			WebElement result = driver.findElement(By.id("login_form")).findElement(By.tagName("p"));
//			String actual = result.getText();
//			String expected = "The password you entered is incorrect. Please try again (make sure your caps lock is off).";
//			assertEquals(expected, actual);
//			driver.quit();
//		} catch (NoSuchElementException e) {
//			fail();
//		}
	}
}
