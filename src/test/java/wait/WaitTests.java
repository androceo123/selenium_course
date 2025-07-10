package wait;

import base.baseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class WaitTests extends baseTests {

    @Test
    public void testWaitUntilHidden() {
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }

    @Test
    public void testExample2_WaitUntilRendered() {
        var page = homePage
                .clickDynamicLoading() // from HomePage
                .clickExample2(); // our new method
        page.clickStart();
        assertEquals(
                page.getLoadedText(),
                "Hello World!",
                "Loaded text did not match after Example 2 finished loading");
    }
}