package com.mycompany.clinicamedica;

import java.time.LocalDateTime;

public class ConsultaService {
    private ConsultaDAO consultaDAO;

    public ConsultaService() {
        this.consultaDAO = new ConsultaDAO();
    }

    public void agendarConsulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String tipoConsulta) {
        Consulta consulta = new Consulta(paciente, medico, dataHora, tipoConsulta);
        consultaDAO.agendarConsulta(consulta);
    }
}
