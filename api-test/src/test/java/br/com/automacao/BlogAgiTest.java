import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlogAgiTest {
    private WebDriver driver;
    private BlogAgiPage blogPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        blogPage = new BlogAgiPage(driver);
    }

    @Test
    @DisplayName("Deve buscar artigos sobre empréstimo com sucesso")
    public void deveBuscarComSucesso() {
        blogPage.abrirBlog();
        blogPage.pesquisar("Empréstimo");
        
        String resultado = blogPage.getTextoResultado();
        assertTrue(resultado.contains("Resultados da busca por: Empréstimo"), 
            "O título da busca deveria conter o termo pesquisado.");
    }

    @Test
    @DisplayName("Deve exibir mensagem adequada para busca sem resultados")
    public void deveExibirMensagemBuscaVazia() {
        blogPage.abrirBlog();
        blogPage.pesquisar("termoinexistente123");
        
        String mensagem = blogPage.getMensagemVazia();
        assertTrue(mensagem.contains("Lamentamos, mas nada corresponde aos seus termos de busca"), 
            "A mensagem de erro de busca deveria ser exibida.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}