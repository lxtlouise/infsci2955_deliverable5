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

public class TestSendMessage {
	
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
	
	//precondition: this message has never been send before, because we use "contain" to test here
	//choose the friend Jie to send a message to her
	//then the conversation board must contain this message
	@Test
	public void testSendMessage(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("fbDockChatBuddylistNub")).findElement(By.className("fbNubButton")).click();
		WebElement friend=driver.findElement(By.id("u_0_25"));
		friend.sendKeys("Jie");
		friend.sendKeys(Keys.ENTER);
		WebElement text=driver.findElement(By.cssSelector(".uiTextareaAutogrow._552m"));
		String t="One";
		text.sendKeys(t);
		text.sendKeys(Keys.ENTER);
		String content=driver.findElement(By.className("conversation")).getText();
		System.out.println(content);
		assertTrue(content.contains(t));
		
	}

}
