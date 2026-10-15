package view;

import javax.swing.*;
import java.awt.*;

public class BotaoFormatado {

    public static JButton formatarBotao(JButton botao) {
        botao.setContentAreaFilled(false);   // tira o fundo (a cor cinza/azul do botão)
        botao.setBorderPainted(false);       // tira a borda
        botao.setFocusPainted(false);        // tira o contorno pontilhado ao clicar
        botao.setOpaque(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return botao;
    }
}
