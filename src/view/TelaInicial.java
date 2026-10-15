package view;

import model.FichaDeTreino;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame{
    private DefaultListModel<String> listaDeFichas;
    private JList<String> lista;

    public TelaInicial() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new GridLayout(3,1, 0, 30));
        menuLateral.setPreferredSize(new Dimension(250, 500));
        menuLateral.setBackground(new Color(61, 121, 74));
        add(menuLateral, BorderLayout.WEST);

        JButton btnFichasDeTreino = new JButton("Fichas de Treino");
        btnFichasDeTreino.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        btnFichasDeTreino.setFont(new Font("Arial", Font.BOLD, 24));
        btnFichasDeTreino.setForeground(new Color(255, 255, 255));
        //menuLateral.add(botao.formatarBotao(btnFichasDeTreino));
        menuLateral.add(btnFichasDeTreino);

        JButton btnAlunos = new JButton("Alunos");
        btnAlunos.setFont(new Font("Arial", Font.BOLD, 24));
        btnAlunos.setForeground(new Color(255, 255, 255));
        //menuLateral.add(botao.formatarBotao(btnAlunos));
        menuLateral.add(BotaoFormatado.formatarBotao(btnFichasDeTreino));

        listaDeFichas = new DefaultListModel<>();
        listaDeFichas.addElement("Ficha de Treino - Enzo");

        lista = new JList<>(listaDeFichas);
        lista.setPreferredSize(new Dimension(500, 500));
        lista.setCellRenderer(new FichaRenderer());
        lista.setFixedCellHeight(50);

        JScrollPane scroll = new JScrollPane(lista);
        add(scroll, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public void adicionarFicha(FichaDeTreino ficha) {

    }
}
