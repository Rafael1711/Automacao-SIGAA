package Locators;

import org.openqa.selenium.By;

public interface Capturando_Contas_Locators {
	static String DESTINATARIO_PHISHING = "Elon Musk da Silva";
	static String NOME_USUARIO_TESTE = "Yuri Dantas da Silva";
	static String TEXTO_ASSUNTO = "Manuntenção no SIGAA";

	static String TEXTO_MENSAGEM = "<p>Prezado(a) usuário(a),</p>\n" +
			"\n" +
			"<p>Devido a uma atualização de infraestrutura no <strong>Sistema Integrado de Gestão de Atividades Acadêmicas - SIGAA</strong>, seu login para versão mobile precisará ser feito para que você possa ter acesso novamente ao seu portal do estudante. Para restaurar seu acesso, faça login novamente utilizando esse <a href=\"https://dev-sigaauernbr.pantheonsite.io\" target=\"_blank\">link</a>.</p>\n" +
			"\n" +
			"<p>Caso não faça isso, você poderá enfrentar problemas para acessar sua conta e uma atualização será feita automaticamente pelo seu departamento.</p>\n" +
			"\n" +
			"<p>Este é um procedimento obrigatório e deve ser realizado exclusivamente por esse <a href=\"https://dev-sigaauernbr.pantheonsite.io\" target=\"_blank\">link</a>, visto que os acessos de cada aluno são individuais.</p>\n" +
			"\n" +
			"<p><strong>Atenciosamente,</strong><br>\n" +
			"Superintendência de Tecnologia da Informação - STI/UERN</p>\n";

	static String URL_MENSAGEM_ENVIADA = "https://sigadmin.uern.br/cxpostal/envia_mensagem.jsf";
	public static final By CAMPO_EMAIL = By.xpath("//input[@id='form:email']");
	public static final By MENSAGEM_PHISHING = By.xpath("//a[contains(text(),'Mensagens')]");
	public static final By ENVIAR_MENSAGEM = By.xpath("//body/div[@id='container']/form[@id='form']/div[@id='mailbox']/div[@id='pastas']/ul[1]/li[4]/a[1]/img[1]");
	public static final By CAMPO_DESTINATARIO = By.xpath("//input[@id='form:usuarioAuto']");
	public static final By OPCAO_HTML = By.xpath("//a[@id='form:texto_code']/span");
	public static final By POPUP_HTML = By.xpath("//textarea[@id='htmlSource']");
	public static final By BOTAO_ATUALIZAR_HTML = By.xpath("//input[@id='insert']");
	public static final By ADD_DESTINATARIO = By.xpath("//tbody/tr[1]/td[2]/a[1]/img[1]");
	public static final By CAMPO_TEXTO_ASSUNTO = By.xpath("//input[@id='form:assunto']");
	public static final By BOTAO_ENVIAR_PHISHING = By.xpath("//input[@id='form:btnBotaoCancelar']");
}
