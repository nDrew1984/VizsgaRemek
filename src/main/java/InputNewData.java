import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InputNewData extends Base {
    public InputNewData(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.xpath("(//*[@class=\"form-control\"])[1]");
    private final By lastName = By.xpath("(//*[@class=\"form-control\"])[2]");
    private final By email = By.xpath("(//*[@class=\"form-control\"])[3]");
    private final By projectType = By.xpath("(//*[@class=\"form-control\"])[4]");
    private final By aboutTheProject = By.xpath("(//*[@class=\"form-control\"])[5]");

    public void inputData(String d1, String d2, String d3, int i, String text) {
        driver.findElement(firstName).sendKeys(d1);
        driver.findElement(lastName).sendKeys(d2);
        driver.findElement(email).sendKeys(d3);

        Select select = new Select(driver.findElement(projectType));
        select.selectByIndex(i);

        driver.findElement(aboutTheProject).sendKeys(text);
    }
}
