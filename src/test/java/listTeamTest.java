/**
 * Created by katty on 19/05/2016.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class listTeamTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl= useRemote();
        System.out.println(baseUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String useRemote() {
        String remote;
        remote = System.getProperty("url");
        if (remote == null)
            return "http://localhost:8080/team";
        else
            return remote;
    }
    @Test
    public void testHomeInfo() throws Exception {
        driver.get(baseUrl + "/");
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | frame | ]]
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame("teamFrameID");

            WebElement teamName = driver.findElement(By.id("teamPID"));
            assertEquals("Counter Team", teamName.getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            WebElement teamMember1 = driver.findElement(By.id("mangoChupadoID"));
            assertEquals("Christian Andr&eacutes Bustamante Crespo", teamMember1.getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            WebElement teamMember2 = driver.findElement(By.id("ninaScochID"));
            assertEquals("Daniela Katherine Flores Taipe", teamMember2.getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            WebElement teamMember3 = driver.findElement(By.id("elunicoeinmejorableID"));
            assertEquals("Daniel Augusto Vera Yanez", teamMember3.getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
