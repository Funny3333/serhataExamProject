package baseTest;

import org.apache.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

//Parent class for all tests
public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected PageProvider pageProvider;

    //Will be executed before each test
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();//download driver
        webDriver = new ChromeDriver();// create driver
        webDriver.manage().window().maximize();//maximize window
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//wait 5 seconds
        logger.info("Browser was open");
        pageProvider = new PageProvider(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

    @Rule
    public TestName testName = new TestName();
}