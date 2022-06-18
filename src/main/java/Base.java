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
    protected final By sendMessage = By.id("contact-form-button");

    protected final By login = By.xpath("(//*[@id=\"login-form-button\"])[2]");
    protected final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");

    public void navigate() {
        driver.get(url);
    }
    public void clickAccept() {
        driver.findElement(popupAccept).click();
    }
    public void clickX() {
        driver.findElement(popupX).click();
    }
    public void inputReg(String username, String password, String email, String description) {
        driver.findElement(regUserName).sendKeys(username);
        driver.findElement(regPassword).sendKeys(password);
        driver.findElement(regEmail).sendKeys(email);
        driver.findElement(regDescription).sendKeys(description);
    }
    public void clickRegister() {
        driver.findElement(register).click();
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickLogin() {
        driver.findElement(login).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void clickGetInTouch() {
        driver.findElement(getInTouch).click();
    }
    public void clickSendMessage() {
        driver.findElement(sendMessage).click();
    }
    public void clickAlertOK() {
        driver.switchTo().alert().accept();
    }
}
