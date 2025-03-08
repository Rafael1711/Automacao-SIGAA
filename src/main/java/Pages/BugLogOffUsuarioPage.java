package Pages;

import org.openqa.selenium.Keys;

import static Locators.Bug_Log_Off_Usuario_Locators.*;

public class BugLogOffUsuarioPage extends UsefulConstants {
    LoginPage LoginPageObject =  new LoginPage();

    public void UserLogOff() {
        LoginPageObject.fazerLogin();
        ClicoNoElemento(TURMAS_ANTERIORES);
        ClicoNoElemento(FLECHA_DA_PRIMEIRA_TURMA);
        ClicoNoElemento(PARTCIPANTES);
        ClicoNoElemento(SELECT_MENSAGEM_YURI);
        EsperoEstarVisivel(DESTINATARIO).clear();
        Envio_O_Dado(DESTINATARIO, DESTINATARIO_ERRADO);
        Envio_O_Dado(ASSUNTO, TEXT_ASSUNTO);
        Envio_O_Dado(MENSAGEM, TEXT_MENSAGEM);
        ClicoNoElemento(BOTAO_ENVIAR);
        ClicoNoElemento(FECHAR_POPUP);

        // Exemplo de uso: Clica em um botão para gerar o alerta e o aceita
        String alertText = UsefulConstants.CapturoAlerta(HOME, true);

        if (alertText != null) {
            System.out.println("Alerta capturado com o texto: " + alertText);
        }

    }
}