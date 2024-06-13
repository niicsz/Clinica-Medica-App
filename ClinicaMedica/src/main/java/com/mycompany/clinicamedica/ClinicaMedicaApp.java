package com.mycompany.clinicamedica;

import java.util.Scanner;

public class ClinicaMedicaApp {
    private static PacienteService pacienteService = new PacienteService();
    private static MedicoService medicoService = new MedicoService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem-vindo à Clínica Médica");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Buscar Paciente por CPF");
            System.out.println("3. Adicionar Médico");
            System.out.println("4. Buscar Médico por CRM");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarPaciente(scanner);
                    break;
                case 2:
                    buscarPaciente(scanner);
                    break;
                case 3:
                    adicionarMedico(scanner);
                    break;
                case 4:
                    buscarMedico(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarPaciente(Scanner scanner) {
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o Nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite a Idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();     
        System.out.println("Digite o Telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o Email:");
        String email = scanner.nextLine();

        Paciente paciente = new Paciente(cpf, nome, idade, telefone, email, false, false);
        pacienteService.adicionarPaciente(paciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    private static void buscarPaciente(Scanner scanner) {
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        Paciente paciente = pacienteService.buscarPacientePorCpf(cpf);
        if (paciente != null) {
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Idade: " + paciente.getIdade());
            System.out.println("Telefone: " + paciente.getTelefone());
            System.out.println("Email: " + paciente.getEmail());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void adicionarMedico(Scanner scanner) {
        System.out.println("Digite o CRM:");
        String crm = scanner.nextLine();
        System.out.println("Digite o Nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite a Especialidade:");
        String especialidade = scanner.nextLine();
        System.out.println("Digite o Telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o Email:");
        String email = scanner.nextLine();

        Medico medico = new Medico(crm, nome, especialidade, telefone, email, false, false);
        medicoService.adicionarMedico(medico);
        System.out.println("Médico adicionado com sucesso!");
    }

    private static void buscarMedico(Scanner scanner) {
        System.out.println("Digite o CRM:");
        String crm = scanner.nextLine();
        Medico medico = medicoService.buscarMedicoPorCrm(crm);
        if (medico != null) {
            System.out.println("Nome: " + medico.getNome());
            System.out.println("Especialidade: " + medico.getEspecialidade());
            System.out.println("Telefone: " + medico.getTelefone());
            System.out.println("Email: " + medico.getEmail());
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}
