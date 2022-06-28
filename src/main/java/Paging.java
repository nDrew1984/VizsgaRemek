import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Paging extends Base {
    public Paging(WebDriver driver) {
        super(driver);
    }

    private final By portfolio = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[3]/a");
    private final By nextPage = By.xpath("//*[@class=\"pagination\"]/li[5]");
    private final By visibleItems = By.xpath("//*[@class=\"col-lg-6 col-md-10 mx-auto\"]");

    public void clickPortfolio() {
        driver.findElement(portfolio).click();
    }
    public int numberOfItems() {
        int t = 0;
        List<WebElement> items = driver.findElements(visibleItems);
        t = items.size();
        return t;
    }
    public boolean lastPage() {
        String attribute = driver.findElement(nextPage).getAttribute("class");
        return attribute.equals("page-item disabled");
    }
    public void clickNextPage() {
        if (lastPage() == false) {
            driver.findElement(nextPage).click();
        }
    }
}
