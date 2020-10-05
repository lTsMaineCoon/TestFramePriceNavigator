package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.MainPage;
import util.driverUtils.DriverProvider;
import util.elementUtils.WaitUtils;


public class SearchSteps {
    private MainPage mainPage;
    private DriverProvider driverProvider;
    private WaitUtils wait;


    public SearchSteps(DriverProvider driverProvider) {
        wait = new WaitUtils(driverProvider.getDriver());
        mainPage = new MainPage(driverProvider.getDriver());
        this.driverProvider = driverProvider;
    }

    @When("Enter {string} into search field and press enter")
    public void enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) {
        wait.sendKeysWhenReadyThenEnter(mainPage.header.searchField, searchQuery);
    }

    @Then("NothingToShow search notification should be shown")
    public void textCanBeDeletedFromTheSearchField() {
        Assertions.assertThat(mainPage.header.searchField.getText())
                .as("NothingToShow search notification is not shown")
                .isEmpty();
    }

    @Then("Product not found page is displayed")
    public void productNotFoundPageIsDisplayed() {
        Assertions.assertThat(mainPage.header.nothingToSHowInSearchResult.isDisplayed())
                .as("NothingToShow search notification is not shown").isTrue();
    }


}
