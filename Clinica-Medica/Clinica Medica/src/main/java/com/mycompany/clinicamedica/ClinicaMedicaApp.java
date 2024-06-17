package com.mycompany.clinicamedica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicaMedicaApp {

    private static UsuarioService usuarioService = new UsuarioService();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Agendar consulta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    agendarConsulta(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setIdade(idade);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        usuarioService.incluirUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void agendarConsulta(Scanner scanner) {
        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("ID do médico: ");
        int medicoId = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Data e hora da consulta (yyyy-MM-dd HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        PacienteDAO pacienteDAO = new PacienteDAO();
        MedicoDAO medicoDAO = new MedicoDAO();

        Paciente paciente = pacienteDAO.buscarPacientePorCpf(cpf);
        Medico medico = medicoDAO.buscarMedicoPorId(medicoId);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        consultaService.agendarConsulta(paciente, medico, dataHora, "Hemograma");
        System.out.println("Consulta agendada com sucesso!");
    }
}
