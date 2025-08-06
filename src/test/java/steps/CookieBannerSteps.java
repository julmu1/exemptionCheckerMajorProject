package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class CookiesBannerSteps {

    WebDriver driver;

    @Given("the user navigates to the start page")
    public void userNavigatesToStartPage() {
        driver.get("https://check-my-nhs-exemption.nhsbsa.nhs.uk/start");
    }

    @Then("the cookies banner should be visible")
    public void cookiesBannerShouldBeVisible() {
        WebElement banner = driver.findElement(By.id("cookies-banner"));
        assertThat(banner.isDisplayed()).isTrue();
    }

    @Then("the banner should contain {string} and {string} buttons")
    public void bannerShouldContainButtons(String acceptButtonText, String rejectButtonText) {
        WebElement acceptButton = driver.findElement(By.id("accept-cookies"));
        WebElement rejectButton = driver.findElement(By.id("reject-cookies"));
        assertThat(acceptButton.getText()).isEqualTo(acceptButtonText);
        assertThat(rejectButton.getText()).isEqualTo(rejectButtonText);
    }

    @When("the user clicks the {string} button")
    public void userClicksButton(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));
        button.click();
    }

    @Then("the cookies banner should disappear")
    public void cookiesBannerShouldDisappear() {
        WebElement banner = driver.findElement(By.id("cookies-banner"));
        assertThat(banner.isDisplayed()).isFalse();
    }

    @Then("a confirmation message should be shown")
    public void confirmationMessageShouldBeShown() {
        WebElement confirmationMessage = driver.findElement(By.id("cookies-confirmation"));
        assertThat(confirmationMessage.isDisplayed()).isTrue();
    }

    @Then("the user's preference should be saved")
    public void userPreferenceShouldBeSaved() {
        String cookieValue = driver.manage().getCookieNamed("cookies-preference").getValue();
        assertThat(cookieValue).isNotEmpty();
    }

    @Given("the user has previously set a cookie preference")
    public void userHasPreviouslySetCookiePreference() {
        driver.manage().addCookie(new org.openqa.selenium.Cookie("cookies-preference", "accepted"));
    }

    @When("the user revisits the start page")
    public void userRevisitsStartPage() {
        driver.navigate().refresh();
    }

    @Then("the cookies banner should not be visible")
    public void cookiesBannerShouldNotBeVisible() {
        assertThat(driver.findElements(By.id("cookies-banner")).isEmpty()).isTrue();
    }

    @Then("the cookies banner should be accessible by keyboard")
    public void cookiesBannerShouldBeAccessibleByKeyboard() {
        WebElement banner = driver.findElement(By.id("cookies-banner"));
        assertThat(banner.getAttribute("tabindex")).isNotNull();
    }

    @Then("the banner should have appropriate ARIA labels")
    public void bannerShouldHaveAppropriateAriaLabels() {
        WebElement banner = driver.findElement(By.id("cookies-banner"));
        assertThat(banner.getAttribute("role")).isEqualTo("dialog");
        assertThat(banner.getAttribute("aria-label")).isNotEmpty();
    }
}