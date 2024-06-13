package com.mycompany.clinicamedica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteService {

    public void adicionarPaciente(Paciente paciente) {
        String sql = "INSERT INTO Paciente (cpf, nome, idade, telefone, email, agendar_consulta, cancelar_consulta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getCpf());
            stmt.setString(2, paciente.getNome());
            stmt.setInt(3, paciente.getIdade());
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getEmail());
            stmt.setBoolean(6, paciente.isAgendarConsulta());
            stmt.setBoolean(7, paciente.isCancelarConsulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        String sql = "SELECT * FROM Paciente WHERE cpf = ?";
        Paciente paciente = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getBoolean("agendar_consulta"),
                    rs.getBoolean("cancelar_consulta")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

}
