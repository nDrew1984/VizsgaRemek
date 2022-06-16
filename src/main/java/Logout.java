import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout extends Base {

    public Logout(WebDriver driver) {
        super(driver);
    }

    private final By logoutButton = By.xpath("//*[@id=\"logout-link\"]/a");
    private final By homeButton = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[1]/a");

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }
}
