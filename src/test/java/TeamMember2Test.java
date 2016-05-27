import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Creado por katty on 26/05/2016.
 */
public class TeamMember2Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String teamMemberName = "Daniela Katherine Flores Taipe";

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

    @Test
    public void testMemberPhoto() throws Exception {
        driver.get(baseUrl + "/");
        changeDriverToFrameWithID("teamFrameID");
        try {
            driver.findElement(By.partialLinkText(teamMemberName)).click();
            assertEquals(true, driver.findElement(By.cssSelector(".photo-container img")) != null);
            assertEquals(baseUrl + "/images/imagesteam/kattypic.jpg", driver.findElement(By.cssSelector(".photo-container img")).getAttribute("src"));
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
