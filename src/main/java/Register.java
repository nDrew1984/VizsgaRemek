import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Base
    {
    public Register(WebDriver driver) {
        super(driver);
    }

    private final By popupAccept = By.id("terms-and-conditions-button");
    private final By popupX = By.xpath("//*[@id=\"overlay\"]/div/div[1]");
    private final By register = By.id("register-form-button");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By regUserName = By.id("register-username");
    private final By regPassword = By.id("register-password");
    private final By regEmail = By.id("register-email");
    private final By regDescription = By.id("register-description");

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
}
