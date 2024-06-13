package com.mycompany.clinicamedica;

public class Paciente {
    private String cpf;
    private String nome;
    private int idade;
    private String telefone;
    private String email;
    private boolean agendarConsulta;
    private boolean cancelarConsulta;

    public Paciente(String cpf, String nome, int idade, String telefone, String email, boolean agendarConsulta, boolean cancelarConsulta) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.agendarConsulta = agendarConsulta;
        this.cancelarConsulta = cancelarConsulta;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAgendarConsulta() {
        return agendarConsulta;
    }

    public boolean isCancelarConsulta() {
        return cancelarConsulta;
    }
}
