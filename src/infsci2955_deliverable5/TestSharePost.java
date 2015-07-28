package infsci2955_deliverable5;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSharePost {

	static WebDriver driver=new FirefoxDriver(); 
	
	//Log in Facebook first.
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
	
	//Please add 1 to the total number of shares every time after running it.
	//Share a post, and then the shared number under the original post will increase 1.
	@Test
	public void testSharePost(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("_2dpb")).click();
		
		//find the post--"Eight" and repost it
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement share=driver.findElement(By.id("tl_unit_860758939920290495"));
	        WebElement button=share.findElement(By.className("share_root")).findElement(By.tagName("a"));
	        JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", button);
		driver.findElement(By.className("_54nh")).click();
		
		//just wait some time and refresh the page to make sure the new post shown in the TimeLine
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("u_jsonp_2_n")).sendKeys(Keys.ENTER);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String s=driver.findElement(By.className("UFIShareLink")).getText();
		
		assertEquals(s,"2 shares");  //add one here 
	}

}
