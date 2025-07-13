import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumDemo {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins--");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.bing.com");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName(value = "Проверка поисковой строки")
    public void search(){
        String input = "Selenium";
        By seashFieldCss;
        seashFieldCss = By.cssSelector("#sb_form_q");
        WebElement searchField = driver.findElement(seashFieldCss);
        searchField.sendKeys(input);
        searchField.submit();
        WebElement searchPageField = driver.findElement(seashFieldCss);
        assertEquals(input,searchPageField.getAttribute("value"), "Элемент не найден");
    }
}