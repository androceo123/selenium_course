package frames;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.baseTests;
import pages.NestedFramesPage;

public class NestedFramesTest extends baseTests {

    @Test
    public void checkLeftAndBottomFrames() {
        // 1) from the home page click into Frames → Nested Frames
        NestedFramesPage nested = homePage.clickNestedFrames();

        // 2) verify the left frame
        String left = nested.getLeftFrameText();
        Assert.assertEquals(left, "LEFT", "Left frame did not contain expected text");

        // 3) verify the bottom frame
        String bottom = nested.getBottomFrameText();
        Assert.assertEquals(bottom, "BOTTOM", "Bottom frame did not contain expected text");
    }
}
