package br.com.automacao.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BlogAgiPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By btnLupaBusca = By.id("search-open");
    private By inputBusca = By.cssSelector(".desktop-search .search-field");
    private By titleResultados = By.cssSelector(".archive-title");
    private By mensagemNenhumResultado = By.cssSelector(".entry-content p");

    public BlogAgiPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirBlog() {
        driver.get("https://blogdoagi.com.br/");
    }

    public void pesquisar(String termo) {
        wait.until(ExpectedConditions.elementToBeClickable(btnLupaBusca)).click();
        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(inputBusca));
        campo.sendKeys(termo);
        campo.sendKeys(Keys.ENTER);
    }

    public String getTextoResultado() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleResultados)).getText();
    }

    public String getMensagemVazia() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemNenhumResultado)).getText();
    }
}