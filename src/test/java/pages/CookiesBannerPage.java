package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesBannerPage extends PageObject {

    @FindBy(id="nhsuk-cookie-banner")
    private WebElementFacade cookiesBanner;

    @FindBy(id = "nhsuk-cookie-banner__link_accept_analytics")
    private WebElementFacade acceptAllCookiesButton;

    @FindBy(id = "nhsuk-cookie-banner__link_accept")
    private WebElementFacade rejectAllCookiesButton;

    @FindBy(id = "nhsuk-cookie-confirmation-banner")
    private WebElementFacade confirmationMessage;

    public boolean isBannerVisible() {
        try {
            return cookiesBanner.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getBanner() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nhsuk-cookie-banner")));
    }

    public boolean hasButton(String buttonText) {
        WebElement banner = getBanner();
        return banner.getText().contains(buttonText);
    }

    public void clickAcceptAllCookies() {
        acceptAllCookiesButton.click();
    }

    public void clickRejectAllCookies() {
        rejectAllCookiesButton.click();
    }

    public boolean isConfirmationMessageVisible() {
        try {
            return confirmationMessage.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areCookieButtonsHidden() {
        return !acceptAllCookiesButton.isVisible() && !rejectAllCookiesButton.isVisible();
    }


    public boolean hasCookieMessageText() {
        return confirmationMessage.getText().contains("You can change your cookie settings");
    }




    public boolean isPreferenceSaved() {
        Cookie analyticsCookie = getDriver().manage().getCookieNamed("analytics_consent");
        return analyticsCookie != null && analyticsCookie.getValue().equalsIgnoreCase("true");
    }

    public boolean isPreferenceRejected() {
        Cookie analyticsCookie = getDriver().manage().getCookieNamed("analytics_consent");
        return analyticsCookie != null && analyticsCookie.getValue().equalsIgnoreCase("false");
    }

    public boolean isAccessibleByKeyboard() {
        acceptAllCookiesButton.sendKeys(Keys.TAB);
        return acceptAllCookiesButton.equals(getDriver().switchTo().activeElement());
    }

    public boolean hasAppropriateAriaLabels() {
        String acceptAria = acceptAllCookiesButton.getAttribute("aria-label");
        String rejectAria = rejectAllCookiesButton.getAttribute("aria-label");

        return acceptAria != null && !acceptAria.isEmpty()
                && rejectAria != null && !rejectAria.isEmpty();
    }
}
