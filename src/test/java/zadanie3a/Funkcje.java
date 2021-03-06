package zadanie3a;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.List;

public class Funkcje {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Bing
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void testFunkcje() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.id("first-name"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();
        // Wpisz imie
        element.sendKeys("Karol");
        System.out.println(element.getTagName() + " : " + element.getAttribute("value"));
        WebElement element1 = driver.findElement(By.id("last-name"));
        // Wyczyść teskst zapisany w elemencie
        element1.clear();
        // Wpisz nazwisko
        element1.sendKeys("Kowalski");
        System.out.println(element1.getTagName() + " : " + element1.getAttribute("value"));
      WebElement radio1 = driver.findElement(By.name("gender"));
//
//        //Zaznacza pierszy radio
       radio1.click();
//        List<WebElement> genders = driver.findElements(By.name("gender"));
//        genders.get(0).click();
        System.out.println(radio1.getTagName() + " : " + radio1.getAttribute("value"));
        WebElement element3 = driver.findElement(By.id("dob"));
        // Wyczyść teskst zapisany w elemencie
        element3.clear();
        // Wpisz date urodzenia
        element3.sendKeys("5/22/2010");
        System.out.println(element3.getTagName() + " : " + element3.getAttribute("value"));
        WebElement element4 = driver.findElement(By.id("address"));
        // Wyczyść teskst zapisany w elemencie
        element4.clear();
        // Wpisz adres
        element4.sendKeys("Prosta 51");
        System.out.println(element4.getTagName() + " : " + element4.getAttribute("value"));
        WebElement element5 = driver.findElement(By.id("email"));
        // Wyczyść teskst zapisany w elemencie
        element5.clear();
        // Wpisz adres
        element5.sendKeys("karol.kowalski@mailinator.com");
        System.out.println(element5.getTagName() + " : " + element5.getAttribute("value"));
        WebElement element6 = driver.findElement(By.id("password"));
        // Wyczyść teskst zapisany w elemencie
        element6.clear();
        // Wpisz haslo
        element6.sendKeys("Pass123");
        System.out.println(element6.getTagName() + " : " + element6.getAttribute("value"));
        WebElement element7 = driver.findElement(By.id("company"));
        // Wyczyść teskst zapisany w elemencie
        element7.clear();
        // Wpisz nazwe firmy
        element7.sendKeys("Coders Lab");
        System.out.println(element7.getTagName() + " : " + element7.getAttribute("value"));
        WebElement element8 = driver.findElement(By.id("comment"));
        // Wyczyść teskst zapisany w elemencie
        element8.clear();
        // Wpisz komentarz
        element8.sendKeys("To jest mój pierwszy automat testowy");
        System.out.println(element8.getTagName() + " : " + element8.getAttribute("value"));
        // Prześlij formularz
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}