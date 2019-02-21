package myTestNGpack;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class GmailParameterTest 
{
	ChromeDriver driver;
	WebDriverWait w;
	  @BeforeMethod
	  public void Launch() 
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Seleniumhq\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://apsrtconline.in/oprs-web/login/show.do");
		  driver.manage().window().maximize();
		  //w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login Here')]")));		  
	  }
	  @Test
	  @Parameters ({"uid","uidc","pwd","pwdc"})
	  public void dologin(String x, String y, String z, String w) throws Exception
	  {
		  driver.findElement(By.name("userName")).sendKeys(x);
		  driver.findElement(By.name("password")).sendKeys(z);
		  driver.findElement(By.name("submitBtn")).click();
		  Thread.sleep(5000);
		  //validation
		  try 
		  {
			  if(x.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("User ID blank test passed");
				  Assert.assertTrue(true);
			  }
			  else if(y.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("User ID invalid test passed");
				  Assert.assertTrue(true);
			  }
			  else if(z.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("Password blank test passed");
				  Assert.assertTrue(true);
			  }
			  else if(w.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("Password invalid test passed");
				  Assert.assertTrue(true);
			  }
			  else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[contains(text(),'Booking History & Cancellation')]")).isDisplayed())
			  {
				  Reporter.log("Login test passed");
				  Assert.assertTrue(true);
			  }
			  else 
			  {
				  SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
				  Date d=new Date();
				  String ssname=sf.format(d)+".png";
				  File src=driver.getScreenshotAs(OutputType.FILE);
				  File dest=new File(ssname);
				  FileHandler.copy(src, dest);
				  Reporter.log("Login test faied as you see");
				  String sspath="path"+ssname;
				  String code="<img src=\"file:///"+sspath+"\" alt=\"\"/>";
				  Reporter.log(code);
				  Assert.assertTrue(false);
			  }
		  }
		  catch(Exception e) 
		  {
			  Reporter.log(e.getMessage());
			  Assert.assertTrue(false);
		  }
		  
	  }
	  @AfterMethod
	  public void closesite() 
	  {
		  driver.close();
	  }
}
