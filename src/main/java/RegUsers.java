import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegUsers extends Base {
    public RegUsers(WebDriver driver) {
        super(driver);
    }

    public void regUsers(String file) throws IOException, InterruptedException {
        long numberOfLines = Files.lines(Paths.get(file)).count();
        for (int i = 0; i < numberOfLines; i++) {
            String line = Files.readAllLines(Paths.get(file)).get(i);
            String[] userData = line.split(", ");
            String userName = userData[0];
            String password = userData[1];
            String email = userData[2];
            String description = userData[3];

            driver.findElement(regUserName).sendKeys(userName);
            driver.findElement(regPassword).sendKeys(password);
            driver.findElement(regEmail).sendKeys(email);
            driver.findElement(regDescription).sendKeys(description);

            clickRegisterButton();

            if (i < numberOfLines - 1) {
            Thread.sleep(1000);
            driver.navigate().refresh();
            clickRegister();
            }
        }
    }
}
