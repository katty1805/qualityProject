import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Christian on 5/29/16.
 */

public class christian_tests {

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
            return "http://localhost:8080/team/";
        else
            return remote;
    }

    @Test
    public void testCompleteChristianProfile() throws Exception {
        driver.get(baseUrl);
        assertEquals("COUNTER QUALITY TEAM", driver.findElement(By.cssSelector("h1")).getText());
        assertEquals("Software Quality Testers", driver.findElement(By.cssSelector("h2")).getText());
        assertTrue(isElementPresent(By.cssSelector("figure > img")));
        assertEquals("Christian Bustamante", driver.findElement(By.cssSelector("#christian_member1 > h2")).getText());
        assertEquals("Informatic Engineering specialist in virtual reality and game development.", driver.findElement(By.cssSelector("p")).getText());
        driver.findElement(By.linkText("Read More »")).click();
        assertEquals("COUNTER QUALITY TEAM", driver.findElement(By.cssSelector("h1")).getText());
        assertEquals("Software Quality Testers", driver.findElement(By.cssSelector("h2")).getText());
        assertTrue(isElementPresent(By.cssSelector("img")));
        assertEquals("ABOUT ME", driver.findElement(By.cssSelector("figcaption > h2")).getText());
        assertEquals("Christian Andr&eacutes Bustamante Crespo", driver.findElement(By.cssSelector("p")).getText());
        assertEquals("Informatic Enginnering at ESPE", driver.findElement(By.xpath("//section[@id='services']/article[2]/figcaption/p[2]")).getText());
        assertEquals("29 years old", driver.findElement(By.xpath("//section[@id='services']/article[2]/figcaption/p[3]")).getText());
        assertEquals("Game development specialist", driver.findElement(By.xpath("//section[@id='services']/article[2]/figcaption/p[4]")).getText());
        assertEquals("Current Master degree student at IPL", driver.findElement(By.xpath("//section[@id='services']/article[2]/figcaption/p[5]")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}
