package infsci2955_deliverable5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAddFriend {
	
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
	
	//Enter the personal page of the friend that we want to send request to,
	//click the button to send the friend request,
	//after sending the request, a message will be shown telling the user that the friend request has been sent.
	@Test
	public void testAddNewFriend(){
			
		driver.get("https://www.facebook.com/profile.php?id=100002316655807");
		
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('_42ft _4jy0 FriendRequestAdd addButton _4jy4 _517h _9c6')[0].click();");
		
		try {
			WebElement result = driver.findElement(By.xpath("//div[@id='u_0_w']//button[2]"));
			String actual = result.getText();
			String expected = "Friend Request Sent";
			assertEquals(expected, actual);
			driver.quit();
		} catch (NoSuchElementException e) {
			fail();
		}
	}
}
