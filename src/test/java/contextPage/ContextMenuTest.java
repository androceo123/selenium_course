package contextPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import base.baseTests;
import pages.ContextMenuPage;
import pages.HomePage;

public class ContextMenuTest extends baseTests{
    private ContextMenuPage contextMenuPage;

    @Test
    public void shouldShowAlertOnRightClick() {
        contextMenuPage=homePage.clickContextMenuPage();
        contextMenuPage.rightClickHotSpot();

        String alertText = contextMenuPage.getAlertText();
        Assert.assertEquals(alertText, "You selected a context menu",
                "Alert text did not match expected");

        contextMenuPage.acceptAlert();
    }
}