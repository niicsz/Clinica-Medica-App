CREATE DATABASE clinica_medica;

USE clinica_medica;

CREATE TABLE usuarios (
    cpf VARCHAR(11) NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    tipo_usuario ENUM('PACIENTE', 'MEDICO') NOT NULL
);

CREATE TABLE consultas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf_paciente VARCHAR(11) NOT NULL,
    cpf_medico VARCHAR(11) NOT NULL,
    data_hora DATETIME NOT NULL,
    tipo_consulta VARCHAR(50) NOT NULL,
    FOREIGN KEY (cpf_paciente) REFERENCES usuarios(cpf),
    FOREIGN KEY (cpf_medico) REFERENCES usuarios(cpf)
);

INSERT INTO usuarios (cpf, nome, idade, email, senha, tipo_usuario) VALUES 
('12345678901', 'João Silva', 30, 'joao.silva@example.com', 'senha123', 'PACIENTE'),
('10987654321', 'Maria Oliveira', 45, 'maria.oliveira@example.com', 'senha456', 'MEDICO');

INSERT INTO consultas (cpf_paciente, cpf_medico, data_hora, tipo_consulta) VALUES 
('12345678901', '10987654321', '2024-06-18 10:00:00', 'Hemograma');