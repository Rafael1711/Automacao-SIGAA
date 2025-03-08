package Locators;

import org.openqa.selenium.By;

public interface Useful_Constants_Locators {
	static String TEXTO_TITULO_SUCESSO_ALTERAR_DADOS = "Dados Alterados com Sucesso";

	public static final By ALTERAR_SENHA = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]");
	public static final By BOTAO_ALTERAR_DADOS = By.xpath("//input[@id='form:alterarDados']");
	public static final By TITULO_SUCESSO_ALTERAR_DADOS = By.xpath("//h1[contains(text(),'Dados Alterados com Sucesso')]");
	public static final By ENSINO = By.xpath("//span[contains(text(),'Ensino')]");
	public static final By BOTAO_SAIR = By.xpath("//a[contains(text(),'SAIR')]");
	public static final By BOTAO_FECHAR = By.xpath("//body/div[@id='container']/center[1]/a[1]/img[1]");
	public static final By BOTAO_IMPRIMIR= By.xpath("//a[contains(text(),'Imprimir')]");
}