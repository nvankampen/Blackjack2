package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import PageObjects.HomePage;
import Base.Constants;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static Base.Browser.driver;

public class Homepage_Tests {

    private HomePage homePage = new HomePage(driver);

    @Given("^That I am on the home page$")
    public void thatIAmOnTheHomePage() {
        homePage.browserSetup(Constants.homePageUrl);
    }

    @Then("^I verify all elements are present$")
    public void iVerifyAllElementsArePresent() {
        assertEquals(homePage.isAt(driver), Constants.homePageUrl);
        assertEquals(homePage.getHeaderHomeText(), Constants.headerHomeText);

    }

}
