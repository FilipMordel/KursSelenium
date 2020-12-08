package dodatkowe2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class MyStore {
    private WebDriver driver;

    public String getRandomAlias(){
        String[] alias = {"Stefan", "Maniek", "Zdzichu", "Romek", "Tomek"};
        Random random = new Random();
        int randomInteger = random.nextInt(alias.length);
        String a = alias[randomInteger];
        return a;
    }

    public String getRandomCompany() {
        String[] company = {"Mak", "Xyz", "Www", "Abc", "GHJ"};
        Random random = new Random();
        int randomInteger1 = random.nextInt(company.length);
        String b = company[randomInteger1];
        return b;
    }

    public String getRandomCity() {
        String[] city = {"Wrcoław", "Radom", "Poznań", "Gdańsk", "Kalisz"};
        Random random = new Random();
        int randomInteger = random.nextInt(city.length);
        String c = city[randomInteger];
        return c;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do PrestaShop
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }
    @Test
    public void setAlias() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement alias = driver.findElement(By.name("alias"));
        alias.sendKeys(getRandomAlias());
    }
    public void setCompany() {
        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys(getRandomCompany());
    }
    public void setCity() {
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys(getRandomCity());
    }


    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}

