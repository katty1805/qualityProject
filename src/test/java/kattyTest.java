/**
 * Created by katty on 29/05/2016.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Logger.getLogger("").setLevel(Level.OFF);
    }

    public String useRemote() {
        String remote;
        remote = System.getProperty("url");
        if (remote == null)
            return "http://localhost:8080/team/";
        else
            return remote;
    }

    /*  Test pagina katty*/

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

    /*  Test menu katty*/

    @Test
    public void testKattymenu() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).click();
        assertTrue(isElementPresent(By.xpath("//nav[@id='nav']/ul/li[1]/a")));
        assertEquals("Homepage", driver.findElement(By.xpath("//nav[@id='nav']/ul/li[1]/a")).getText());
        assertTrue(isElementPresent(By.xpath("//nav[@id='nav']/ul/li[2]/a")));
        assertEquals("About Me", driver.findElement(By.xpath("//nav[@id='nav']/ul/li[2]/a")).getText());
        assertTrue(isElementPresent(By.xpath("//nav[@id='nav']/ul/li[3]/a")));
        assertEquals("Abstract", driver.findElement(By.xpath("//nav[@id='nav']/ul/li[3]/a")).getText());
        assertTrue(isElementPresent(By.xpath("//nav[@id='nav']/ul/li[4]/a")));
        assertEquals("Skill", driver.findElement(By.xpath("//nav[@id='nav']/ul/li[4]/a")).getText());
        assertTrue(isElementPresent(By.xpath("//nav[@id='nav']/ul/li[5]/a")));
        assertEquals("Works", driver.findElement(By.xpath("//nav[@id='nav']/ul/li[5]/a")).getText());
    }

    /*  Test menu-links katty*/

    @Test
    public void testKattylinks() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).click();
        driver.findElement(By.xpath("//nav[@id='nav']/ul/li[1]/a")).click();
        assertEquals("Counter Quality Team", driver.getTitle());
        driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).click();
        assertTrue(isElementPresent(By.id("about")));
        driver.findElement(By.xpath("//nav[@id='nav']/ul/li[2]/a")).click();
        assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*#section-about$"));
        assertTrue(isElementPresent(By.id("educat")));
        driver.findElement(By.xpath("//nav[@id='nav']/ul/li[3]/a")).click();
        assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*#section-education$"));
        assertTrue(isElementPresent(By.id("skillt")));
        driver.findElement(By.xpath("//nav[@id='nav']/ul/li[4]/a")).click();
        assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*#section-skills$"));
        assertTrue(isElementPresent(By.id("experid")));
        driver.findElement(By.xpath("//nav[@id='nav']/ul/li[5]/a")).click();
        assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*#section-works$"));
    }


    @Test
    public void testKatty2() throws Exception {
        driver.get(baseUrl+"katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//img")));
        assertEquals(baseUrl+ "images/katty1.jpg", driver.findElement(By.xpath("//section[@id='services']/article[1]//img")).getAttribute("src"));
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



    @Test
    public void testInforedu() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).click();
        assertEquals("", driver.findElement(By.cssSelector("#education > article.one_third > figure > img.round")).getText());
        assertTrue(isElementPresent(By.cssSelector("#education1 > figcaption > h2")));
        assertEquals("EDUCATION", driver.findElement(By.cssSelector("#education1 > figcaption > h2")).getText());
        assertTrue(isElementPresent(By.cssSelector("#education > article.one_third > figure > img.round")));
        assertEquals(baseUrl+"images/education.png", driver.findElement(By.xpath("//section[@id='education']/article[1]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//h2")));
        assertEquals("EDUCATION", driver.findElement(By.xpath("//section[@id='education']/article[2]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[1]/td[1]")));
        assertEquals("1996-2003", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[1]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[1]/td[2]")));
        assertEquals("Colegio Bilingue Franz Schubert", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[1]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[2]/td[1]")));
        assertEquals("2003-2009", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[2]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[2]/td[2]")));
        assertEquals("Colegio Municipal Experimental Sebastian de Benalcázar", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[2]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[3]/td[1]")));
        assertEquals("2009-2015", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[3]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[3]/td[2]")));
        assertEquals("Electronic Network and Comunication Data Engineering", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[3]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[4]/td[1]")));
        assertEquals("Thesis", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[4]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[4]/td[2]")));
        assertEquals("Optimización del algoritmo de encriptación asimétrica", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[4]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='education']/article[2]//tr[5]/td[2]")));
        assertEquals("RSA para la mitigación de ataques de seguridad de redes", driver.findElement(By.xpath("//section[@id='education']/article[2]//tr[5]/td[2]")).getText());
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
