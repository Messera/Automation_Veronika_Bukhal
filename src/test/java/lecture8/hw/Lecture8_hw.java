package lecture8.hw;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;

import static pageObjects.herokuapp.NavigationItems.FRAMES;


public class Lecture8_hw extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test
    public void dynamicControls_Test() {
        new NavigationPage()
                .navigateTo(NavigationItems.DYNAMIC_CONTROLS);
        new DynamicControlsPage()
                .clickCheckboxBtn()
                .checkboxIsGone();
        new DynamicControlsPage()
                .inputAvailability()
                .clickInputBtn()
                .inputEnabled();
        new DynamicControlsPage()
                .inputAvailability();

    }

    @Test
    public void fileUpload_Test() {
        new NavigationPage()
                .navigateTo(NavigationItems.FILE_UPLOADER);
        String path = "/Users/veronikab/Downloads/MicrosoftTeams-image(307).png";
        new FileUploaderPage()
                .chooseFile(path)
                .uploadFile()
                .checkUpload(path);
    }


    @Test
    public void frames_Test() {
        new NavigationPage()
                .navigateTo(FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .checkText();


    }
}
