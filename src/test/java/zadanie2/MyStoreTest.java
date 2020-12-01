package zadanie2;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.Random;

public class MyStoreTest {

    private WebDriver driver;

    private String getRandomProduct() {
        String[] products = {"mug", "t-shirt", "notebook", "sweter", "poster", "cushion", "vector", "graphics", "pack"};
        Random random = new Random();
        //Losuj liczby od 0-49
        int randomInteger = random.nextInt(products.length);
        return products[randomInteger];


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
        driver.get("https://prod-kurs.coderslab.pl");
    }

    @Test
    public void testGoogleSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("s"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();
        //Wpisz informacje do wyszukania
        element.sendKeys(getRandomProduct());
        //Prześlij formularz
        element.submit();
    }


    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}

