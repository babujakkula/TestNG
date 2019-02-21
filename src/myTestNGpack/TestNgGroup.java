package myTestNGpack;

import org.testng.annotations.Test;

public class TestNgGroup {
  @Test (groups="Inbox")
  public void Method1Test() 
  {
	  	System.out.println("M1");
  }
  @Test (groups="Search")
  public void Method2Test() 
  {
	  
  }
  @Test (groups="SearchItem")
  public void Method3Test()
  {
	  System.out.println("M3");
  }
  @Test (groups="Search")
  public void Method4Test()
  {
	  System.out.println("M4");
  }
}
