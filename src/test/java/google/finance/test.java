package google.finance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Iterables.contains;

public class test {

    WebDriver driver;

    String url = "https://www.google.com/finance";

    List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA", "AMZN");
    List<String> stockSymbolsFromUI = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\free_\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        driver.get(url);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Google Finance - Stock Market Prices, Real-time Quotes & Business News", "Page title is not as expected");
    }
    @Test(priority = 2)
    public void retrieveStockSymbols() {
        List<WebElement> stockSymbolElements = driver.findElements(By.xpath("//section[@aria-labelledby='smart-watchlist-title']/ul/li//div[@class='COaKTb']"));

        for (WebElement stockSymbolElement : stockSymbolElements) {
            String symbol = stockSymbolElement.getText().trim();
            stockSymbolsFromUI.add(symbol);
        }
        System.out.println("Stock symbols from UI: " + stockSymbolsFromUI);
        System.out.println("Stock symbols expected: " + expectedStockSymbols);

    }

    @Test(priority = 3)
    public void notInExpected() {
        System.out.println("\nStocks from UI but not in expected list ");
        for(String stockSymbol : stockSymbolsFromUI){
            if(!contains(expectedStockSymbols, stockSymbol)){
                System.out.print(stockSymbol + " ");
            }
        }
    }

    @Test(priority = 4)
    public void inExpected() {
        System.out.println("\nStocks in expected list but not in UI ");
        for(String expectedStockSymbol : expectedStockSymbols){
            if(!contains(stockSymbolsFromUI, expectedStockSymbol)){
                System.out.print(expectedStockSymbol + " ");
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
