package alerts;

import base.baseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;

public class FileUploadTests extends baseTests {

    @Test
    public void testFileUpload() {

        // projectDir points to the root of the repo on *any* machine
    String projectDir = System.getProperty("user.dir");
    String filePath = Paths.get(projectDir, "resources", "chromedriver.exe")
                          .toAbsolutePath()
                          .toString();

    var uploadPage = homePage.clickFileUpload();
    uploadPage.uploadFile(filePath);        

        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded files incorrect");
    }
}