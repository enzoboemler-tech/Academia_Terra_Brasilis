package view;

import javax.swing.*;
import java.awt.*;

public class MenuLateral extends JPanel {
    private ImageIcon planilha = new ImageIcon(new ImageIcon(getClass().getResource("/icone planilha.jpg"))
            .getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
    private ImageIcon pessoa = new ImageIcon(new ImageIcon(getClass().getResource("/icone pessoa.png"))
            .getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
    private ImageIcon halter = new ImageIcon(new ImageIcon(getClass().getResource("/halter.png"))
            .getImage().getScaledInstance(33, 28, Image.SCALE_SMOOTH));
    private JButton btnFichasDeTreino;
    private JButton btnAlunos;
    private JButton btnTreinos;
    private JFrame telaAberta;

    public MenuLateral(JFrame tela) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(265, 550));
        setBackground(new Color(73, 129, 78));
        telaAberta = tela;

        add(Box.createVerticalStrut(20));

        criarBtnFichasDeTreino();
        criarBtnAlunos();
        criarBtnTreinos();
    }

    // Além de criar o botão, este méttodo serve para verificar se a tela que o botão abre já
    // está aberta, caso esteja, impede que seja aberta de novo e formata o mouse para indicar isso
    public void criarBtnFichasDeTreino() {
        btnFichasDeTreino = Botao.criarBotaoRetangular("Fichas de Treino", planilha, 55);
        if (telaAberta instanceof TelaFichasDeTreino) {
            Botao.deixarBotaoNaoClicavel(btnFichasDeTreino);
        } else {
            btnFichasDeTreino.addActionListener(e -> new TelaFichasDeTreino());
        }
        add(btnFichasDeTreino);
    }

   public void criarBtnAlunos() {
       btnAlunos = Botao.criarBotaoRetangular("Alunos", pessoa, 55);
       if (telaAberta instanceof TelaAlunos) {
           Botao.deixarBotaoNaoClicavel(btnAlunos);
       } else {
           btnAlunos.addActionListener(e -> new TelaAlunos());
       }
       add(btnAlunos);
   }

   public void criarBtnTreinos() {
       btnTreinos = Botao.criarBotaoRetangular("Treinos", halter, 55);
       if (telaAberta instanceof TelaTreinos) {
           Botao.deixarBotaoNaoClicavel(btnTreinos);
       } else {
           btnTreinos.addActionListener(e -> new TelaTreinos());
       }
       add(btnTreinos);
   }

}
