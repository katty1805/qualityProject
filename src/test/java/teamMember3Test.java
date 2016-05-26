import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by danielvera on 5/26/16.
 */
public class teamMember3Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String teamMemberName = "Daniel Augusto Vera Yanez";

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        //baseUrl = "http://softwareteam.azurewebsites.net/";
        //baseUrl="http: //localhost:8080/team";

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
    public void testMemberTitleName() throws Exception {
        driver.get(baseUrl + "/");
        changeDriverToFrameWithID("teamFrameID");
        try {
            WebElement memberLink = driver.findElement(By.partialLinkText(teamMemberName));
            memberLink.click();

            WebElement memberTitle = driver.findElement(By.id("memberTitle"));
            assertEquals(teamMemberName, memberTitle.getText());
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

    private void changeDriverToFrameWithID(String frameName)
    {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(frameName);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}

