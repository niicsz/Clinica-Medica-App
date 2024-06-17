import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    public void agendarConsulta(Consulta consulta) {
        String sql = "INSERT INTO consultas (cpf_paciente, cpf_medico, data_hora, tipo_consulta) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, consulta.getPaciente().getCpf());
            stmt.setString(2, consulta.getMedico().getCpf());
            stmt.setObject(3, consulta.getDataHora());
            stmt.setString(4, consulta.getTipoConsulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> consultasPorMedico(Medico medico) {
        String sql = "SELECT * FROM consultas WHERE cpf_medico = ?";
        List<Consulta> consultas = new ArrayList<>();

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, medico.getCpf());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String cpfPaciente = rs.getString("cpf_paciente");
                LocalDateTime dataHora = rs.getObject("data_hora", LocalDateTime.class);
                String tipoConsulta = rs.getString("tipo_consulta");

                Paciente paciente = new PacienteDAO().buscarPacientePorCpf(cpfPaciente);
                Consulta consulta = new Consulta(paciente, medico, dataHora, tipoConsulta);
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}
