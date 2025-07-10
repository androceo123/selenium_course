package dropdown;

import base.baseTests;
import pages.DropdownPage;
import pages.HomePage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownTests extends baseTests {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

    @Test
    public void testSelectMultipleOptions() {
        var dropDownPage = homePage.clickDropDown();

        // 1) enable multiple-selection via JavaScript
        dropDownPage.enableMultiple();

        // 2) pick both options
        dropDownPage.selectFromDropDown("Option 1");
        dropDownPage.selectFromDropDown("Option 2");

        // 3) verify exactly those two are selected
        List<String> selected = dropDownPage.getSelectedOptions();
        assertEquals(selected.size(), 2, "Should have selected exactly two options");
        assertTrue(selected.contains("Option 1"), "Option 1 must be selected");
        assertTrue(selected.contains("Option 2"), "Option 2 must be selected");
    }
}