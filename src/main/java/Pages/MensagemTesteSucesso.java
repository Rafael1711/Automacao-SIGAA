package Pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MensagemTesteSucesso {
    public void ExibirMensagemSucesso(String mensagem) {
        // Criando o painel simples sem imagem de fundo
        JPanel mensagemPanel = new JPanel();
        mensagemPanel.setLayout(new BorderLayout());
        mensagemPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Borda de 20px para espaçamento
        mensagemPanel.setBackground(new Color(100, 100, 100)); // Fundo cinza escuro

        // Criando o texto da mensagem
        JLabel mensagemLabel = new JLabel(
                "<html>" +
                        "<div style='text-align: center; font-size: 16px; font-weight: bold; color: white;'>" + mensagem +
                        "</div></html>",
                JLabel.CENTER
        );

        mensagemLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

        // Adicionando o texto ao painel
        mensagemPanel.add(mensagemLabel, BorderLayout.CENTER);

        // Criando o JOptionPane
        JOptionPane optionPane = new JOptionPane(
                mensagemPanel,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION
        );

        JDialog dialog = optionPane.createDialog(null, null);

        // Ajustando o tamanho automaticamente com base no conteúdo
        dialog.pack();

        // Centralizando a janela na tela
        dialog.setLocationRelativeTo(null);

        // Exibindo a janela
        dialog.setVisible(true);
    }
}