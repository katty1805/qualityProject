import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
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
        //System.out.println(baseUrl);
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
    public void member3HeaderTest() throws Exception
    {
        driver.get(baseUrl);
        driver.findElement(By.id("linkTeam3Info")).click();
        assertEquals("Daniel Vera", driver.getTitle());
        assertTrue(isElementPresent(By.cssSelector("h1")));
        assertEquals("COUNTER QUALITY TEAM", driver.findElement(By.cssSelector("h1")).getText());
        assertTrue(isElementPresent(By.cssSelector("h2")));
        assertEquals("Software Quality Testers", driver.findElement(By.cssSelector("h2")).getText());
    }

    @Test
    public void aboutTest() throws Exception
    {
        driver.get(baseUrl + "dani.html");

        assertTrue(isElementPresent(By.id("teamPhoto")));
        assertEquals(baseUrl+"images/danny.jpg", driver.findElement(By.id("teamPhoto")).getAttribute("src"));

        assertTrue(isElementPresent(By.id("aboutID")));
        assertEquals("ABOUT ME", driver.findElement(By.id("aboutID")).getText());

        assertTrue(isElementPresent(By.id("nameID")));
        assertEquals("Daniel Augusto Vera Yanez", driver.findElement(By.id("nameID")).getText());

        assertTrue(isElementPresent(By.id("careerID")));
        assertEquals("System Engineer", driver.findElement(By.id("careerID")).getText());

        assertTrue(isElementPresent(By.id("deveID")));
        assertEquals("iOS Developer", driver.findElement(By.id("deveID")).getText());

        assertTrue(isElementPresent(By.id("uniID")));
        assertEquals("Universidad de las Fuerzas Armadas - ESPE", driver.findElement(By.id("uniID")).getText());

        assertTrue(isElementPresent(By.id("placeID")));
        assertEquals("Quito - Ecuador", driver.findElement(By.id("placeID")).getText());

        assertTrue(isElementPresent(By.cssSelector("#copyright > p")));
        assertEquals("Copyright © 2016 - All Rights Reserved - Counter Quality Team", driver.findElement(By.cssSelector("#copyright > p")).getText());
    }

    @Test
    public void summaryTest() throws Exception
    {
        driver.get(baseUrl + "dani.html");
        WebElement aboutSection = driver.findElement(By.id("about_section"));
        WebElement summaryCaption = aboutSection.findElement(By.id("summary"));

        assertEquals("SUMMARY", summaryCaption.findElement(By.id("summaryTitle")).getText());
        assertEquals("SUMMARY", summaryCaption.findElement(By.id("summaryTitle")).getText());

        WebElement summaryId = summaryCaption.findElement(By.id("summaryInfo"));
        assertTrue(summaryId.getText().contains("System and computer engineer with 4 years"));
        assertTrue(summaryId.getText().contains("Strong problem- solving skills, quick learner and always"));
        assertTrue(summaryId.getText().contains("latest technologies and best practices."));
    }

    @Test
    public void educationTest() throws Exception
    {
        driver.get(baseUrl + "dani.html");

        assertEquals("EDUCATION", driver.findElement(By.id("educationTitle")).getText());
        assertEquals("2008 - 2014    Universidad de las Fuerzas Armadas - ESPE", driver.findElement(By.id("uName")).getText());
        assertEquals("BEng Computer Systems Engineering Expected result 2:1", driver.findElement(By.id("cName")).getText());

        List<WebElement> allElements = driver.findElements(By.xpath("//ul[@id='iList']/li"));
        String[] interests = {"Enjoyed developing applications for mobile devices."
                , "Developing interest in Artificial Intelligence taking the AI and Games module in my final year."};
        int count = 0;
        for (WebElement element: allElements) {
            //System.out.println(element.getText());
            assertEquals(interests[count], element.getText());
            count++;
        }

        assertTrue(driver.findElement(By.id("tName")).getText().contains("tourism in the historic center of Quito,"));
    }

    @Test
    public void languagesTableTest() throws Exception {
        driver.get(baseUrl + "dani.html");

        WebElement table_element = driver.findElement(By.id("languagesId"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("id('languagesId')/tbody/tr"));

        assertTrue(tr_collection.size() == 7); //NUMBER OF ROWS

        String[] tableColumns = {"Programmes and applications", "Objective-C", "Swift", "Java", "C / C ++", "C#", "SQL"};
        testTable(tr_collection,tableColumns);
    }

    @Test
    public void osTableTest() throws Exception {
        driver.get(baseUrl + "dani.html");

        WebElement table_element = driver.findElement(By.id("osId"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("id('osId')/tbody/tr"));

        assertTrue(tr_collection.size() == 5); //NUMBER OF ROWS

        String[] tableColumns = {"Operating systems", "Mac OS X", "Linux (Debian)", "iOS", "Android"};
        testTable(tr_collection,tableColumns);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private void testTable(List<WebElement> tr_collection, String[] tableColumns)
    {
        int row_num = 0;
        for (WebElement trElement : tr_collection)  {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            assertTrue(td_collection.size() == 3); //NUMBER OF COLUMNS

            WebElement tdElement1 = td_collection.get(0);
            assertEquals(tdElement1.getText(),tableColumns[row_num]);
            row_num++;
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
