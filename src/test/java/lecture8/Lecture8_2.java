package lecture8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;

import static pageObjects.herokuapp.NavigationItems.*;

public class Lecture8_2 extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test (enabled = false)
    public void dynamicLoading_Test(){
        new NavigationPage()
                .navigateTo(DYNAMIC_LOADING);
        new DynamicLoadingPage()
                .clickOnExample("Example 1")
                .clickOnStart()
                .pageIsLoaded();
    }
    //не кликает старт
    //??

    @Test
    public void scrollPage_Test() {
        new NavigationPage()
                .navigateTo(INFINITE_SCROLL);
        new InfiniteScrollPage().infiniteScroll(10);
    }

    @Test
    public void contextMenu_Test() {
        new NavigationPage().open().navigateTo(CONTEXT_MENU);
        new ContextMenuPage().clickContext().verifyAlert("You selected a context menu");
    }

    @Test
    public void frame_Test() {
        new NavigationPage()
                .navigateTo(FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .switchToFrame()
                .enterText("Hello World!")
                .unSwitchFrame()
                .clickBoldText();
        //не удаляет текст
        //??
    }
}
