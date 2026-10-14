package util;

import javax.swing.JOptionPane;

public class Mensagens {
    // Mensagem de sucesso
    public static void sucesso(String mensagem){
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Mensagem de erro
    public static void erro(String mensagem){
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Erro",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Mensagem de aviso
    public static void aviso(String mensagem){
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Aviso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}

