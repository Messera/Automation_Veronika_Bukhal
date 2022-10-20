package lecture13;

import org.testng.annotations.Test;
import pageFactory.moodpanda.HomePage;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUp;
import pageObjects.moodpanda.entity.SignUpBuilder;

public class SignUpValueObject_Test extends BaseTest {

    @Test
    public void login_Test(){
        new HomePage()
                .open();
        new NavigationPage().clickSignUp();

        SignUp signUp = new SignUp() {{
            setEmail("email");
            setCheckbox(true);
            setFirstName("First Name");
            setLastName("S");
            setPassword("password");
        }};

        new SignUpPage().enterData(signUp);
    }

    @Test
    public void loginBuilder_Test() {
        new HomePage().open();
        new NavigationPage().clickSignUp();

        SignUpBuilder signUp = new SignUpBuilder.BuilderSignUp()
                .withEmail("email")
                .withLastName("S")
                .withFirstName("First Name")
                .withCheckbox(false)
                .withPassword("password")
                .create();

        new SignUpPage().enterData(signUp);


    }
}

