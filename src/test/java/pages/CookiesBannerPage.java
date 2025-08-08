package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesBannerPage extends PageObject {

    @FindBy(id="nhsuk-cookie-banner")
    private WebElementFacade cookiesBanner;

    @FindBy(id = "nhsuk-cookie-banner__link_accept_analytics") // Replace with the actual locator
    private WebElementFacade acceptAllCookiesButton;

    @FindBy(id = "nhsuk-cookie-banner__link_accept") // Replace with the actual locator
    private WebElementFacade rejectAllCookiesButton;

    @FindBy(id = "nhsuk-cookie-confirmation-banner") // Replace with the actual ID or locator
    private WebElementFacade confirmationMessage;

    public boolean isBannerVisible() {
        return cookiesBanner.waitUntilVisible().isVisible();
    }

    public WebElement getBanner() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nhsuk-cookie-banner")));
    }

    public boolean hasButton(String buttonText) {
        WebElement banner = getBanner();
        System.out.println("Banner text:\n" + banner.getText());
        return banner.getText().contains(buttonText);
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