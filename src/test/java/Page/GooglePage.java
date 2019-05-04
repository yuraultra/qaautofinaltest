package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class GooglePage {
    private WebDriver driver;

    @FindBy(xpath="//input[@name='q']")
    WebElement searchFieldGoogle;

    @FindBy(xpath="//a[@aria-label='Page 2']")
    private WebElement searchPageTwoResult;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchGoogle(String searchTerm){
        searchFieldGoogle.sendKeys(searchTerm);
        searchFieldGoogle.submit();
        try {
            sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSearchGoogleTwoPage(){
        searchPageTwoResult.click();
        try {
            sleep(1200);
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
