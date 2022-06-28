import org.openqa.selenium.WebDriver;

public class Base {
    WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    // Webelemek:
    protected final String url = "https://lennertamas.github.io/roxo/";
    public void navigate() {
        driver.get(url);
    }
}
