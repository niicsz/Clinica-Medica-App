package com.mycompany.clinicamedica;

public class Medico {
    private String crm;
    private String nome;
    private String especialidade;
    private String telefone;
    private String email;
    private boolean verAgenda;
    private boolean atenderConsulta;

    public Medico(String crm, String nome, String especialidade, String telefone, String email, boolean verAgenda, boolean atenderConsulta) {
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        this.verAgenda = verAgenda;
        this.atenderConsulta = atenderConsulta;
    }

    // Getters e Setters
    public String getCrm() {
        return crm;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerAgenda() {
        return verAgenda;
    }

    public boolean isAtenderConsulta() {
        return atenderConsulta;
    }
}
