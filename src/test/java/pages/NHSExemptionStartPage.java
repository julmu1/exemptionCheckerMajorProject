package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class NHSExemptionStartPage extends PageObject {


    @FindBy(css = "footer a") // This will select all links in the footer
    private List<WebElementFacade> allLinks;

    public void clickLinkByText(String linkText) {
        WebElementFacade link = allLinks.stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(linkText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Link not found: " + linkText));
        link.click();
    }

    public String getCurrentPageTitle() {
        return getTitle(); // Or use getDriver().getTitle() if needed
    }

    public String getPageContent() {
        return getDriver().getPageSource();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public boolean footerContainsLinkText(String linkText) {
        return findAll(".nhsuk-footer a").stream()
                .anyMatch(el -> el.getText().equalsIgnoreCase(linkText));
    }

}
