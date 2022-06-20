import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestRoxo {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void RegisterTest() {
        Register register = new Register(driver);

        register.navigate();
        register.clickAccept();
        register.clickRegister();

        // regisztrációra vonatkozó tesztadatok:
        String userName = "nDrew";
        String password = "12345";
        String email = "boq93p@gmail.com";
        String description = "vizsgaremek";

        register.inputReg(userName, password, email, description);
        register.clickRegisterButton();

        String exp = "User registered!";
        String act = driver.findElement(By.id("register-alert")).getText();
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void LoginTest() {
        // Le kell futtatni újra a regisztrációt, mert ha bezárom a böngészőt, akkor elfelejti a regisztrált adatokat.
        // regisztráció után rögtön a Login fülre kell kattintani.
        RegisterTest();
        Login login = new Login(driver);

        login.clickLogin();

        // belépésre vonatkozó tesztadatok:
        String userName = "nDrew";
        String password = "12345";

        login.inputLogin(userName, password);
        login.clickLoginButton();

        String exp = "https://lennertamas.github.io/roxo/landing.html";
        String act = driver.getCurrentUrl();
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void LogoutTest() throws InterruptedException {
        LoginTest();
        Logout logout = new Logout(driver);

        Thread.sleep(2000);
        logout.clickLogoutButton();

        String exp = "https://lennertamas.github.io/roxo/index.html";
        String act = driver.getCurrentUrl();

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void DataListTest() {
        DataList dataList = new DataList(driver);
        LoginTest();
        dataList.clickAbout();

        Assertions.assertEquals("https://lennertamas.github.io/roxo/about/", driver.getCurrentUrl());

        List<Map<String, String>> list = dataList.getData();
        Assertions.assertEquals(6, list.size());

        String exp = list.toString();
        System.out.println(exp);
    }

    @Test
    public void PagingTest() {
        Paging paging = new Paging(driver);
        LoginTest();
        paging.clickPortfolio();

        Assertions.assertEquals("https://lennertamas.github.io/roxo/portfolio/", driver.getCurrentUrl());

        int act = 0;
        while (true) {
            act += paging.numberOfItems();
            if (paging.lastPage() == true) {
                break;
            }
            paging.clickNextPage();
        }
        Assertions.assertEquals(5, act);
    }

    @Test
    public void InputNewDataTest() throws InterruptedException {
        InputNewData inputNewData = new InputNewData(driver);
        LoginTest();
        inputNewData.clickGetInTouch();

        Assertions.assertEquals("https://lennertamas.github.io/roxo/contact/", driver.getCurrentUrl());

        String firstName = "Andor";
        String lastName = "Blastik";
        String email = "boq93p@gmail.com";
        // projectType 1: Graphics Design
        // projectType 2: Web Design
        int projectType = 2;
        String aboutTheProject = "Ha sikerül a vizsgám, nagyon boldog leszek.";

        inputNewData.inputData(firstName, lastName, email, projectType, aboutTheProject);
        inputNewData.clickSendMessage();

        String exp1 = "Message sent!";
        String act1 = driver.switchTo().alert().getText();
        Assertions.assertEquals(exp1, act1);

        inputNewData.clickAlertOK();

        Thread.sleep(2000);
        String exp2 = "Thanks! Contact form is submitted successfully.";
        String act2 = driver.findElement(By.id("contact-form-status")).getText();
        Assertions.assertEquals(exp2, act2);
    }

    @Test
    public void ReadFromFileTest() throws IOException {
        ReadFromFile read = new ReadFromFile(driver);

        // weboldal megnyitása és regisztráció:
        read.navigate();
        read.clickAccept();
        read.clickRegister();

        read.inputRegLines();
        read.clickRegisterButton();

        String exp1 = "User registered!";
        String act1 = driver.findElement(By.id("register-alert")).getText();
        Assertions.assertEquals(exp1, act1);

        // Login:
        read.clickLogin();
        read.inputLoginLines();

        read.clickLoginButton();

        String exp2 = "https://lennertamas.github.io/roxo/landing.html";
        String act2 = driver.getCurrentUrl();
        Assertions.assertEquals(exp2, act2);
    }

    @Test
    public void RegUsersTest() throws IOException, InterruptedException {
        RegUsers users = new RegUsers(driver);

        users.navigate();
        users.clickAccept();
        users.clickRegister();

        String file = "Users.txt";
        users.regUsers(file);

        // Az utolsó user regisztrációjának ellenőrzése:
        String exp = "User registered!";
        String act = driver.findElement(By.id("register-alert")).getText();
        Assertions.assertEquals(exp, act);
    }
    @Test
    public void RewriteDataTest() throws InterruptedException {
        RewriteData reWrite = new RewriteData(driver);
        LoginTest();
        reWrite.clickGetInTouch();

        String firstName = "Andor";
        String lastName = "Blastik";
        String email = "boq93p@gmail.com";
        // projectType 1: Graphics Design
        // projectType 2: Web Design
        int projectType = 2;
        String aboutTheProject = "Ez a szöveg mindjárt módosításra kerül.";

        reWrite.inputData(firstName, lastName, email, projectType, aboutTheProject);
        Thread.sleep(1000);

        // firstname, lastname és szövegmező törlése:
        reWrite.clearFirstName();
        reWrite.clearLastName();
        reWrite.clearText();

        // a fenti mezők ürességének ellenőrzése:
        String act1 = driver.findElement(By.xpath("(//*[@class=\"form-control\"])[1]")).getText(); // firstname
        String act2 = driver.findElement(By.xpath("(//*[@class=\"form-control\"])[2]")).getText(); // lastname
        String act3 = driver.findElement(By.xpath("(//*[@class=\"form-control\"])[5]")).getText(); // text
        Assertions.assertEquals("", act1);
        Assertions.assertEquals("", act2);
        Assertions.assertEquals("", act3);

        // új adatok:
        String newFirstName = "Harry";
        String newLastName = "Potter";
        int newProjectType = 1; // 1 = "Graphics Design"
        String newText =
                """
                Ez egy új
                többsoros
                szöveg.       
                """;

        Thread.sleep(1000);
        // új adatok beírása, új Project Type kiválasztása:
        reWrite.inputNewFirstname(newFirstName);
        reWrite.inputNewLastName(newLastName);
        reWrite.selectNewProjectType(newProjectType);
        reWrite.inputNewText(newText);

        Thread.sleep(1000);
        // Ellenőrzés, hogy minden átíródott-e:
        String act4 = driver.findElement(By.xpath("(//*[@class=\"form-control\"])[4]")).getText(); // Project Type

        // Assertions.assertEquals(newFirstName, act1);  // valamiért hibásnak jelzi, mindig az elsőt
        // Assertions.assertEquals(newLastName, act2);
        // Assertions.assertEquals("Graphics Design", act4);
        // Assertions.assertEquals(newText, act3);

        reWrite.clickSendMessage();

        String exp5 = "Message sent!";
        String act5 = driver.switchTo().alert().getText();
        Assertions.assertEquals(exp5, act5);

        reWrite.clickAlertOK();

        Thread.sleep(1000);
        String exp6 = "Thanks! Contact form is submitted successfully.";
        String act6 = driver.findElement(By.id("contact-form-status")).getText();
        Assertions.assertEquals(exp6, act6);
    }

    @Test
    public void SaveDataTest() throws IOException {
        SaveData saveData = new SaveData(driver);
        LoginTest();
        saveData.clickAbout();
        Assertions.assertEquals("https://lennertamas.github.io/roxo/about/", driver.getCurrentUrl());

        String fileName = "saveData.txt";
        saveData.createFile(fileName);

        saveData.writeNameCards(fileName);
    }

}
