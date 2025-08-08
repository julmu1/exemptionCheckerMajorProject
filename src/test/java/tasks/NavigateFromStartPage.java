package tasks;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class NavigateFromStartPage {

    PageObject page;

    public NavigateFromStartPage(PageObject page) {
        this.page = page;
    }

    public void clickLink(String linkText) {
        WebDriver driver = page.getDriver();

        WebElement link = driver.findElements(By.cssSelector("footer a")).stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(linkText))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Link not found: " + linkText));

        String originalUrl = driver.getCurrentUrl();
        String originalWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();

        link.click();

        for (int i = 0; i < 20; i++) {
            Set<String> newWindows = driver.getWindowHandles();
            newWindows.removeAll(oldWindows);

            // Case 1: New tab opened
            if (!newWindows.isEmpty()) {
                driver.switchTo().window(newWindows.iterator().next());
                return;
            }

            // Case 2: Same tab navigation
            if (!driver.getCurrentUrl().equals(originalUrl)) {
                return;
            }

            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }

        throw new AssertionError("Navigation did not occur after clicking: " + linkText);
    }



}
