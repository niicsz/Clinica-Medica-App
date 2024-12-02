# ClinicaMedicaApp - Sistema de Gestão de Clínica Médica

Este é um sistema simples de gerenciamento para uma clínica médica, com funcionalidades para cadastro de usuários, pacientes, médicos e agendamento de consultas.

## Funcionalidades

- **Cadastro de usuário**: Permite o cadastro de usuários (administradores ou atendentes) com nome, CPF, idade, email e senha.
- **Cadastro de paciente**: Permite o cadastro de pacientes com nome, CPF, idade e email.
- **Cadastro de médico**: Permite o cadastro de médicos com nome e especialidade.
- **Agendamento de consulta**: Permite agendar uma consulta para um paciente com um médico, especificando data e hora da consulta.

## Como Usar

### Passo 1: Compilar e Executar o Projeto

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório onde o projeto está localizado.
3. Compile o código com o comando:
    ```bash
    javac com/mycompany/clinicamedica/ClinicaMedicaApp.java
    ```
4. Execute o programa com o comando:
    ```bash
    java com.mycompany.clinicamedica.ClinicaMedicaApp
    ```

### Passo 2: Interagir com o Sistema

Após executar o programa, o sistema exibirá um menu interativo no terminal com as seguintes opções:

1. **Cadastrar usuário**
2. **Cadastrar paciente**
3. **Cadastrar médico**
4. **Agendar consulta**
5. **Sair**

Escolha uma opção digitando o número correspondente.

### Detalhes das Funcionalidades

#### Cadastro de Usuário

O sistema solicitará informações como nome, CPF, idade, email e senha. Essas informações serão usadas para cadastrar um novo usuário no sistema.

#### Cadastro de Paciente

Você poderá cadastrar um paciente, fornecendo nome, CPF, idade e email. O paciente será registrado no sistema para futuramente agendar consultas.

#### Cadastro de Médico

Será possível cadastrar médicos, informando nome e especialidade. Cada médico será identificado por um ID único gerado pelo sistema.

#### Agendamento de Consulta

Ao agendar uma consulta, o sistema solicitará o CPF do paciente, o ID do médico e a data e hora da consulta no formato `yyyy-MM-dd HH:mm`. O tipo da consulta também será solicitado (ex: Consulta de rotina, emergência, etc).

O sistema validará se o paciente e o médico existem e, em caso positivo, realizará o agendamento da consulta.

## Estrutura do Código

O código está organizado da seguinte maneira:

```
/com
    /mycompany
        /clinicamedica
            ClinicaMedicaApp.java      (Arquivo principal com a lógica do sistema)
            UsuarioService.java        (Classe que gerencia usuários)
            PacienteDAO.java           (Classe para gerenciar os pacientes no banco de dados ou estrutura)
            MedicoDAO.java             (Classe para gerenciar os médicos no banco de dados ou estrutura)
            ConsultaService.java       (Classe para gerenciar o agendamento de consultas)
            Paciente.java              (Modelo de dados para pacientes)
            Medico.java                (Modelo de dados para médicos)
            Usuario.java               (Modelo de dados para usuários)
```

### Descrição das Classes:

- **ClinicaMedicaApp**: Classe principal com a interação do usuário via terminal. Exibe o menu e chama os métodos correspondentes.
- **UsuarioService**: Classe responsável por incluir, editar e gerenciar os usuários do sistema.
- **PacienteDAO**: Classe responsável pela persistência de dados dos pacientes, incluindo a criação, leitura e atualização dos registros.
- **MedicoDAO**: Similar ao `PacienteDAO`, mas para médicos.
- **ConsultaService**: Classe responsável pelo agendamento de consultas, que verifica a disponibilidade do médico e do paciente e faz o agendamento.
- **Paciente**: Modelo de dados que contém as informações do paciente, como nome, CPF, idade e email.
- **Medico**: Modelo de dados que contém as informações do médico, como nome e especialidade.
- **Usuario**: Modelo de dados que contém as informações do usuário (administrador ou atendente), como nome, CPF, idade, email e senha.

## Como Funciona a Lógica de Agendamento de Consulta

1. O usuário entra com o CPF do paciente e o ID do médico para agendar a consulta.
2. O sistema valida se o paciente e o médico existem.
3. Caso ambos existam, o sistema solicita a data e hora da consulta, além do tipo (rotina, emergência, etc.).
4. A consulta é então agendada, e o sistema confirma o agendamento com sucesso.

## Melhorias Futuras

- **Validação de Dados**: Adicionar validações de CPF, email e outras entradas de dados.
- **Interface Gráfica**: Criar uma interface gráfica (GUI) com JavaFX ou Swing para facilitar a interação do usuário.
- **Autenticação de Usuário**: Implementar um sistema de login e autenticação para usuários administrativos.

## Licença

Este projeto é de uso livre. Sinta-se à vontade para modificar e adaptar conforme necessário.
