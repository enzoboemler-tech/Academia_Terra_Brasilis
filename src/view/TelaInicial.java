package view;

import model.FichaDeTreino;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame{
    private DefaultListModel<String> listaDeFichas;
    private JList<String> lista;
    ImageIcon planilha = new ImageIcon(new ImageIcon(getClass().getResource("/icone planilha.jpg"))
            .getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
    ImageIcon pessoa = new ImageIcon(new ImageIcon(getClass().getResource("/icone pessoa.png"))
            .getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
    ImageIcon halter = new ImageIcon(new ImageIcon(getClass().getResource("/halter.png"))
            .getImage().getScaledInstance(33, 28, Image.SCALE_SMOOTH));
    ImageIcon botaoAdicionar = new ImageIcon(new ImageIcon(getClass().getResource("/botao adicionar.png"))
            .getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));

    public TelaInicial() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelCentro = new JPanel(new BorderLayout());
        painelCentro.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY)); // Para criar a linha logo acima da primeira ficha
        add(painelCentro, BorderLayout.CENTER);

        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        menuLateral.setPreferredSize(new Dimension(265, 550));
        menuLateral.setBackground(new Color(73, 129, 78));
        add(menuLateral, BorderLayout.WEST);

        JButton btnFichasDeTreino = new JButton("Fichas de Treino", planilha);
        btnFichasDeTreino.setFont(new Font("Arial", Font.BOLD, 24));
        btnFichasDeTreino.setForeground(new Color(255, 255, 255));
        menuLateral.add(Box.createVerticalStrut(20));
        menuLateral.add(BotaoFormatado.formatarBotao(btnFichasDeTreino, 55));

        JButton btnAlunos = new JButton("Alunos", pessoa);
        btnAlunos.setFont(new Font("Arial", Font.BOLD, 24));
        btnAlunos.setForeground(new Color(255, 255, 255));
        menuLateral.add(BotaoFormatado.formatarBotao(btnAlunos, 55));

        JButton btnTreinos = new JButton("Treinos", halter);
        btnTreinos.setFont(new Font("Arial", Font.BOLD, 24));
        btnTreinos.setForeground(new Color(255, 255, 255));
        menuLateral.add(BotaoFormatado.formatarBotao(btnTreinos, 55));

        listaDeFichas = new DefaultListModel<>();
        listaDeFichas.addElement("Ficha de Treino - Enzo");

        lista = new JList<>(listaDeFichas);
        lista.setCellRenderer(new FichaRenderer());
        lista.setFixedCellHeight(50); // Ajusta o tamanho de cada célula da lista de fichas

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(750, 550));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        painelCentro.add(scroll, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelInferior.setBackground(Color.WHITE);
        painelCentro.add(painelInferior, BorderLayout.SOUTH);

        JButton btnAdicionar = new JButton(botaoAdicionar);
        painelInferior.add(BotaoFormatado.formatarBotaoCircular(btnAdicionar, botaoAdicionar));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void adicionarFicha(FichaDeTreino ficha) {

    }
}
