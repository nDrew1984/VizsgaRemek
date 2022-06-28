import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveData extends Base {
    public SaveData(WebDriver driver) {
        super(driver);
    }

    private final By about = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[2]/a");
    private final By nameCards = By.xpath("//*[@class=\"site-team-member-content\"]");
    private final By names = By.xpath("./h3");
    private final By titles = By.xpath("./p");

    public void createFile(String s) throws IOException {
        File file = new File(s);
        file.createNewFile();
    }
    public void clickAbout() {
        driver.findElement(about).click();
    }
    public void writeNameCards(String s) throws IOException {
        List<WebElement> nameCardsList = driver.findElements(nameCards);
        FileWriter writer = new FileWriter(s);
        writer.write("Serial" + "\t" + "Name" + "\t" + "Title" + "\r\n");

        for (int i = 0; i < nameCardsList.size(); i++) {
            String name = nameCardsList.get(i).findElement(names).getText();
            String title = nameCardsList.get(i).findElement(titles).getText();
            String serial = String.valueOf(i+1);
            writer.write(serial + "\t" + name + "\t" + title + "\r\n");
        }
        writer.close();
    }
}
