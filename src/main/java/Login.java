import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
    public Login(WebDriver driver) {
        super(driver);
    }

    private final By login = By.xpath("(//*[@id=\"login-form-button\"])[2]");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");

    public void clickLogin() {
        driver.findElement(login).click();
    }
    public void inputLogin(String username, String password) {
        driver.findElement(userNameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
