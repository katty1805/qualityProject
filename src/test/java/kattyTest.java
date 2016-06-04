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

    /*  Test encabezado katty*/

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

    /*  Test parte 1 about me-fila 1-columna1-2*/

    @Test
    public void testAboutmeKatty() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[1]//img")));
        assertEquals(baseUrl+ "images/katty1.jpg", driver.findElement(By.xpath("//section[@id='services']/article[1]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//h2")));
        assertEquals("ABOUT ME", driver.findElement(By.xpath("//section[@id='services']/article[2]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='services']/article[2]//p")));
        assertEquals("I am Daniela Flores and I am a student of a Master's in Computer Engineering and Mobile Computing, with a passion for computers and electronics. I love tinkering around with stuff and see what I can make without blowing everything up. That's why I decided to major in electronics, networks and data communication, where I learned most of the things I know today. This way I could join all my passions and master them. As my thesis, I did a study on the optimization of encryption algorythms. I have worked as a network administrator for iPlanet where I was responsible for managing a whole team of technicians. I specialize in network design for companies and always aim to be the best I can at my work. I'm always open to exciting job opportunities.", driver.findElement(By.xpath("//section[@id='services']/article[2]//p")).getText());
    }

    /*  Test parte 2 about me-fila 2-columna1*/

    @Test
    public void testLinksFbTwit() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertTrue(isElementPresent(By.xpath("//ul[@id='top-social']/li[1]//img")));
        assertEquals(baseUrl+"images/facebook.png", driver.findElement(By.xpath("//ul[@id='top-social']/li[1]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.xpath("//ul[@id='top-social']/li[2]//img")));
        assertEquals(baseUrl+"images/twitter.png", driver.findElement(By.xpath("//ul[@id='top-social']/li[2]//img")).getAttribute("src"));
        assertEquals("https://es-la.facebook.com/katty.flores.58", driver.findElement(By.xpath("//ul[@id='top-social']/li[1]/a")).getAttribute("href"));
        driver.findElement(By.xpath("//ul[@id='top-social']/li[1]/a")).click();
        assertEquals("Katty Flores | Facebook", driver.getTitle());
        driver.get(baseUrl + "katty.html");
        assertEquals("https://twitter.com/Kathbonita", driver.findElement(By.xpath("//ul[@id='top-social']/li[2]/a")).getAttribute("href"));
        driver.findElement(By.xpath("//ul[@id='top-social']/li[2]/a")).click();
        assertEquals("Katty Flores (@Kathbonita) on Twitter", driver.getTitle());
    }

    /*  Test parte 2 about me-fila 2-columna2*/
    @Test
    public void testContactdetailsKatty() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//h2")));
        assertEquals("CONTACT DETAILS", driver.findElement(By.xpath("//section[@id='details']/article[2]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[1]/td[1]")));
        assertEquals("Name", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[1]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[1]/td[2]")));
        assertEquals("Daniela Katherine Flores Taipe", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[1]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[2]/td[1]")));
        assertEquals("Career", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[2]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[2]/td[2]")));
        assertEquals("Electronic Engineering at ESPE", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[2]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[3]/td[1]")));
        assertEquals("Age", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[3]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[3]/td[2]")));
        assertEquals("24 years old", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[3]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[4]/td[1]")));
        assertEquals("Address", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[4]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[4]/td[2]")));
        assertEquals("Urb. Terranova Mnz C", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[4]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[5]/td[1]")));
        assertEquals("Telephone", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[5]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[5]/td[2]")));
        assertEquals("(+593)984147860", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[5]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[6]/td[1]")));
        assertEquals("e-mail", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[6]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[6]/td[2]")));
        assertEquals("kattyf_@hotmail.com", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[6]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[7]/td[1]")));
        assertEquals("Nationality", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[7]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[7]/td[2]")));
        assertEquals("Ecuadorian", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[7]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[8]/td[1]")));
        assertEquals("More", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[8]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[8]/td[2]")));
        assertEquals("CCNA Routing and Switching", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[8]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[9]/td[1]")));
        assertEquals("Thesis", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[9]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[9]/td[2]")));
        assertEquals("Optimización del algoritmo de encriptación asimétrica", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[9]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='details']/article[2]//tr[10]/td[2]")));
        assertEquals("RSA para la mitigación de ataques de seguridad de redes", driver.findElement(By.xpath("//section[@id='details']/article[2]//tr[10]/td[2]")).getText());
    }


    /*  Test parte 1 education-fila 1-columna1*/

    @Test
    public void testEducationKatty() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='educa1']/article[1]//h2")));
        assertEquals("EDUCATION", driver.findElement(By.xpath("//section[@id='educa1']/article[1]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa2']/article[1]//img")));
        assertEquals(baseUrl+"images/education.png", driver.findElement(By.xpath("//section[@id='educa2']/article[1]//img")).getAttribute("src"));
    }

    /*  Test parte 1 education-numero de elementos*/

    @Test
    public void testEduca() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertEquals(3, driver.findElements(By.xpath("//div[@id='educa']//section")).size());
    }

    /*  Test parte 1 education-tres elementos columna1-fila1*/

    @Test
    public void testEducation2Katty() throws Exception {
        driver.get(baseUrl+ "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='educa1']/article[2]//h3")));
        assertEquals("University", driver.findElement(By.xpath("//section[@id='educa1']/article[2]//h3")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa1']/article[2]//h4")));
        assertEquals("Electronic Network and Comunication Data Engineering • 2009-2015", driver.findElement(By.xpath("//section[@id='educa1']/article[2]//h4")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa1']/article[2]//img")));
        assertEquals(baseUrl+"images/espe.jpg", driver.findElement(By.xpath("//section[@id='educa1']/article[2]//img")).getAttribute("src"));
        assertTrue(driver.findElement(By.xpath("//section[@id='educa1']/article[2]//a")).getAttribute("href").matches("^http://www\\.espe\\.edu\\.ec/portal/portal/main\\.do[\\s\\S]sectionCode=118$"));
        driver.findElement(By.xpath("//section[@id='educa1']/article[2]//a")).click();
        assertEquals("ESPE Home", driver.getTitle());
        driver.navigate().back();
        assertTrue(isElementPresent(By.xpath("//section[@id='educa2']/article[2]//h3")));
        assertEquals("College", driver.findElement(By.xpath("//section[@id='educa2']/article[2]//h3")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa2']/article[2]//h4")));
        assertEquals("Colegio Municipal Experimental Sebastian de Benalcázar • 2003-2009", driver.findElement(By.xpath("//section[@id='educa2']/article[2]//h4")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa2']/article[2]//img")));
        assertEquals(baseUrl+"images/benalcazar.jpg", driver.findElement(By.xpath("//section[@id='educa2']/article[2]//img")).getAttribute("src"));
        assertEquals("http://www.educacion.quito.gob.ec/unidades/sebastiandebenalcazar/", driver.findElement(By.xpath("//section[@id='educa2']/article[2]//a")).getAttribute("href"));
        driver.findElement(By.xpath("//section[@id='educa2']/article[2]//a")).click();
        assertEquals("Inicio - Unidad Educativa Municipal Sebastián de Benalcázar", driver.getTitle());
        driver.navigate().back();
        assertTrue(isElementPresent(By.xpath("//section[@id='educa3']/article[2]//h3")));
        assertEquals("School", driver.findElement(By.xpath("//section[@id='educa3']/article[2]//h3")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa3']/article[2]//h4")));
        assertEquals("Colegio Bilingue Franz Schubert • 1996-2003", driver.findElement(By.xpath("//section[@id='educa3']/article[2]//h4")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='educa3']/article[2]//img")));
        assertEquals(baseUrl+"images/franz.jpg", driver.findElement(By.xpath("//section[@id='educa3']/article[2]//img")).getAttribute("src"));
        assertEquals("http://franzschubertschool.com/", driver.findElement(By.xpath("//section[@id='educa3']/article[2]//a")).getAttribute("href"));
        driver.findElement(By.xpath("//section[@id='educa3']/article[2]//a")).click();
        assertEquals("http://franzschubertschool.com/", driver.getCurrentUrl());

    }

     /*  Test parte 2 work-fila2-columna1*/

    @Test
    public void testWorkKatty() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='work1']/article[1]//h2")));
        assertEquals("WORK", driver.findElement(By.xpath("//section[@id='work1']/article[1]//h2")).getText());
        // TODO: ingresar la imagen work
    }

    /*  Test parte 2 work-numero de elementos*/

    @Test
    public void testWork() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertEquals(2, driver.findElements(By.xpath("//div[@id='works']//section")).size());
    }

    /*  Test parte 2 work-dos elementos columna1-fila2*/

    @Test
    public void testWork2Katty() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='work1']/article[2]//h3")));
        assertEquals("Universidad de las Fuerzas Armadas-ESPE", driver.findElement(By.xpath("//section[@id='work1']/article[2]//h3")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='work1']/article[2]//h4")));
        assertEquals("Researcher of Cybersecurity • 02 de Marzo - 31 de Agosto del 2015", driver.findElement(By.xpath("//section[@id='work1']/article[2]//h4")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='work1']/article[2]//p")));
        assertEquals("Researcher for the project \"TRAINING COMPUTING PLATFORMS, EXPERIMENTATION, MANAGEMENT AND MITIGATION ATTACKS CYBERSECURITY\"", driver.findElement(By.xpath("//section[@id='work1']/article[2]//p")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='work1']/article[2]//img")));
        assertEquals(baseUrl+"images/icon1.png", driver.findElement(By.xpath("//section[@id='work1']/article[2]//img")).getAttribute("src"));
        assertTrue(isElementPresent(By.xpath("//section[@id='work2']/article[2]//h3")));
        assertEquals("Empresa IPLANET", driver.findElement(By.xpath("//section[@id='work2']/article[2]//h3")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='work2']/article[2]//h4")));
        assertEquals("Technical Support Assistant • Enero - Mayo 2014", driver.findElement(By.xpath("//section[@id='work2']/article[2]//h4")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='work2']/article[2]//p")));
        assertEquals("Support Assistant, managing antennas and routers, and reset monitoring equipment StationM5 Nano and IP audits", driver.findElement(By.xpath("//section[@id='work2']/article[2]//p")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='work2']/article[2]//img")));
        assertEquals(baseUrl+"images/iplanet.png", driver.findElement(By.xpath("//section[@id='work2']/article[2]//img")).getAttribute("src"));
    }


    /*  Test parte 1 skill columna1-fila1-2*/

    @Test
    public void testSkill1Katty() throws Exception {
        driver.get(baseUrl+ "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='skill1']/article[1]//h2")));
        assertEquals("SKILLS", driver.findElement(By.xpath("//section[@id='skill1']/article[1]//h2")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[1]//img")));
        assertEquals(baseUrl+"images/skill.png", driver.findElement(By.xpath("//section[@id='skill2']/article[1]//img")).getAttribute("src"));
    }

    /*  Test parte 2 skill elementos-columna1-fila2*/

    @Test
    public void testSkill() throws Exception {
        driver.get(baseUrl + "katty.html");
        assertEquals(8, driver.findElements(By.xpath("//section[@id='skill2']//tr/td[1]")).size());
    }
    /*  Test parte 3 skill elementos-columna1-fila2*/

    @Test
    public void testSkill2Katty() throws Exception {
        driver.get(baseUrl+ "katty.html");
        assertTrue(isElementPresent(By.xpath("//section[@id='skill1']/article[2]//p")));
        assertEquals("Knowledge Networks and Data Communication", driver.findElement(By.xpath("//section[@id='skill1']/article[2]//p")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[1]/td[1]")));
        assertEquals("Design Structure Networks", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[1]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[1]/td[2]")));
        assertEquals("80%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[1]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[2]/td[1]")));
        assertEquals("Fiber Optic (Optical Communication)", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[2]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[2]/td[2]")));
        assertEquals("55%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[2]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[3]/td[1]")));
        assertEquals("Internetworking with TCP/IP", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[3]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[3]/td[2]")));
        assertEquals("75%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[3]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[4]/td[1]")));
        assertEquals("Network Security", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[4]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[4]/td[2]")));
        assertEquals("80%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[4]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[5]/td[1]")));
        assertEquals("Project Management Network", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[5]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[5]/td[2]")));
        assertEquals("75%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[5]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[6]/td[1]")));
        assertEquals("IP Tephony", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[6]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[6]/td[2]")));
        assertEquals("50%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[6]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[7]/td[1]")));
        assertEquals("JAVA", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[7]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[7]/td[2]")));
        assertEquals("75%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[7]/td[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[8]/td[1]")));
        assertEquals("Wireless Networks", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[8]/td[1]")).getText());
        assertTrue(isElementPresent(By.xpath("//section[@id='skill2']/article[2]//tr[8]/td[2]")));
        assertEquals("75%", driver.findElement(By.xpath("//section[@id='skill2']/article[2]//tr[8]/td[2]")).getText());
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
