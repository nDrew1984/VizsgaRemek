import org.openqa.selenium.WebDriver;

public class Register extends Base {
    public Register(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(url);
    }
    public void clickAccept() {
        driver.findElement(popupAccept).click();
    }
    public void clickX() {
        driver.findElement(popupX).click();
    }
    public void clickRegister() {
        driver.findElement(register).click();
    }
    public void inputReg(String username, String password, String email, String description) {
        driver.findElement(regUserName).sendKeys(username);
        driver.findElement(regPassword).sendKeys(password);
        driver.findElement(regEmail).sendKeys(email);
        driver.findElement(regDescription).sendKeys(description);
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
