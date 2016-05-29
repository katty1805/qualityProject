import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by danielvera on 5/29/16.
 */
public class teamMember3InfoTest {

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
    public void member3HeaderTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("linkTeam3Info")).click();
        assertEquals("Daniel Vera", driver.getTitle());
        assertTrue(isElementPresent(By.cssSelector("h1")));
        assertEquals("COUNTER QUALITY TEAM", driver.findElement(By.cssSelector("h1")).getText());
        assertTrue(isElementPresent(By.cssSelector("h2")));
        assertEquals("Software Quality Testers", driver.findElement(By.cssSelector("h2")).getText());
    }

    @Test
    public void member3InfoTest() throws Exception
    {
        driver.get(baseUrl+"dani.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//img")));
        assertEquals(baseUrl+"images/danny.jpg", driver.findElement(By.xpath("//section[@id='services']/article[1]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//h2")));
        assertEquals("ABOUT ME", driver.findElement(By.xpath("//section[@id='services']/article[2]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[1]")));
        assertEquals("Daniel Augusto Vera Yanez", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[2]")));
        assertEquals("System Engineer", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[3]")));
        assertEquals("iOS Developer", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[3]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[4]")));
        assertEquals("Universidad de las Fuerzas Armadas - ESPE", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[4]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p[5]")));
        assertEquals("Quito - Ecuador", driver.findElement(By.xpath("//section[@id='services']/article[2]//p[5]")).getText());
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

}
