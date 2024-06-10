CREATE DATABASE ClinicaMedica;

USE ClinicaMedica;

CREATE TABLE Paciente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100),
    agendar_consulta BOOLEAN DEFAULT FALSE,
    cancelar_consulta BOOLEAN DEFAULT FALSE
);

CREATE TABLE Medico (
    crm VARCHAR(10) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100),
    telefone VARCHAR(15),
    email VARCHAR(100),
    ver_agenda BOOLEAN DEFAULT FALSE,
    atender_consulta BOOLEAN DEFAULT FALSE
);

CREATE TABLE Consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    cpf_paciente VARCHAR(11),
    crm_medico VARCHAR(10),
    confirmar BOOLEAN DEFAULT FALSE,
    cancelar BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (cpf_paciente) REFERENCES Paciente(cpf),
    FOREIGN KEY (crm_medico) REFERENCES Medico(crm)
);

CREATE TABLE Agenda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    crm_medico VARCHAR(10),
    id_consulta INT,
    adicionar_consulta BOOLEAN DEFAULT FALSE,
    remover_consulta BOOLEAN DEFAULT FALSE,
    listar_consultas BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (crm_medico) REFERENCES Medico(crm),
    FOREIGN KEY (id_consulta) REFERENCES Consulta(id)
);
