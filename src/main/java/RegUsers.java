import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegUsers extends Base {
    public RegUsers(WebDriver driver) {
        super(driver);
    }

    private final By popupAccept = By.id("terms-and-conditions-button");
    private final By regUserName = By.id("register-username");
    private final By regPassword = By.id("register-password");
    private final By regEmail = By.id("register-email");
    private final By regDescription = By.id("register-description");
    private final By register = By.id("register-form-button");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");

    public void clickAccept() {
        driver.findElement(popupAccept).click();
    }
    public void clickRegister() {
        driver.findElement(register).click();
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void regUsers(String file) throws IOException, InterruptedException {
        long numberOfLines = Files.lines(Paths.get(file)).count();
        for (int i = 0; i < numberOfLines; i++) {
            String line = Files.readAllLines(Paths.get(file)).get(i);
            String[] userData = line.split(", ");

            driver.findElement(regUserName).sendKeys(userData[0]);
            driver.findElement(regPassword).sendKeys(userData[1]);
            driver.findElement(regEmail).sendKeys(userData[2]);
            driver.findElement(regDescription).sendKeys(userData[3]);

            clickRegisterButton();

            if (i < numberOfLines - 1) {
            Thread.sleep(1000);
            driver.navigate().refresh();
            clickRegister();
            }
        }
    }
}
