import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
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
    public void index_Text_test() throws  Exception{
        driver.get(baseUrl);

        WebElement webElement = driver.findElement(By.id("hgroup"));
        assertTrue(webElement.getText().contains("COUNTER QUALITY TEAM"));
        assertTrue(webElement.getText().contains("Software Quality Testers"));

        webElement = driver.findElement(By.id("christian_member1"));
        assertTrue(webElement.getText().contains("Christian Bustamante"));
        assertTrue(webElement.getText().contains("Informatic Engineering specialist in virtual reality and game development."));

        webElement = driver.findElement(By.id("katty_member2"));
        assertTrue(webElement.getText().contains("Daniela Flores"));
        assertTrue(webElement.getText().contains("Electronic Enginnering specialist in system network designer."));

        webElement = driver.findElement(By.id("dany_member3"));
        assertTrue(webElement.getText().contains("Daniel Vera"));
        assertTrue(webElement.getText().contains("Informatic Enginnering specialist in native mobile development."));

        webElement = driver.findElement(By.id("linkToAndres"));
        assertTrue(webElement.getAttribute("href").contains("andres.html"));

        webElement = driver.findElement(By.id("linkToKatty"));
        assertTrue(webElement.getAttribute("href").contains("katty.html"));

        webElement = driver.findElement(By.id("linkTeam3Info"));
        assertTrue(webElement.getAttribute("href").contains("dani.html"));

        webElement = driver.findElement(By.id("copyright"));
        assertTrue(webElement.findElement(By.cssSelector("p")).getText().contains("Copyright © 2016 - All Rights Reserved - Counter Quality Team"));
    }

    @Test
    public void index_Images_test() throws  Exception{
        driver.get(baseUrl);

        WebElement webElement = driver.findElement(By.id("IndexPicureID"));
        assertTrue(webElement.getAttribute("src").contains("images/IndexPicture.jpg"));

        webElement = driver.findElement(By.id("imagenAndres"));
        assertTrue(webElement.getAttribute("src").contains("images/andres.jpg"));

        webElement = driver.findElement(By.id("imagenKatty"));
        assertTrue(webElement.getAttribute("src").contains("images/katty2.jpg"));

        webElement = driver.findElement(By.id("imagenDanny"));
        assertTrue(webElement.getAttribute("src").contains("images/danny.jpg"));

    }

    @Test
    public void index_Links_test() throws  Exception{
        driver.get(baseUrl);

        WebElement webElement = driver.findElement(By.id("linkToAndres"));
        assertTrue(webElement.getAttribute("href").contains("andres.html"));

        webElement = driver.findElement(By.id("linkToKatty"));
        assertTrue(webElement.getAttribute("href").contains("katty.html"));

        webElement = driver.findElement(By.id("linkTeam3Info"));
        assertTrue(webElement.getAttribute("href").contains("dani.html"));
    }

    @Test
    public void andres_Text_test() throws  Exception{
        driver.get(baseUrl + "andres.html");

        WebElement webElement = driver.findElement(By.id("hgroup"));
        assertTrue(webElement.getText().contains("COUNTER QUALITY TEAM"));
        assertTrue(webElement.getText().contains("Software Quality Testers"));

        webElement = driver.findElement(By.id("aboutMeID"));
        assertTrue(webElement.getText().contains("ABOUT ME"));
        assertTrue(webElement.getText().contains("Christian Andr&eacutes Bustamante Crespo"));
        assertTrue(webElement.getText().contains("Informatic Enginnering at ESPE"));
        assertTrue(webElement.getText().contains("29 years old Current Master degree student at IPL"));
        assertTrue(webElement.getText().contains("Quito - Ecuador"));

        webElement = driver.findElement(By.id("skillsID"));
        assertTrue(webElement.getText().contains("SKILLS"));
        assertTrue(webElement.getText().contains("PROGRAMMING LANGUAGES: C, C++, C#, Java, Objective-C, Swift,javascript, Phyton, PHP, HTML"));
        assertTrue(webElement.getText().contains("IDES: Visual Studio, Xcode, Netbeans, Eclipse, Android Studio, Xamarin, IntelliJ IDEA, Unity3D, Unreal Engine 4, Autodesk Maya, Autodesk Mudbox, Adobe Ilustrador, Adobe Photoshop"));

        webElement = driver.findElement(By.id("developedProyectsID"));
        assertTrue(webElement.getText().contains("DEVELOPED PROYECTS"));

        webElement = driver.findElement(By.id("showmoreID"));
        assertTrue(webElement.getText().contains("SHOW MORE"));
        assertTrue(webElement.getText().contains("Simulation, Virtual Reality and video Games proyect demos"));

        webElement = driver.findElement(By.id("copyright"));
        assertTrue(webElement.getText().contains("Copyright © 2016 - All Rights Reserved - Counter Quality Team"));

    }

    @Test
    public void andres_Images_test() throws  Exception{
        driver.get(baseUrl + "andres.html");

        WebElement webElement = driver.findElement(By.id("profilePicture"));
        assertTrue(webElement.getAttribute("src").contains("images/andres.jpg"));

        webElement = driver.findElement(By.id("skills_image_id"));
        assertTrue(webElement.getAttribute("src").contains("images/languages.jpg"));

        webElement = driver.findElement(By.id("facebook_logo_id"));
        assertTrue(webElement.getAttribute("src").contains("images/facebook.png"));

        webElement = driver.findElement(By.id("youtube_logo_id"));
        assertTrue(webElement.getAttribute("src").contains("images/youtube_logo.png"));

    }

    @Test
    public void andres_Videos_test() throws  Exception{
        driver.get(baseUrl + "andres.html");

        WebElement webElement = driver.findElement(By.id("video_1"));
        assertTrue(webElement.getAttribute("src").contains("https://www.youtube.com/embed/VbK4XRSwBtY"));

        webElement = driver.findElement(By.id("video_2"));
        assertTrue(webElement.getAttribute("src").contains("https://www.youtube.com/embed/5_QHQ45pQZI"));

        webElement = driver.findElement(By.id("video_3"));
        assertTrue(webElement.getAttribute("src").contains("https://www.youtube.com/embed/Vxpgi4guwz4"));

    }

    @Test
    public void andres_Links_test() throws  Exception{
        driver.get(baseUrl + "andres.html");

        WebElement webElement = driver.findElement(By.id("facebook_link_id"));
        assertTrue(webElement.getAttribute("href").contains("https://www.facebook.com/tribaludic"));

        webElement = driver.findElement(By.id("youtube_id"));
        assertTrue(webElement.getAttribute("href").contains("https://www.youtube.com/watch?v=7eynCtj_74g&index=1&list=UUA5uTzoQIV49CTr4ZJzuULw"));

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
