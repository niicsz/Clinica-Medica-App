package com.mycompany.clinicamedica;

public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void incluirUsuario(Usuario usuario) {
        usuarioDAO.incluirUsuario(usuario);
    }
}
