package view;

import model.FichaDeTreino;

import javax.swing.*;
import java.awt.*;

// TODO: falta definir como as fichas vão aparecer ser adicionadas à 'lista'
// TODO: quero que apareçam na ordem de última atualização

public class TelaFichasDeTreino extends JFrame{
    private DefaultListModel<String> listaDeFichas;
    private JList<String> lista;
    ImageIcon botaoAdicionar = new ImageIcon(new ImageIcon(getClass().getResource("/botao adicionar.png"))
            .getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));

    public TelaFichasDeTreino() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelCentro = new JPanel(new BorderLayout());
        painelCentro.setBorder(BorderFactory.createMatteBorder
                (1, 0, 0, 0, Color.LIGHT_GRAY)); // Para criar a linha logo acima da primeira ficha
        add(painelCentro, BorderLayout.CENTER);

        add(new MenuLateral(this), BorderLayout.WEST);

        listaDeFichas = new DefaultListModel<>();
        listaDeFichas.addElement("Ficha de Treino - Enzo");

        lista = new JList<>(listaDeFichas);
        lista.setCellRenderer(new FichaRenderer());
        lista.setFixedCellHeight(50); // Ajusta o tamanho de cada célula da lista de fichas

        // Para fazer aparecer a mão quando o mouse passar sobre um item da lista
        lista.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                int indice = lista.locationToIndex(e.getPoint());
                boolean sobreItem = indice != -1
                        && lista.getCellBounds(indice, indice).contains(e.getPoint());
                lista.setCursor(sobreItem
                        ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                        : Cursor.getDefaultCursor());
            }
        });

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(750, 550));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        painelCentro.add(scroll, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelInferior.setBackground(Color.WHITE);
        painelCentro.add(painelInferior, BorderLayout.SOUTH);

        JButton btnAdicionar = new JButton(botaoAdicionar);
        painelInferior.add(Botao.criarBotaoCircular(botaoAdicionar));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void adicionarFicha(FichaDeTreino ficha) {

    }
}
