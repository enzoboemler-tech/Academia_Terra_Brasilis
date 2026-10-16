package view;

import model.FichaDeTreino;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TelaInicial extends JFrame{
    private DefaultListModel<String> listaDeFichas;
    private JList<String> lista;
    ImageIcon planilha = new ImageIcon(new ImageIcon(getClass().getResource("/planilha.png"))
            .getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH));
    ImageIcon pessoa = new ImageIcon(new ImageIcon(getClass().getResource("/icone pessoa.png"))
            .getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH));

    public TelaInicial() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        menuLateral.setPreferredSize(new Dimension(250, 500));
        menuLateral.setBackground(new Color(73, 129, 78));
        add(menuLateral, BorderLayout.WEST);

        JButton btnFichasDeTreino = new JButton("Fichas de Treino", planilha);
        btnFichasDeTreino.setFont(new Font("Arial", Font.BOLD, 22));
        btnFichasDeTreino.setForeground(new Color(255, 255, 255));
        menuLateral.add(Box.createVerticalStrut(20));
        menuLateral.add(BotaoFormatado.formatarBotao(btnFichasDeTreino, 50));

        JButton btnAlunos = new JButton("Alunos", pessoa);
        btnAlunos.setFont(new Font("Arial", Font.BOLD, 22));
        btnAlunos.setForeground(new Color(255, 255, 255));
        menuLateral.add(BotaoFormatado.formatarBotao(btnAlunos, 50));

        JButton btnTreinos = new JButton("Treinos");
        btnTreinos.setFont(new Font("Arial", Font.BOLD, 22));
        btnTreinos.setForeground(new Color(255, 255, 255));
        menuLateral.add(BotaoFormatado.formatarBotao(btnTreinos, 50));

        listaDeFichas = new DefaultListModel<>();
        listaDeFichas.addElement("Ficha de Treino - Enzo");

        lista = new JList<>(listaDeFichas);
        lista.setCellRenderer(new FichaRenderer());
        lista.setFixedCellHeight(50); // Ajusta o tamanho de cada célula da lista de fichas

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(700, 500));
        add(scroll, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void adicionarFicha(FichaDeTreino ficha) {

    }
}
