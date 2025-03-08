package Pages;

import static Locators.Emitir_Indices_Academicos_Locators.*;
import static Locators.Useful_Constants_Locators.*;

public class EmitirIndicesAcademicosPage extends UsefulConstants {
     LoginPage LoginPageObject =  new LoginPage();

     public void EmitirIndicesAcademicos( ) throws InterruptedException {
          LoginPageObject.fazerLogin();
          ClicoNoElemento(ENSINO);
               Thread.sleep(500);
          ClicoNoElemento(EMITIR_INDICES_ACADEMICOS);
               Thread.sleep(500);
          ClicoNoElemento(BOTAO_IMPRIMIR);
          Thread.sleep(2500);
     }

     public void ExcluirIndicesAcademicos(){
          verificarEExcluirArquivo(NOME_INDICES_ACADEMICOS);
     }
}