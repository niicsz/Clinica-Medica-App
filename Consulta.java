import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private String tipoConsulta;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String tipoConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.tipoConsulta = tipoConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
}
