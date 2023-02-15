package testNgAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderForPayroll {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
  }

  @DataProvider(name="sucessfull")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "carol", "1q2w3e4r" }
      
    };
  }
  @DataProvider(name="unsucessfull")
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { "carol", "1q2w3e4rtbngf" },
      new Object[] { "carol1234678", "1q2w3e4rtbngf" },
      new Object[] { "carolkarthika", "1q2w3e4r" },
    
    };
  }
}
