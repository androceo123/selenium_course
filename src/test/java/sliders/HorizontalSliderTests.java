// in your test package, e.g. sliders/HorizontalSliderTests.java
package sliders;

import base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends baseTests {

    @Test
    public void testSliderToFour() {
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setSliderToValue("4");
        assertEquals(sliderPage.getRangeValue(), "4");
    }
}
