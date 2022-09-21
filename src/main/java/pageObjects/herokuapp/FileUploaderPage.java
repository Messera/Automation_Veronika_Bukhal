package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class FileUploaderPage extends BasePage {

    private By chooseFileBtn = By.id("file-upload");
    private By uploadFileBtn = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");


    public FileUploaderPage chooseFile(String path){
        driver.findElement(chooseFileBtn).sendKeys(path);
        return this;
    }

    public FileUploaderPage uploadFile(){
        click(uploadFileBtn);
        return this;
    }

    public void checkUpload(String path){
        Assert.assertTrue(path.contains(driver.findElement(uploadedFiles).getText()));
    }


}
