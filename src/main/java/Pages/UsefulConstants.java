package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import static Locators.Useful_Constants_Locators.*;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsefulConstants {

    public static WebDriver Xerxes;

    public static void start() {
        if (Xerxes == null) {
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\f207481\\Documents\\Rafael\\AutomacaoSIGAA\\src\\Drive\\Drive Chrome TJ\\chromedriver.exe");

            WebDriverManager.chromedriver().setup();

            // Configuração para ignorar erros de certificado SSL
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);

            // Configurações para salvar PDF automaticamente
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("printing.print_preview_sticky_settings.appState", "{\"recentDestinations\":[{\"id\":\"Save as PDF\",\"origin\":\"local\",\"account\":\"\"}],\"selectedDestinationId\":\"Save as PDF\",\"version\":2}");
            prefs.put("savefile.default_directory", "Downloads"); // Defina o diretório desejado
            options.setExperimentalOption("prefs", prefs);

            // Impedir a exibição da janela de impressão
            options.addArguments("--kiosk-printing");

            // Inicializa o WebDriver com as configurações
            Xerxes = new ChromeDriver(options);
            Xerxes.manage().window().maximize();
            Xerxes.get("https://sigaa.uern.br/sigaa/verTelaLogin.do");
        }
    }

    public static void close() {
        if (Xerxes != null) {
            Xerxes.quit();
            Xerxes = null;
        }
    }

    public static void VerificoUrl(String url){
        String URLCurrent = Xerxes.getCurrentUrl();
        if(URLCurrent.contains(url)){
            System.out.println("Navegamos até a página mencionada!");
            System.out.println("URL capturada: " + URLCurrent);
            System.out.println("URL passada: " + url);
        }
    }

    public static WebElement EsperoEstarVisivel(By Elemento) {
        WebDriverWait wait = new WebDriverWait(Xerxes, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Elemento));
    }

    public static void ClicoNoElemento(By Elemento) {
        EsperoEstarVisivel(Elemento).click();
    }

    public static void ClicarBotaoSair() {
        ClicoNoElemento(BOTAO_SAIR);
    }

    public static void Envio_O_Dado(By CampoDoDado, String Dado) {
        Xerxes.findElement(CampoDoDado).sendKeys(Dado);
    }

    public void verificarEExcluirArquivo(String nomeArquivoEsperado) {
        // Diretório padrão de downloads (ajuste conforme necessário)
        String diretorioDownloads = System.getProperty("user.home") + "/Downloads";

        // Cria a referência ao arquivo
        File arquivo = new File(diretorioDownloads + "/" + nomeArquivoEsperado);

        // Verifica se o arquivo existe
        if (arquivo.exists()) {
            System.out.println("Arquivo encontrado: " + arquivo.getAbsolutePath());

            // Exclui o arquivo
            if (arquivo.delete()) {
                System.out.println("Arquivo excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir o arquivo.");
            }
        } else {
            System.out.println("Arquivo não encontrado no diretório de downloads.");
        }
    }

    public static String CapturoAlerta(By triggerLocator, boolean accept) {

        Xerxes.findElement(triggerLocator).click();

        try {
            WebDriverWait wait = new WebDriverWait(Xerxes, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = Xerxes.switchTo().alert();
            String alertText = alert.getText();

            if (accept) {
                alert.accept();
            } else {
                alert.dismiss();
            }

            return alertText;

        } catch (Exception e) {
            return null;
        }
    }

//    public void VerificaTitulo(String title, By locator) {
//        waitForVisibility(locator);
//        assertEquals(Xerxes.findElement(locator).getText(), title);
//    }

//    public void verificaTituloPJ(String title) {
//        esperarElementoEstarPresente(TITULO_PAGINA_CERTIDAO, Duration.ofSeconds(30));
//        assertEquals(driver.findElement(TITULO_PAGINA_CERTIDAO).getText(), title);
//    }
//    public void Vrf_Label(String label) throws InterruptedException {
//        esperarElementoEstarPresente(TITULO_PAGINA_CERTIDAO_SOLICITADA, Duration.ofSeconds(30));
//        WebElement elementoCNPJ = driver.findElement(TITULO_PAGINA_CERTIDAO_SOLICITADA);
//        String valorDaPagina = elementoCNPJ.getAttribute("value");
//        Thread.sleep(50);
//        System.out.println("Valor página: " + valorDaPagina);
//        System.out.println("Valor variável: " + label);
//        assertEquals(label, valorDaPagina);
//    }

}