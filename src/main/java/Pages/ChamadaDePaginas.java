package Pages;

import javax.swing.*;
import java.awt.*;

public class ChamadaDePaginas {
    public static void main(String[] args) throws InterruptedException {
        String opcao;
        MensagemTesteSucesso MensagemTesteSucessoObject = new MensagemTesteSucesso();

        do {
            // Criando um JPanel customizado para desenhar a imagem de fundo
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon imageIcon = new ImageIcon("C:\\Projetos\\AutomacaoSIGAA\\Img_Fundo\\SIGAA.png"); // Caminho para a imagem
                    Image image = imageIcon.getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

                    // Desenha uma sobreposição semi-transparente
                    Color overlayColor = new Color(20, 39, 67, 213); // Azul com transparência
                    g.setColor(overlayColor);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            panel.setLayout(new BorderLayout());

            // Criando o JLabel com o título e o menu
            JLabel label = new JLabel(
                    "<html>" +

                            "<div " +
                            "style='text-align: center; " +
                            "font-size: 18px; " +
                            "font-weight: bold;'>TESTES FUNCIONAIS NO SIGAA" +
                            "</div>" +

                            "<br>" +

                            "<div style='text-align: center;" +
                            "font-size: 15px; " +
                            "font-weight: bold;'>Escolha um teste a ser realizado:" +
                            "</div>" +

                            "<br>" +

                            "<table style='width: 100%; " +
                            "text-align: center; " +
                            "font-size: 14px;'>" +

                            "   <tr>" +
                            "       <td style='padding: 10px;'>1 - Fazer Login</td>" +
                            "       <td style='padding: 10px;'>2 - Bug Log-Off Usuário</td>" +
                            "       <td style='padding: 10px;'>3 - Capturar Contas</td>" +
                            "   </tr>" +

                            "   <tr>" +
                            "       <td style='padding: 10px;'>4 - Emitir Histórico</td>" +
                            "       <td style='padding: 10px;'>5 - Declaração De Vínculo</td>" +
                            "       <td style='padding: 10px;'>6 - Atestado De Matrícula</td>" +
                            "   </tr>" +

                            "   <tr>" +
                            "       <td style='padding: 10px;'>7 - Relatório De Notas</td>" +
                            "       <td style='padding: 10px;'>8 - índices Acadêmicos</td>" +
                            "       <td style='padding: 10px;'>9 - Alterar Senha</td>" +
                            "   </tr>" +

                            "</table>" +

                            "<br>" +

                            "<div style='text-align: center; " +
                            "font-size: 15px;'>Informe sua opção:</div>" +

                            "</html>",

                    JLabel.CENTER
            );

            label.setForeground(Color.WHITE);
            label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

            // Adicionando o texto ao painel
            panel.add(label, BorderLayout.CENTER);

            // Exibindo o painel no JOptionPane
            opcao = JOptionPane.showInputDialog(
                    null,
                    panel,
                    null,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (opcao == null) {
                break;
            }

            switch (opcao) {
                case "1":
                    UsefulConstants.start();
                    LoginPage LoginPageObject = new LoginPage();
                    LoginPageObject.fazerLogin();
                    UsefulConstants.ClicarBotaoSair();
                    LoginPageObject.FazerLoginFalha();
                    UsefulConstants.close();
                    break;

                case "2":
                    UsefulConstants.start();
                    BugLogOffUsuarioPage DeslogarUserPageObject = new BugLogOffUsuarioPage();
                    DeslogarUserPageObject.UserLogOff();
                    UsefulConstants.close();
                    break;

                case "3":
                    UsefulConstants.start();
                    CapturandoContasPage CapturandoContasPageObject = new CapturandoContasPage();
                    CapturandoContasPageObject.CapturarContas();
                    UsefulConstants.close();
                    break;

                case "4":
                    UsefulConstants.start();
                    EmitirHistoricoPage EmitirHistoricoPageObject = new EmitirHistoricoPage();
                    EmitirHistoricoPageObject.EmitirHistorico();
                    EmitirHistoricoPageObject.ExcluirHistorico();
                    UsefulConstants.close();
                    break;

                case "5":
                    UsefulConstants.start();
                    EmitirDeclaracaoVinculoPage EmitirDeclaracaoVinculoPageObject = new EmitirDeclaracaoVinculoPage();
                    EmitirDeclaracaoVinculoPageObject.EmitirDeclaracaoDeVinculo();
                    EmitirDeclaracaoVinculoPageObject.ExcluirDeclaracaoVinculo();
                    UsefulConstants.close();
                    break;

                case "6":
                    UsefulConstants.start();
                    EmitirAtestadoDeMatriculaPage EmitirAtestadoDeMatriculaPageObject = new EmitirAtestadoDeMatriculaPage();
                    EmitirAtestadoDeMatriculaPageObject.EmitirAtestadoDeMatricula();
                    EmitirAtestadoDeMatriculaPageObject.ExcluirAtestadoDeMatricula();
                    UsefulConstants.close();
                    break;

                case "7":
                    UsefulConstants.start();
                    EmitirRelatorioDeNotasPage EmitirRelatorioDeNotasPageObject = new EmitirRelatorioDeNotasPage();
                    EmitirRelatorioDeNotasPageObject.EmitirRelatorioDeNotas();
                    EmitirRelatorioDeNotasPageObject.ExcluirRelatorioDeNotas();
                    UsefulConstants.close();
                    break;

                case "8":
                    UsefulConstants.start();
                    EmitirIndicesAcademicosPage EmitirIndicesAcademicosPageObject = new EmitirIndicesAcademicosPage();
                    EmitirIndicesAcademicosPageObject.EmitirIndicesAcademicos();
                    EmitirIndicesAcademicosPageObject.ExcluirIndicesAcademicos();
                    UsefulConstants.close();
                    break;

                case "9":
                    UsefulConstants.start();
                    AlterarSenhaSucessoPage AlterarSenhaSucessoPageObject = new AlterarSenhaSucessoPage();
                    AlterarSenhaSucessoPageObject.AlterarSenha();
                    UsefulConstants.close();
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida! Por favor, tente novamente.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
            }

        } while (true);
    }
}
