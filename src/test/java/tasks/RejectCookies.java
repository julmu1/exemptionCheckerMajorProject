package tasks;

import net.serenitybdd.core.steps.UIInteractionSteps;
import pages.CookiesBannerPage;

public class RejectCookies extends UIInteractionSteps {
    CookiesBannerPage cookiesBannerPage;

    public void perform() {
        cookiesBannerPage.clickRejectAllCookies();
    }
}