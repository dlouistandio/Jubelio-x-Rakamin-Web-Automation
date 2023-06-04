package hooks;

import Context.TestContext;
import Utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {
   private WebDriver driver;
   private final TestContext context;

   public CucumberHooks(TestContext context){
        this.context = context;
    }

   @Before
    public void beforeTest() {
       driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
       context.driver = driver;
   }

   @After
    public void afterTest(){
       driver.quit();
   }

}
