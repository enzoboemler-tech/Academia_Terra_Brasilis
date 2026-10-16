package view;

import javax.swing.*;
import java.awt.*;

public class BotaoFormatado {

    public static JButton formatarBotao(JButton botao, int altura) {
        botao.setContentAreaFilled(false);   // tira o fundo (a cor cinza/azul do botão)
        botao.setBorderPainted(false);       // tira a borda
        botao.setFocusPainted(false);        // tira o contorno pontilhado ao clicar
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Mostra a 'mãozinha' do mouse ao passar pelo botão
        botao.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha os componentes no centro do ponto de referência
        botao.setMaximumSize(new Dimension(Integer.MAX_VALUE, altura)); // Faz o botão preencher todo o espaço lateral

        // Para o botão parecer reagir ao passar o mouse por cima
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                //botao.setBorderPainted(true);
                botao.setContentAreaFilled(true);
                botao.setBackground(new Color(130, 194, 150));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                //botao.setBorderPainted(false);
                botao.setContentAreaFilled(false);
            }
        });

        return botao;
    }
}
