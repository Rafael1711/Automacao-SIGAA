package Pages;

import static Locators.Emitir_Declaracao_Vinculo_Locators.*;
import static Locators.Useful_Constants_Locators.*;

public class EmitirDeclaracaoVinculoPage extends UsefulConstants {
     LoginPage LoginPageObject =  new LoginPage();

     public void EmitirDeclaracaoDeVinculo( ) throws InterruptedException {
          LoginPageObject.fazerLogin();
          ClicoNoElemento(ENSINO);
          Thread.sleep(500);
          ClicoNoElemento(EMITIR_DECLARACAO_VINCULO);
          Thread.sleep(2500);
     }

     public void ExcluirDeclaracaoVinculo(){
          verificarEExcluirArquivo(NOME_DECLARACAO_VINCULO);
     }
}