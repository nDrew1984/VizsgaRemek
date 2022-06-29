import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
    public Login(WebDriver driver) {
        super(driver);
    }

    private final By popupAccept = By.id("terms-and-conditions-button");
    private final By register = By.id("register-form-button");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By regUserName = By.id("register-username");
    private final By regPassword = By.id("register-password");
    private final By regEmail = By.id("register-email");
    private final By regDescription = By.id("register-description");
    private final By login = By.xpath("(//*[@id=\"login-form-button\"])[2]");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
    private final By userNameInput = By.id("email");
    private final By passwordInput = By.id("password");

    public void clickAccept() {
        driver.findElement(popupAccept).click();
    }
    public void clickRegister() {
        driver.findElement(register).click();
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void inputReg(String username, String password, String email, String description) {
        driver.findElement(regUserName).sendKeys(username);
        driver.findElement(regPassword).sendKeys(password);
        driver.findElement(regEmail).sendKeys(email);
        driver.findElement(regDescription).sendKeys(description);
    }
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
