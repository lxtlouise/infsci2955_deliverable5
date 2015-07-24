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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAddFriend {

	@Test
	public void testAddNewFriend(){
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
