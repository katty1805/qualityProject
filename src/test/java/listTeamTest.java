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
            return "http://localhost:8080/team/";
        else
            return remote;
    }
    @Test
    public void testHomeInfo() throws Exception {
        driver.get(baseUrl);
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | frame | ]]
        assertEquals("Counter Quality Team", driver.getTitle());
        assertTrue(isElementPresent(By.cssSelector("h1")));
        assertEquals("COUNTER QUALITY TEAM", driver.findElement(By.cssSelector("h1")).getText());
        assertTrue(isElementPresent(By.cssSelector("h2")));
        assertEquals("Software Quality Testers", driver.findElement(By.cssSelector("h2")).getText());

    }

    @Test
    public void testImage() throws Exception {
        driver.get(baseUrl);
        assertTrue(isElementPresent(By.cssSelector("img")));
        assertEquals(baseUrl+"images/IndexPicture.jpg", driver.findElement(By.cssSelector("img")).getAttribute("src"));
    }

    @Test
    public void testMembers() throws Exception {
        driver.get(baseUrl);
        assertEquals(3, driver.findElements(By.xpath("//section[@id='services']/article")).size());
    }

    @Test
    public void testAndres() throws Exception {
        driver.get(baseUrl);
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//img")));
        assertEquals(baseUrl+"images/andres.jpg", driver.findElement(By.xpath("//section[@id='services']/article[1]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.cssSelector("#christian_member1 > h2")));
        assertEquals("Christian Bustamante", driver.findElement(By.cssSelector("#christian_member1 > h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//p")));
        assertEquals("Informatic Engineering specialist in virtual reality and game development.", driver.findElement(By.xpath("//section[@id='services']/article[1]//p")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//a")));
        assertEquals("Read More »", driver.findElement(By.xpath("//section[@id='services']/article[1]//a")).getText());
        assertEquals(baseUrl+"andres.html", driver.findElement(By.xpath("//section[@id='services']/article[1]//a")).getAttribute("href"));
    }

    @Test
    public void testKatty() throws Exception {
        driver.get(baseUrl);
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//img")));
        assertEquals(baseUrl+ "images/katty2.jpg", driver.findElement(By.xpath("//section[@id='services']/article[2]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.cssSelector("#katty_member2 > h2")));
        assertEquals("Daniela Flores", driver.findElement(By.cssSelector("#katty_member2 > h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p")));
        assertEquals("Electronic Enginnering specialist in system network designer.", driver.findElement(By.xpath("//section[@id='services']/article[2]//p")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//a")));
        assertEquals("Read More »", driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).getText());
        assertEquals(baseUrl+"katty.html", driver.findElement(By.xpath("//section[@id='services']/article[2]//a")).getAttribute("href"));
    }

    @Test
    public void testDanny() throws Exception {
        driver.get(baseUrl);
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[3]//img")));
        assertEquals(baseUrl+"images/danny.jpg", driver.findElement(By.xpath("//section[@id='services']/article[3]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.cssSelector("#dany_member3 > h2")));
        assertEquals("Daniel Vera", driver.findElement(By.cssSelector("#dany_member3 > h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[3]//p")));
        assertEquals("Informatic Enginnering specialist in native mobile development.", driver.findElement(By.xpath("//section[@id='services']/article[3]//p")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[3]//a")));
        assertEquals("Read More »", driver.findElement(By.xpath("//section[@id='services']/article[3]//a")).getText());
        assertEquals(baseUrl+"dani.html", driver.findElement(By.xpath("//section[@id='services']/article[3]//a")).getAttribute("href"));
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
