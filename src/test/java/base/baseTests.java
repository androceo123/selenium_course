package base;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import pages.HomePage;
import utils.MyEventListener;
import utils.WindowManager;

public class baseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        /*all of this is a bad practica and was done with educational purpuse, these are framework level interactions and should be done
         * in the main section, not in the test section, this is called section practice:
         */

        /*
         * funciones varias
         */
        // 1 - Maximize the window
        // driver.manage().window().maximize();

        // 2 - Fullscreen mode
        // driver.manage().window().fullscreen();

        // 3 - Specific width (iPhoneX)
        // driver.manage().window().setSize(new Dimension(375, 812));

        // System.out.println(driver.getTitle());

        // List<WebElement> links = driver.findElements(By.tagName("a"));
        // System.out.println(links.size());

        /*
         * ejercicio desafio capitulo 3
         */

        // WebElement inputsLink = driver.findElement(By.linkText("Shifting Content"));
        // inputsLink.click();

        // inputsLink=driver.findElement(By.linkText("Example 1: Menu Element"));
        // inputsLink.click();

        // WebElement menu = driver.findElement(By.cssSelector("div.example ul"));
        // List<WebElement> items = menu.findElements(By.tagName("li"));
        // System.out.println("Menu has " + items.size() + " items.");

        /*
         * fin del ejercicio desafio capitulo 3
         */

        /*fin de seccion de malas practicas */
        
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        // your custom listener must implement WebDriverListener
        WebDriverListener listener = new MyEventListener();
        driver = new EventFiringDecorator(listener)
                     .decorate(new ChromeDriver(getChromeOptions()));

        goHome();
        //setCookie();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        //System.out.println("Press Enter to close browser…");
        //try (Scanner scanner = new Scanner(System.in)) {
        //    scanner.nextLine();
        //}
        driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void resetToHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/test.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // 1) prevent Chrome from adding the “Chrome is being controlled by automated test software” infobar:
        options.setExperimentalOption("excludeSwitches",
                                    Collections.singletonList("enable-automation"));
        // 2) disable the old automation extension
        options.setExperimentalOption("useAutomationExtension", false);

        // (optional) also hide the navigator.webdriver flag
        options.addArguments("--disable-blink-features=AutomationControlled");

        //options.addArguments("--headless");

        return options;
    }

    /*cookie helpers */

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    protected void deleteCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    protected boolean isCookiePresent(String name) {
        return driver.manage().getCookieNamed(name) != null;
    }
}