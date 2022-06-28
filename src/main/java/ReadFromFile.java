import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile extends Base {
    public ReadFromFile(WebDriver driver) {
        super(driver);
    }

    private final By regUserName = By.id("register-username");
    private final By regPassword = By.id("register-password");
    private final By regEmail = By.id("register-email");
    private final By regDescription = By.id("register-description");
    private final By popupAccept = By.id("terms-and-conditions-button");
    private final By popupX = By.xpath("//*[@id=\"overlay\"]/div/div[1]");
    private final By register = By.id("register-form-button");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By userNameInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By login = By.xpath("(//*[@id=\"login-form-button\"])[2]");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickAccept() {
        driver.findElement(popupAccept).click();
    }
    public void clickRegister() {
        driver.findElement(register).click();
    }

    public String readRegData(int n) throws IOException {
        return Files.readAllLines(Paths.get("registerData.txt")).get(n);
    }
    public void inputRegLines() throws IOException {
        driver.findElement(regUserName).sendKeys(readRegData(0));
        driver.findElement(regPassword).sendKeys(readRegData(1));
        driver.findElement(regEmail).sendKeys(readRegData(2));
        driver.findElement(regDescription).sendKeys(readRegData(3));
    }
    public String readLoginData(int n) throws IOException {
        return Files.readAllLines(Paths.get("loginData.txt")).get(n);
    }
    public void inputLoginLines() throws IOException {
        driver.findElement(userNameInput).sendKeys(readLoginData(0));
        driver.findElement(passwordInput).sendKeys(readLoginData(1));
    }
    public void clickLogin() {
        driver.findElement(login).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
