package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        // wait until the #finish element appears and is visible
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loadedText));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
