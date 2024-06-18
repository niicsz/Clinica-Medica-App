package com.mycompany.clinicamedica;

import java.time.LocalDateTime;

public class ConsultaService {

    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public void agendarConsulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String tipoConsulta) {
        Consulta consulta = new Consulta(paciente, medico, dataHora, tipoConsulta);
        consultaDAO.incluirConsulta(consulta);
    }
}
