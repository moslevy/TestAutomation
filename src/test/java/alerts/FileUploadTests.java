package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage =  homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/mlevy/Projects/testautomationu/webdriver_java/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver","Uploaded");
    }
}
