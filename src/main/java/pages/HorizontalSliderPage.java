// pages/HorizontalSliderPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.xpath("//input[@type='range']");
    private By rangeValue = By.id("range");
    private static final double STEP = 0.5;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSliderToValue(String targetValue) {
        WebElement sliderEl = driver.findElement(slider);
        sliderEl.click(); // focus to receive key events

        double current = Double.parseDouble(getRangeValue());
        double target = Double.parseDouble(targetValue);
        int steps = (int) Math.round((target - current) / STEP);

        Keys key = steps > 0 ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT;
        for (int i = 0; i < Math.abs(steps); i++) {
            sliderEl.sendKeys(key);
        }
    }

    public String getRangeValue() {
        return driver.findElement(rangeValue).getText();
    }
}
