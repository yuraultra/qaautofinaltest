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
    private WebDriver driver;
    protected SearchResultPage searchResultsPage;
    protected GooglePage googlePage;
    String searchTerm = "Selenium";

    @BeforeMethod
    public void beforeMethod() {
    driver = new ChromeDriver();
    driver.get("https://www.google.com");
    googlePage = new GooglePage(driver);
    searchResultsPage = new SearchResultPage(driver);
}

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void searchGoogleTest(){

       Assert.assertTrue(googlePage.isPageLoaded(),
                "Google page was not loaded.");

        googlePage.searchGoogle(searchTerm);

        Assert.assertTrue(googlePage.isResultSearchPageLoaded(),
                "Result Google search page was not loaded");


     Assert.assertEquals(searchResultsPage.getSearchResultCount(),9, "Result count is wrong");

        List<String> searchResults = searchResultsPage.getSearchResults();

        for (String searchResult : searchResults){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm: " + searchTerm + " not found in: \n" + searchResult);
        }

        googlePage.clickSearchGoogleTwoPage();

        Assert.assertTrue(googlePage.isResultSearchPageLoaded(),
                "Result Google search page 2 was not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultCount(),10, "Result count is wrong");

        List<String> searchResults2 = searchResultsPage.getSearchResults();

        for (String searchResult : searchResults2){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm: " + searchTerm + " not found in: \n" + searchResult);

        }
    }


}
