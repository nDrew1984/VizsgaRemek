import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RewriteData extends Base {
    public RewriteData(WebDriver driver) {
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
    public void clearFirstName() {
        driver.findElement(firstName).clear();
    }
    public void clearLastName() {
        driver.findElement(lastName).clear();
    }
    public void clearEmail() {
        driver.findElement(email).clear();
    }
    public void clearText() {
        driver.findElement(aboutTheProject).clear();
    }
    public void inputNewFirstname(String s) {
        driver.findElement(firstName).sendKeys(s);
    }
    public void inputNewLastName(String t) {
        driver.findElement(lastName).sendKeys(t);
    }
    public void inputNewEmail(String u) {
        driver.findElement(email).sendKeys(u);
    }
    public void selectNewProjectType(int k) {
        Select select = new Select(driver.findElement(projectType));
        select.selectByIndex(k);
    }
    public void inputNewText(String v) {
        driver.findElement(aboutTheProject).sendKeys(v);
    }

}
