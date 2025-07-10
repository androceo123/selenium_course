package utils;

import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyEventListener implements WebDriverListener {
    @Override
    public void beforeClick(WebElement element) {
        System.out.println("About to click: " + element.getText());
    }
    // override other methods as needed
}