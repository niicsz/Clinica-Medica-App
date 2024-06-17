import java.time.LocalDateTime;
import java.util.Scanner;

public class ClinicaMedicaApp {
    private static UsuarioService usuarioService = new UsuarioService();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo à Clínica Médica Doc Lab");

        while (true) {
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Agendar Consulta");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    agendarConsulta(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.println("Cadastro de Usuário");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();

        Usuario usuario = new Usuario(nome, cpf, idade, email, senha);
        usuarioService.incluirUsuario(usuario);
    }

    private static void agendarConsulta(Scanner scanner) {
        System.out.println("Agendamento de Consulta");
        System.out.print("CPF do Paciente: ");
        String cpfPaciente = scanner.next();
        System.out.print("CRM do Médico: ");
        String cpfMedico = scanner.next();
        System.out.print("Data e Hora (AAAA-MM-DDTHH:MM): ");
        String dataHoraStr = scanner.next();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr);

        Paciente paciente = usuarioService.buscarPacientePorCpf(cpfPaciente);
        Medico medico = usuarioService.buscarMedicoPorCpf(cpfMedico);

        consultaService.agendarConsulta(paciente, medico, dataHora);
    }
}
