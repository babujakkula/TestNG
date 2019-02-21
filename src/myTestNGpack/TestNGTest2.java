package myTestNGpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGTest2 
{
	  WebDriver driver;
	  @Test (priority=0)
	  public void Launch() 
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Seleniumhq\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://www.google.com/");
		  WebDriverWait w=new WebDriverWait(driver, 20);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		  driver.manage().window().maximize();
	  }
	  @Test (priority=1)
	  public void validate()
	  {
		  String t=driver.getTitle();
		  if(t.contains("Google")) 
		  {
			  Reporter.log("Title test Passed");
			  Assert.assertTrue(true);	  
			  
		  }
		  else 
		  {
			  Reporter.log("Title test Failed");
			  Assert.assertTrue(false);		  
		  }
	  }  
	  @Test (priority=2)
	  public void closesite() 
	  {
			  driver.close();
	  }
}

