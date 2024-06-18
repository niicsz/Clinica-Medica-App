package com.mycompany.clinicamedica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicaMedicaApp {

    private static UsuarioService usuarioService = new UsuarioService();
    private static PacienteDAO pacienteDAO = new PacienteDAO();
    private static MedicoDAO medicoDAO = new MedicoDAO();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Cadastrar paciente");
            System.out.println("3. Cadastrar médico");
            System.out.println("4. Agendar consulta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    cadastrarPaciente(scanner);
                    break;
                case 3:
                    cadastrarMedico(scanner);
                    break;
                case 4:
                    agendarConsulta(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  

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

    private static void cadastrarPaciente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setIdade(idade);
        paciente.setEmail(email);

        pacienteDAO.incluirPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void cadastrarMedico(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setEspecialidade(especialidade);

        medicoDAO.incluirMedico(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }

    private static void agendarConsulta(Scanner scanner) {
        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("ID do médico: ");
        int medicoId = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Data e hora da consulta (yyyy-MM-dd HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Paciente paciente = pacienteDAO.buscarPacientePorCpf(cpf);
        Medico medico = medicoDAO.buscarMedicoPorId(medicoId);

        if (paciente != null && medico != null) {
            System.out.print("Tipo de consulta: ");
            String tipoConsulta = scanner.nextLine();

            consultaService.agendarConsulta(paciente, medico, dataHora, tipoConsulta);
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Paciente ou médico não encontrado.");
        }
    }
}
