package Pages;

import static Locators.Emitir_Atestado_De_Matricula_Locators.*;
import static Locators.Useful_Constants_Locators.*;

public class EmitirAtestadoDeMatriculaPage extends UsefulConstants {
     LoginPage LoginPageObject =  new LoginPage();

     public void EmitirAtestadoDeMatricula( ) throws InterruptedException {
          LoginPageObject.fazerLogin();
          ClicoNoElemento(ENSINO);
               Thread.sleep(500);
          ClicoNoElemento(EMITIR_ATESTADO_DE_MATRICULA);
               Thread.sleep(500);
          ClicoNoElemento(BOTAO_IMPRIMIR);
          Thread.sleep(2500);
     }

     public void ExcluirAtestadoDeMatricula(){
          verificarEExcluirArquivo(NOME_ATESTADO_DE_MATRICULA);
     }
}