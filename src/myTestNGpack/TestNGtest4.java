package myTestNGpack;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNGtest4 
{
	public ChromeDriver driver;
	public WebDriverWait wait;
	@DataProvider(name="testdata")
	public Object[][] method()
	{
		Object[][] data=new Object[4][4];
		
		data[0][0]="jakkulababu";
		data[0][1]="valid";
		data[0][2]="Babu@1234";
		data[0][3]="valid";
		
		data[1][0]=" ";
		data[1][1]="invalid";
		data[1][2]="Babu@1234";
		data[1][3]="valid";
		
		data[2][0]="jakkulababu";
		data[2][1]="valid";
		data[2][2]="";
		data[2][3]="invalid";
		
		data[3][0]="jakkulababu";
		data[3][1]="valid";
		data[3][2]="Babu";
		data[3][3]="invalid";
		
		return (data);
	}
	@BeforeMethod
	public void Launch() 
	{
		System.setProperty("webdriver.chrome.driver", "c:\\seleniumhq\\chromedriver.exe");
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,30);
		driver.get("https://apsrtconline.in/oprs-web/login/show.do");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login Here')]")));
	}
	@Test(dataProvider="testdata")
	public void dologin(String x,String y, String z,String w) throws Exception 
	{
		driver.findElement(By.name("userName")).sendKeys(x);
		driver.findElement(By.name("password")).sendKeys(z);
		driver.findElement(By.name("submitBtn")).click();
		Thread.sleep(5000);
		try 
		{
			if(x.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("User ID blank test passed");
				  Assert.assertTrue(true);
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//*[contains(text(),'eTicket Login')]")).click();
				  Thread.sleep(1000);
			  }
			  else if(y.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("User ID invalid test passed");
				  Assert.assertTrue(true);
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//*[contains(text(),'eTicket Login')]")).click();
				  Thread.sleep(1000);
			  }
			  else if(z.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("Password blank test passed");
				  Assert.assertTrue(true);
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//*[contains(text(),'eTicket Login')]")).click();
				  Thread.sleep(1000);
			  }
			  else if(w.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Login incorrect. Please try again')]")).isDisplayed()) 
			  {
				  Reporter.log("Password invalid test passed");
				  Assert.assertTrue(true);
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//*[contains(text(),'eTicket Login')]")).click();
				  Thread.sleep(1000);
			  }
			  else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[contains(text(),'Booking History & Cancellation')]")).isDisplayed())
			  {
				  Reporter.log("Login test passed");
				  Assert.assertTrue(true);
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
				  Thread.sleep(1000);
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
		//
	}
	@AfterMethod
	public void closesite() throws Exception 
	{
		driver.close();
	}
}
