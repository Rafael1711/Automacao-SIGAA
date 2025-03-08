package Pages;

import org.junit.Assert;

import static Locators.Login_Locators.*;

public class LoginPage extends UsefulConstants {

     public void fazerLogin() {
          Envio_O_Dado(INPUT_USUARIO, USUARIO_CERTO);
          Envio_O_Dado(INPUT_SENHA, SENHA_CERTA);
          ClicoNoElemento(BOTAO_ENTRAR);
          VerificoUrl(URL_LOG_ON);
     }

     public void UsuarioErradoSenhaErrada() {
          Envio_O_Dado(INPUT_USUARIO, USUARIO_ERRADO );
          Envio_O_Dado(INPUT_SENHA, SENHA_ERRADA );
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: UsuarioErradoSenhaErrada - Título da página: " + valorDaPagina );
          Xerxes.findElement(INPUT_USUARIO).clear();
     }

     public void UsuarioCertoSenhaErrada() {
          Envio_O_Dado(INPUT_USUARIO, USUARIO_CERTO);
          Envio_O_Dado(INPUT_SENHA, SENHA_ERRADA);
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: UsuarioCertoSenhaErrada - Título da página: " + valorDaPagina );
          Xerxes.findElement(INPUT_USUARIO).clear();
     }

     public void UsuarioErradoSenhaCerta() {
          Envio_O_Dado(INPUT_USUARIO, USUARIO_ERRADO);
          Envio_O_Dado(INPUT_SENHA, SENHA_CERTA);
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: UsuarioErradoSenhaCerta - Título da página: " + valorDaPagina );
          Xerxes.findElement(INPUT_USUARIO).clear();
     }

     public void UsuarioErrado() {
          Envio_O_Dado(INPUT_USUARIO, USUARIO_ERRADO);
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: UsuarioErrado - Título da página: " + valorDaPagina );
          Xerxes.findElement(INPUT_USUARIO).clear();
     }

     public void SenhaErrada() {
          Envio_O_Dado(INPUT_SENHA, SENHA_ERRADA);
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: SenhaErrada - Título da página: " + valorDaPagina );
     }

     public void UsuarioCerto() {
          Envio_O_Dado(INPUT_USUARIO, USUARIO_CERTO);
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: UsuarioCerto - Título da página: " + valorDaPagina );
          Xerxes.findElement(INPUT_USUARIO).clear();
     }

     public void SenhaCerta() {
          Envio_O_Dado(INPUT_SENHA, SENHA_CERTA);
          ClicoNoElemento(BOTAO_ENTRAR);
          String valorDaPagina = EsperoEstarVisivel(TITULO_LOGIN_FALHA).getText();
          Assert.assertEquals(valorDaPagina, "Usuário e/ou senha inválidos");
          System.out.println(" Teste: SenhaCerta - Título da página: " + valorDaPagina );
     }

     public void FazerLoginFalha() {
          int i = 1;
          while( i <= 5 ) {
               System.out.println();
               System.out.println(i + "° bloco de execução:");
               UsuarioErradoSenhaErrada();
               UsuarioCertoSenhaErrada();
               UsuarioErradoSenhaCerta();
               UsuarioErrado();
               SenhaErrada();
               UsuarioCerto();
               SenhaCerta();
               i++;
          }
     }
}