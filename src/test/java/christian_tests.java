import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.SystemClock;

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

        WebElement basicInfo = driver.findElement(By.id("chochoInfoID"));
        assertTrue(basicInfo.getText().contains("ABOUT ME"));
        assertTrue(basicInfo.getText().contains("Christian Andr&eacutes Bustamante Crespo"));
        assertTrue(basicInfo.getText().contains("Informatic Enginnering at ESPE"));
        assertTrue(basicInfo.getText().contains("29 years old Current Master degree student at IPL"));
        assertTrue(basicInfo.getText().contains("Quito - Ecuador"));

        assertTrue(isElementPresent(By.cssSelector("#Christian_homepage > article.one_third > figure > img")));
        assertEquals("SKILLS", driver.findElement(By.cssSelector("#Christian_homepage > article.one_third.lastbox > figcaption > h2")).getText());
        assertEquals("PROGRAMMING LANGUAGES: C, C++, C#, Java, Objective-C, Swift,javascript, Phyton, PHP, HTML", driver.findElement(By.cssSelector("p")).getText());
        assertEquals("IDES: Visual Studio, Xcode, Netbeans, Eclipse, Android Studio, Xamarin, IntelliJ IDEA, Unity3D, Unreal Engine 4, Autodesk Maya, Autodesk Mudbox, Adobe Ilustrador, Adobe Photoshop", driver.findElement(By.xpath("//div[@id='Christian_homepage']/article[2]/figcaption/p[2]")).getText());
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
