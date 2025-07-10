package navigation;

import base.baseTests;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends baseTests {
    
    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");

    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testOpenExample1WithCtrlClickAndVerifyStartButton() {
        // 1. Navigate to the Dynamic Loading page
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();

        // 2. Ctrl+click “Example 1” to open in a new tab
        DynamicLoadingExample1Page example1Page = dynamicLoadingPage.openExample1InNewTab();

        // 3. Switch to the new tab (using a unique part of the URL or title)
        getWindowManager().switchToTab("/dynamic_loading/1");

        // 4. Verify the “Start” button is present
        Assert.assertTrue(example1Page.isStartButtonVisible(),
                "Expected the Start button to be visible on Example 1 page");
    }
}