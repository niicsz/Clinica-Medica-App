import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void incluirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, cpf, idade, email, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setInt(3, usuario.getIdade());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Usuario buscarUsuarioPorCpf(String cpf) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ?";
        Usuario usuario = null;

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                usuario = new Usuario(nome, cpf, idade, email, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
