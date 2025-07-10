package alerts;

import base.baseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends baseTests {

    @Test
    public void testFileUpload() {

        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile(
                "C:\\Users\\Andres Moises\\Desktop\\QA career\\selenium_course\\resources\\chromedriver.exe");        

        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded files incorrect");
    }
}