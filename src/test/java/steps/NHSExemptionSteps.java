package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import tasks.NavigateFromStartPage;
import pages.NHSExemptionStartPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NHSExemptionSteps {

    NHSExemptionStartPage startPage = new NHSExemptionStartPage();
    NavigateFromStartPage navigationTask = new NavigateFromStartPage(startPage);


    @Given("I am on the NHS exemption start page")
    public void iAmOnTheStartPage() {
        startPage.open();
    }

    @When("I click the {string} link")
    public void iClickTheLink(String linkText) {
        navigationTask.clickLink(linkText);
    }

    @Then("I should be taken to the {string} page")
    public void iShouldBeTakenToThePage(String expectedPageTitle) {
        String actualTitle = startPage.getCurrentPageTitle();
        String pageContent = startPage.getPageContent();
        String currentUrl = startPage.getCurrentUrl();

        assertThat(actualTitle)
                .as("Expected page title to contain: " + expectedPageTitle)
                .containsIgnoringCase(expectedPageTitle);

        assertThat(pageContent)
                .as("Expected page content to contain: " + expectedPageTitle)
                .containsIgnoringCase(expectedPageTitle);

        assertThat(currentUrl)
                .as("Expected URL to contain: " + expectedPageTitle)
                .containsIgnoringCase(expectedPageTitle.replace(" ", "-"));
    }

    // Optional: Footer link presence check
    @Then("the footer should contain the link {string}")
    public void footerShouldContainLink(String linkText) {
        assertThat(startPage.footerContainsLinkText(linkText))
                .as("Expected footer to contain link: " + linkText)
                .isTrue();
    }
}
