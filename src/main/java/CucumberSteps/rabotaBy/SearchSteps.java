package CucumberSteps.rabotaBy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.selenideMoodpanda.LoginPage;
import pageObjects.selenideRabotaBy.HomePage;
import pageObjects.selenideRabotaBy.VacanciesPage;

public class SearchSteps extends SelenideBaseTest {

    @When("i enter text {string}")
    public void enterText(String text) {
        get(HomePage.class).enterSearch(text);
    }

    @And("i click submit button")
    public void clickSubmitButton() {
        get(HomePage.class).clickSubmit();
    }

    @Then("i check page title {string}")
    public void checkPageTitle(String text) {
        get(VacanciesPage.class).verifyPageTitle(text);
    }

    @And("i check vacancies count more or equal than {int}")
    public void checkVacanciesCount(int count) {
        get(VacanciesPage.class).countVacancies(count);
    }

}
