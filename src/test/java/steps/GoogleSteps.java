package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import utils.Driver;
import utils.TextHandler;

public class GoogleSteps {


    WebDriver driver;
    GoogleSearchPage googleSearchPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        googleSearchPage = new GoogleSearchPage();
    }

    @When("user search for {string}")
    public void user_search_for(String key) {
        System.out.println(key);
        googleSearchPage.searchInputBox.sendKeys(key + Keys.ENTER);

    }


    @Then("user should see results are more than {int}")
    public void userShouldSeeResultsAreMoreThan(int result) {

        // About 11,090,000,000 results (0.69 seconds)
        // {"About", "11,090,000,000", "results", "(0.69", "seconds)"}
        Assert.assertTrue(TextHandler.getLong(googleSearchPage.resultBar.getText().split(" ")[1]) > result);
    }
}