package Pages;

import static Locators.Emitir_Historico_Locators.*;
import static Locators.Useful_Constants_Locators.*;

public class EmitirHistoricoPage extends UsefulConstants {
     LoginPage LoginPageObject =  new LoginPage();

     public void EmitirHistorico( ) throws InterruptedException {
          LoginPageObject.fazerLogin();
          ClicoNoElemento(ENSINO);
          Thread.sleep(500);
          ClicoNoElemento(EMITIR_HISTORICO);
          Thread.sleep(2500);
     }

     public void ExcluirHistorico(){
          verificarEExcluirArquivo(NOME_HISTORICO);
     }
}