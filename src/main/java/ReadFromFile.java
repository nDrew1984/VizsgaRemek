import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile extends Base {
    public ReadFromFile(WebDriver driver) {
        super(driver);
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
}
