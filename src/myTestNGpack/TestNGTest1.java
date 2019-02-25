package myTestNGpack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGTest1 {
  @Test
  public void Launch() throws Exception 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Seleniumhq\\chromedriver.exe");
	  ChromeDriver driver=new ChromeDriver();
	  driver.get("https://www.google.co.in");
	  WebDriverWait w=new WebDriverWait(driver, 60);
	  w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("abdul kalam");//,Keys.ENTER
	  driver.manage().window().maximize();
	  
	  WebElement e=driver.findElement(By.name("btnK"));
	  Actions a=new Actions(driver);
	  a.click(e).build().perform();
	  /*
	  String t=driver.getTitle();
	  System.out.println(t);
	  if(t.contains("Google")) 
	  {
		  Reporter.log("Title test Passed");
		  Assert.assertTrue(true);	  
		  
	  }
	  else 
	  {
		  Reporter.log("Title test Failed");
		  Assert.assertTrue(false);		  
	  }*/
	  Thread.sleep(3000);
	  driver.close();
  }
}
