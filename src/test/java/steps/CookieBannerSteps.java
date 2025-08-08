package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CookiesBannerPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CookieBannerSteps {

    CookiesBannerPage cookiesBannerPage;

    WebDriver driver;

    @Given("the user navigates to the start page")
    public void userNavigatesToStartPage() {
        cookiesBannerPage.open(); // Assumes Serenity's PageObject open() navigates to the start page
    }

    @Then("the cookies banner should be visible")
    public void cookiesBannerShouldBeVisible() {
        assertThat(cookiesBannerPage.isBannerVisible()).isTrue();
    }

    @Then("the banner should contain {string} and {string} buttons")
    public void bannerShouldContainButtons(String acceptButtonText, String rejectButtonText) {
        assertThat(cookiesBannerPage.hasButton(acceptButtonText)).isTrue();
        assertThat(cookiesBannerPage.hasButton(rejectButtonText)).isTrue();
    }
//
//    @When("the user clicks the {string} button")
//    public void userClicksButton(String buttonText) {
//        cookiesBannerPage.clickButton(buttonText);
//    }

    @Then("the cookies banner should disappear")
    public void cookiesBannerShouldDisappear() {
        assertThat(cookiesBannerPage.isBannerVisible()).isFalse();
    }

    @Then("a confirmation message should be shown")
    public void confirmationMessageShouldBeShown() {
        assertThat(cookiesBannerPage.isConfirmationMessageVisible()).isTrue();
    }

    @Then("the user's preference should be saved")
    public void userPreferenceShouldBeSaved() {
        assertThat(cookiesBannerPage.isPreferenceSaved()).isTrue();
    }

//    @Given("the user has previously set a cookie preference")
//    public void userHasPreviouslySetCookiePreference() {
//        cookiesBannerPage.setCookiePreference("accepted");
//    }

//    @When("the user revisits the start page")
//    public void userRevisitsStartPage() {
//        cookiesBannerPage.refresh();
//    }

    @Then("the cookies banner should not be visible")
    public void cookiesBannerShouldNotBeVisible() {
        assertThat(cookiesBannerPage.isBannerVisible()).isFalse();
    }

    @Then("the cookies banner should be accessible by keyboard")
    public void cookiesBannerShouldBeAccessibleByKeyboard() {
        assertThat(cookiesBannerPage.isAccessibleByKeyboard()).isTrue();
    }

    @Then("the banner should have appropriate ARIA labels")
    public void bannerShouldHaveAppropriateAriaLabels() {
        assertThat(cookiesBannerPage.hasAppropriateAriaLabels()).isTrue();
    }
}