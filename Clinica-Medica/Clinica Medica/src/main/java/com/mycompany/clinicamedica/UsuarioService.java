public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void incluirUsuario(Usuario usuario) {
        usuarioDAO.incluirUsuario(usuario);
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        return (Paciente) usuarioDAO.buscarUsuarioPorCpf(cpf);
    }

    public Medico buscarMedicoPorCpf(String cpf) {
        return (Medico) usuarioDAO.buscarUsuarioPorCpf(cpf);
    }

}
