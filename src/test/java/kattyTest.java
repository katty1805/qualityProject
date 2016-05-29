/**
 * Created by katty on 29/05/2016.
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

public class kattyTest {
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
    public void testKatty1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).click();
        assertEquals("Daniela Flores", driver.getTitle());
        assertTrue(isElementPresent(By.cssSelector("h1")));
        assertEquals("COUNTER QUALITY TEAM", driver.findElement(By.cssSelector("h1")).getText());
        assertTrue(isElementPresent(By.cssSelector("h2")));
        assertEquals("Software Quality Testers", driver.findElement(By.cssSelector("h2")).getText());
    }

    @Test
    public void testKatty2() throws Exception {
        driver.get(baseUrl+"katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//img")));
        assertEquals(baseUrl+"images/katty.jpg", driver.findElement(By.xpath("//section[@id='services']/article[1]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//h2")));
        assertEquals("ABOUT ME", driver.findElement(By.xpath("//section[@id='services']/article[2]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[1]")));
        assertEquals("Daniela Katherine Flores Taipe", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[2]")));
        assertEquals("Electronic Engineering at ESPE", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[3]")));
        assertEquals("24 years old", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[3]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[4]")));
        assertEquals("Ecuadorian", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[4]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[5]")));
        assertEquals("Quito-Ecuador", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[5]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[6]")));
        assertEquals("CCNA Routing and Switching", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[6]")).getText());
        assertTrue(isElementPresent(By.cssSelector("#copyright > p")));
        assertEquals("Copyright © 2016 - All Rights Reserved - Counter Quality Team", driver.findElement(By.cssSelector("#copyright > p")).getText());
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
