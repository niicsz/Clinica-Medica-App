package com.mycompany.clinicamedica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultaDAO {
    private Connection connection;

    public ConsultaDAO() {
        this.connection = ConexaoBD.getConnection();
    }

    public void agendarConsulta(Consulta consulta) {
        String sql = "INSERT INTO consultas (paciente_id, medico_id, data_hora, tipo_consulta) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, consulta.getPaciente().getId());
            stmt.setInt(2, consulta.getMedico().getId());
            stmt.setString(3, consulta.getDataHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            stmt.setString(4, consulta.getTipoConsulta());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Consulta buscarConsultaPorId(int id) {
        String sql = "SELECT * FROM consultas WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PacienteDAO pacienteDAO = new PacienteDAO();
                MedicoDAO medicoDAO = new MedicoDAO();
                Paciente paciente = pacienteDAO.buscarPacientePorId(rs.getInt("paciente_id"));
                Medico medico = medicoDAO.buscarMedicoPorId(rs.getInt("medico_id"));
                LocalDateTime dataHora = LocalDateTime.parse(rs.getString("data_hora"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String tipoConsulta = rs.getString("tipo_consulta");
                Consulta consulta = new Consulta(paciente, medico, dataHora, tipoConsulta);
                consulta.setId(rs.getInt("id"));
                return consulta;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
