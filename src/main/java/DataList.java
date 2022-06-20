import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataList extends Base {
    public DataList(WebDriver driver) {
        super(driver);
    }

    private final By nameCards = By.xpath("//*[@class=\"site-team-member-content\"]");
    private final By names = By.xpath("./h3");
    private final By titles = By.xpath("./p");

    public List<Map<String, String>> getData() {
        List<Map<String, String>> list = new ArrayList<>();

        List<WebElement> nameCardList = driver.findElements(nameCards);
        for (int i = 0; i < nameCardList.size(); i++) {
            Map<String, String> listItem = new HashMap<>();

            String name = nameCardList.get(i).findElement(names).getText();
            String title = nameCardList.get(i).findElement(titles).getText();

            listItem.put("Name", name);
            listItem.put("Title", title);
            list.add(listItem);
        }
        return list;
    }
}
