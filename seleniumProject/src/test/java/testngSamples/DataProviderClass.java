package testngSamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  @Test(dataProvider = "dp1")
  public void addition(Integer a, Integer b) {
	  System.out.println(a+b);
  }
  @Test(dataProvider = "dp1")
  public void substraction(Integer d, Integer c) {
	  System.out.println(c-d);
  }
  @Test(dataProvider = "dp2")
  public void multiplication(Integer e, Integer f) {
	  System.out.println(e*f);
  }

  @DataProvider(name="dp1")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { 1, 3 },
      new Object[] { 2, 5}
    };
  }
 
    @DataProvider(name="dp2")
    public Object[][] dp2() {
      return new Object[][] {
        new Object[] { 1, 3 },
        
      };
  }
}
