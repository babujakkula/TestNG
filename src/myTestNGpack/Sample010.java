package myTestNGpack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample010 {
  @Test(priority=0)
  public void test1() 
  {
	 System.out.println("i am in test 1");	
  }
  @Test(priority=1)
  public void test2() 
  {
	 System.out.println("i am in test 2");	
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("i am in before Method in sample1");
  }
  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("i am in after Method in sample1");
  }
  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("i am in before Class in sample1");
  }
  @AfterClass
  public void afterClass() 
  {
	  System.out.println("i am in after class in sample1");
  }
  @BeforeTest
  public void beforeTest() 
  {
	System.out.println("i am in before test");  
  }
  @AfterTest
  public void afterTest() 
  {
	  System.out.println("i am in after Test");
  }
  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("i am in before suite");
  }
  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("i am in after suite");
  }


}
 