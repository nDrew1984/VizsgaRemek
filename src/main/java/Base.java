import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {
    WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    // Webelemek:
    protected final String url = "https://lennertamas.github.io/roxo/";
    protected final By popupAccept = By.id("terms-and-conditions-button");
    protected final By popupX = By.xpath("//*[@id=\"overlay\"]/div/div[1]");
    protected final By register = By.id("register-form-button");
    protected final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    protected final By regUserName = By.id("register-username");
    protected final By regPassword = By.id("register-password");
    protected final By regEmail = By.id("register-email");
    protected final By regDescription = By.id("register-description");
    protected final By userNameInput = By.id("email");
    protected final By passwordInput = By.id("password");
    protected final By about = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[2]/a");
    protected final By portfolio = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[3]/a");
    protected final By getInTouch = By.xpath("//*[@class=\"navbar-nav ml-auto main-nav\"]/li[5]");


    // tesztadatok a regisztrációhoz és a belépéshez:
    protected final String userName = "nDrew";
    protected final String password = "12345";
    protected final String email = "boq93p@gmail.com";
    protected final String description = "vizsgaremek";
}
