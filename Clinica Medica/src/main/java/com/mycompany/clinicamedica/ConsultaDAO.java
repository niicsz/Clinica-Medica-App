package com.mycompany.clinicamedica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {

    public void incluirConsulta(Consulta consulta) {
        String sql = "INSERT INTO consultas (paciente_id, medico_id, data_hora, tipo_consulta) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getPaciente().getId());
            stmt.setInt(2, consulta.getMedico().getId());
            stmt.setObject(3, consulta.getDataHora());
            stmt.setString(4, consulta.getTipoConsulta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao incluir consulta", e);
        }
    }
}
