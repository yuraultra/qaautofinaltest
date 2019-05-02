package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class GooglePage {
    WebDriver driver;
    String searchTerm = "Selenium";

    @FindBy(xpath="//input[@name='q'")
    WebElement searchFieldGoogle;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void searchGoogle(){
        searchFieldGoogle.sendKeys(searchTerm);
        searchFieldGoogle.submit();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public boolean isPageLoaded(){
            return driver.getTitle().contains("Google");
        }

        public boolean isResultSearchPageLoaded() {
        return driver.getCurrentUrl().contains("/search");
    }





}
