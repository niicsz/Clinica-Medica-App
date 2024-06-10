package com.mycompany.clinicamedica;

public class MedicoService {

    public void adicionarMedico(Medico medico) {
        String sql = "INSERT INTO Medico (crm, nome, especialidade, telefone, email, ver_agenda, atender_consulta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setString(4, medico.getTelefone());
            stmt.setString(5, medico.getEmail());
            stmt.setBoolean(6, medico.isVerAgenda());
            stmt.setBoolean(7, medico.isAtenderConsulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medico buscarMedicoPorCrm(String crm) {
        String sql = "SELECT * FROM Medico WHERE crm = ?";
        Medico medico = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, crm);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                medico = new Medico();
                medico.setCrm(rs.getString("crm"));
                medico.setNome(rs.getString("nome"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setEmail(rs.getString("email"));
                medico.setVerAgenda(rs.getBoolean("ver_agenda"));
                medico.setAtenderConsulta(rs.getBoolean("atender_consulta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

}