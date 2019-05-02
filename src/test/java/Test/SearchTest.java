package Test;

import Page.GooglePage;
import Page.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    WebDriver driver;
    SearchResultPage searchResultsPage;
    //GooglePage googlePage;
    String searchTerm = "Selenium";

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    //@AfterMethod
    //public void afterMethod() {
    //    driver.quit();
    //}

    @Test
    public void searchGoogleTest(){

        GooglePage googlePage = new GooglePage(driver);
        Assert.assertTrue(googlePage.isPageLoaded(),
                "Login page was not loaded.");

        googlePage.searchGoogle();




     Assert.assertEquals(searchResultsPage.getSearchResultCount(),10, "Result count is wrong");

        List<String> searchResults = searchResultsPage.getSearchResults();

        for (String searchResult : searchResults){
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "searchTerm: " + searchTerm+ " not found in: \n" + searchResult);
        }


    }


}
