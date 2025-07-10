// src/main/java/pages/ContextMenuPage.java
package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage{
    private WebDriver driver;
    private By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Right‑clicks on the dashed box to trigger the JS alert.
     */
    public void rightClickHotSpot() {
        new Actions(driver)
                .contextClick(driver.findElement(hotSpot))
                .perform();
    }

    /**
     * Returns the text of the displayed alert.
     */
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Accepts (clicks “OK” on) the alert.
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
