package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class Botao {

    public static JButton deixarBotaoNaoClicavel(JButton botao) {
        botao.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        return botao;
    }

    public static JButton criarBotaoRetangular(String titulo, ImageIcon icone, int altura) {
        JButton botao = new JButton(titulo, icone);
        botao.setFont(new Font("Arial", Font.BOLD, 24));
        botao.setForeground(new Color(255, 255, 255));

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

    public static JButton criarBotaoCircular(ImageIcon icone) {
        JButton botao = new JButton(icone);
        botao.setContentAreaFilled(false);   // tira o fundo (a cor cinza/azul do botão)
        botao.setBorderPainted(false);       // tira a borda
        botao.setFocusPainted(false);        // tira o contorno pontilhado ao clicar
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Mostra a 'mãozinha' do mouse ao passar pelo botão

        // Define o ícone normal, para o método não depender de como o botão foi criado
        botao.setIcon(icone);

        // Copia o ícone para uma BufferedImage, que é o formato que o RescaleOp aceita.
        // TYPE_INT_ARGB mantém o canal alfa (transparência), preservando o recorte circular
        BufferedImage img = new BufferedImage(
                icone.getIconWidth(), icone.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.drawImage(icone.getImage(), 0, 0, null);
        g.dispose(); // libera os recursos gráficos

        // Multiplica R, G e B por 0,85 (escurece 15%) e mantém o alfa em 1 (inalterado).
        // O array de zeros (new float[4]) é o deslocamento somado depois da multiplicação
        RescaleOp escurecer = new RescaleOp(
                new float[]{0.75f, 0.75f, 0.75f, 1f}, new float[4], null);
        ImageIcon iconeHover = new ImageIcon(escurecer.filter(img, null));

        botao.setRolloverEnabled(true);
        botao.setRolloverIcon(iconeHover);

        return botao;
    }
}
