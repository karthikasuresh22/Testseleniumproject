package testngSamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
  }

  @DataProvider(name="successfullLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "admin","admin" }
    
    };
  }
  @DataProvider(name="unsuccessfullLogin")
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { "admin", "admin123" },
      new Object[] { "admin345", "admin678" },
      new Object[] { "admin852697", "admin" }
    
    };
  }
}
