package dao;

import connection.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario autenticar(String login, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email=? AND senha=?";
        try (
                Connection conexao = ConnectionFactory.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivelAcesso(rs.getString("nivel_acesso"));

                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
