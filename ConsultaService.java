import java.time.LocalDateTime;
import java.util.List;

public class ConsultaService {
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public void agendarConsulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        Consulta consulta = new Consulta(paciente, medico, dataHora, "Hemograma");
        consultaDAO.agendarConsulta(consulta);
    }

    public List<Consulta> listarConsultas(Medico medico) {
        return consultaDAO.consultasPorMedico(medico);
    }

}
