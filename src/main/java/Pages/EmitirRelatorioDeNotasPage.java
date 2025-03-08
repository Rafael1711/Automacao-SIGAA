package Pages;

import static Locators.Emitir_Relatorio_De_Notas_Locators.*;
import static Locators.Useful_Constants_Locators.*;

public class EmitirRelatorioDeNotasPage extends UsefulConstants {
     LoginPage LoginPageObject =  new LoginPage();

     public void EmitirRelatorioDeNotas( ) throws InterruptedException {
          LoginPageObject.fazerLogin();
          ClicoNoElemento(ENSINO);
               Thread.sleep(500);
          ClicoNoElemento(CONSULTAR_MINHAS_NOTAS);
               Thread.sleep(500);
          ClicoNoElemento(BOTAO_IMPRIMIR);
          Thread.sleep(2500);
     }

     public void ExcluirRelatorioDeNotas(){
          verificarEExcluirArquivo(NOME_RELATORIO_DE_NOTAS);
     }
}