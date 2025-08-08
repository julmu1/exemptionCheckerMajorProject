package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class CookiesBannerPage extends PageObject {

    @FindBy(id = "nhsuk-cookies-banner") // Replace with the actual ID or locator of the banner
    private WebElement cookiesBanner;

    @FindBy(id = "nhsuk-cookie-banner__link_accept_analytics") // Replace with the actual locator
    private WebElement acceptAllCookiesButton;

    @FindBy(id = "nhsuk-cookie-banner__link_accept") // Replace with the actual locator
    private WebElement rejectAllCookiesButton;

    @FindBy(id = "nhsuk-cookie-confirmation-banner") // Replace with the actual ID or locator
    private WebElement confirmationMessage;

    public boolean isBannerVisible() {
        return cookiesBanner.isDisplayed();
    }

    public boolean hasButton(String buttonText) {
        if (buttonText.equals("I'm OK with analytics cookies")) {
            return acceptAllCookiesButton.isDisplayed();
        } else if (buttonText.equals("Do not use analytics cookies")) {
            return rejectAllCookiesButton.isDisplayed();
        }
        return false;
    }

    public void clickAcceptAllCookies() {
        acceptAllCookiesButton.click();
    }

    public void clickRejectAllCookies() {
        rejectAllCookiesButton.click();
    }

    public boolean isConfirmationMessageVisible() {
        return confirmationMessage.isDisplayed();
    }

    public boolean isPreferenceSaved() {
        // Implement logic to verify if the preference is saved, e.g., checking cookies or local storage
        return true; // Placeholder
    }

    public boolean isAccessibleByKeyboard() {
        // Implement logic to verify keyboard accessibility
        return true; // Placeholder
    }

    public boolean hasAppropriateAriaLabels() {
        // Implement logic to verify ARIA labels
        return true; // Placeholder
    }
}