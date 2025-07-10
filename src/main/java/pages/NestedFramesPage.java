package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Switch into the left frame and return its body text.
     */
    public String getLeftFrameText() {
        // top → left
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    /**
     * Switch into the bottom frame and return its body text.
     */
    public String getBottomFrameText() {
        driver.switchTo().frame("frame-bottom");
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
