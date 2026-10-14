package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.JTextComponent;

public class TelaLogin extends JFrame {
    JPanel fundo;
    JPasswordField txtSenha;

    public TelaLogin() {
        setTitle("Login");
        setSize(1000, 707);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // carrega imagem
        Image imagem = new ImageIcon(getClass().getResource("/Imagem Login.png")).getImage();

        // painel que desenha a imagem
        fundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
            }
        };
        fundo.setPreferredSize(new Dimension(1000, 707));
        setContentPane(fundo);
        setLayout(null);

        JButton btnMostrarSenha = new JButton();
        btnMostrarSenha.setBounds(355, 228, 22, 24);
        fundo.add(btnMostrarSenha);
        btnMostrarSenha.addActionListener(e -> mostrarSenha());

        JTextField txtLogin = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharDica(this, g, "Digite seu e-mail");
            }
        };
        txtLogin.setBounds(127, 228, 250, 26);
        txtLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        txtLogin.setOpaque(false);
        fundo.add(txtLogin);

        txtSenha = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharDica(this, g, "Digite sua senha");
            }
        };
        txtSenha.setBounds(127, 403, 250, 26);
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 15));
        fundo.add(txtSenha);

        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.setBounds(165, 500, 180, 50);
        btnEntrar.setBackground(new Color(30, 120, 50));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 25));
        //btnEntrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fundo.add(btnEntrar);

        setVisible(true);

        fundo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("x=" + e.getX() + " y=" + e.getY());
            }
        });

    }

    // Para mostrar o que é para escrever em cada campo da tela e sumir quando o usuário digitar
    private void desenharDica(JTextComponent campo, Graphics g, String dica) {
        // só desenha se o campo estiver vazio
        if (campo.getDocument().getLength() > 0) return;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setFont(campo.getFont().deriveFont(Font.ITALIC));

        FontMetrics fm = g2.getFontMetrics();
        int x = campo.getInsets().left;                                   // respeita a margem de 8 px
        int y = (campo.getHeight() - fm.getHeight()) / 2 + fm.getAscent(); // centraliza na vertical
        g2.drawString(dica, x, y);
        g2.dispose();
    }

    public void mostrarSenha() {
        System.out.println(txtSenha);
    }




}