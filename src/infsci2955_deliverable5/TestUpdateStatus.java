package infsci2955_deliverable5;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestUpdateStatus {
	
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
	
	//Every time after you run it, please enlarge the number with 1(make sure the new post has never been post before)
	//update status, and then find the post shown in the TimeLine
	@Test
	public void testUpdateStatus(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("_1ayn")).click();
		
		//update status
		WebElement text=driver.findElement(By.id("u_jsonp_2_n"));
		text.sendKeys("Nine");  //add 1
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[@value='1'])[11]")).click();
		
		//just wait sometime to make sure the new post shown in the TimeLine
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("u_jsonp_2_n")).sendKeys(Keys.ENTER);
		String s=driver.findElement(By.className("_5nb8")).getText();
		
		assertTrue(s.contains("Nine"));  //add 1

		
	}

}
