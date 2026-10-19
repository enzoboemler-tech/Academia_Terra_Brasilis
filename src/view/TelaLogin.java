package view;

import dao.UsuarioDAO;
import model.Usuario;
import util.Mensagens;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.JTextComponent;

public class TelaLogin extends JFrame {
    private JPanel fundo;
    private JPasswordField txtSenha;
    private JTextField txtLogin;
    private char echoPadrao;
    private ImageIcon iconeMostrarSenha;
    private ImageIcon iconeEsconderSenha;
    private JButton btnMostrarSenha;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    public TelaLogin() {
        setTitle("Login");
        setSize(1000, 707);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // carrega imagem de fundo
        Image imagem = new ImageIcon(getClass().getResource("/Imagem Login.png")).getImage();

        // painel que desenha a imagem
        fundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
            }
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;   // avisa o Swing que há componentes sobrepostos
                // usei isso para que o ícone de mostrar a senha (o olhinho) não suma ao digitar no txtSenha
            }
        };
        fundo.setPreferredSize(new Dimension(1000, 707));
        setContentPane(fundo);
        setLayout(null);

        txtLogin = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharDica(this, g, "Digite seu e-mail");
            }
        };
        txtLogin.setBounds(127, 226, 250, 30);
        txtLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        txtLogin.setOpaque(false);
        fundo.add(txtLogin);

        // Criando os ícones para mostrar/esconder senha
        iconeMostrarSenha = new ImageIcon(new ImageIcon(getClass().getResource("/olho preto.png"))
                .getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH));
        iconeEsconderSenha = new ImageIcon(new ImageIcon(getClass().getResource("/olho preto riscado.png"))
                .getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH));

        // botão que fica por baixo do idcone de mostrar a senha
        btnMostrarSenha = new JButton();
        btnMostrarSenha.setBounds(346, 400, 30, 30);
        btnMostrarSenha.setIcon(iconeMostrarSenha);
        fundo.add(btnMostrarSenha);
        btnMostrarSenha.addActionListener(e -> mostrarSenha());

        btnMostrarSenha.setContentAreaFilled(false);   // tira o fundo (a cor cinza/azul do botão)
        btnMostrarSenha.setBorderPainted(false);       // tira a borda
        btnMostrarSenha.setFocusPainted(false);        // tira o contorno pontilhado ao clicar
        btnMostrarSenha.setOpaque(false);              // deixa o botão transparente por completo


        txtSenha = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharDica(this, g, "Digite sua senha");
            }
        };
        txtSenha.setBounds(127, 401, 250, 29);
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        fundo.add(txtSenha);
        echoPadrao = txtSenha.getEchoChar();

        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.setBounds(165, 500, 180, 50);
        btnEntrar.setBackground(new Color(30, 120, 50));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 25));
        btnEntrar.addActionListener(e -> realizarLogin());
        getRootPane().setDefaultButton(btnEntrar); // permite que o enter "clique" no botão mesmo de qualquer lugar da página
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fundo.add(btnEntrar);

        setVisible(true);
    }

    // Para mostrar o que é para escrever em cada campo da tela e sumir quando o usuário digitar
    // Isso se chama placeholder
    private void desenharDica(JTextComponent campo, Graphics g, String dica) {
        // só desenha se o campo estiver vazio
        if (campo.getDocument().getLength() > 0) return;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setFont(campo.getFont().deriveFont(Font.ITALIC));

        FontMetrics fm = g2.getFontMetrics();
        int x = campo.getInsets().left;  // respeita a margem de 8 px
        int y = (campo.getHeight() - fm.getHeight()) / 2 + fm.getAscent(); // centraliza na vertical
        g2.drawString(dica, x, y);
        g2.dispose();
    }

    // Responsável pela lógica de ocultar e mostrar a senha
    public void mostrarSenha() {
        if (txtSenha.getEchoChar() == (char) 0) {
            // O "(char) 0" representa o valor zero convertido para char
            txtSenha.setEchoChar(echoPadrao); // Esconde a senha novamente
            btnMostrarSenha.setIcon(iconeMostrarSenha);
        } else {
            txtSenha.setEchoChar((char) 0); // Mostra a senha
            btnMostrarSenha.setIcon(iconeEsconderSenha);
        }
    }

    private void realizarLogin(){
        String login = txtLogin.getText().trim();
        String senha = new String(txtSenha.getPassword());

        // Verifica login vazio
        if (login.isEmpty()){
            Mensagens.aviso("Informe o login.");
            return;
        }
        if (senha.isEmpty()){
            Mensagens.aviso("Informe a senha");
            return;
        }

        //Realizar autenticação
        Usuario usuario = usuarioDAO.autenticar(login,senha);
        // Usuário encontrado
        if (usuario != null){
            String nomeUsuario = usuario.getNome();
            if (nomeUsuario == null || nomeUsuario.isBlank()){
                nomeUsuario = usuario.getEmail();
            }
            //Mensagens.sucesso("Bem-vindo "+nomeUsuario);
            //Fecha apenas a tela de login
            dispose();
            // Abre a tela inicial
            new TelaFichasDeTreino();
        } else {
            Mensagens.erro("Login ou senha inválidos.");
        }
    }



}