package myTestNGpack;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGTest1 {
  @Test
  public void Launch() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Seleniumhq\\chromedriver.exe");
	  ChromeDriver driver=new ChromeDriver();
	  driver.get("https://apsrtconline.in/oprs-web/login/show.do");
	  WebDriverWait w=new WebDriverWait(driver, 60);
	  //w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	  driver.manage().window().maximize();
	 
	  String t=driver.getTitle();
	  System.out.println(t);
	  /*if(t.contains("Google")) 
	  {
		  Reporter.log("Title test Passed");
		  Assert.assertTrue(true);	  
		  
	  }
	  else 
	  {
		  Reporter.log("Title test Failed");
		  Assert.assertTrue(false);		  
	  }
	  
	  driver.close();*/
	  //System.out.println("i am one");

  }
}
