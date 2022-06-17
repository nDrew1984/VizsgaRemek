import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
    public Login(WebDriver driver) {
        super(driver);
    }

    public void inputLogin(String username, String password) {
        driver.findElement(userNameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
    }

}
