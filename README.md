
# Cadastro de Clientes – Java JDBC + MySQL

## 📌 Sobre o projeto

Este projeto é um sistema simples de cadastro de clientes desenvolvido em Java usando JDBC para se conectar a um banco de dados MySQL.  
Ele realiza operações completas de **CRUD** (Create, Read, Update, Delete) no banco.

O objetivo é demonstrar competência em:
- programação Java
- persistência de dados com JDBC
- organização de projeto com pacotes
- uso de banco de dados real

---

## 🧱 Funcionalidades

✔ Cadastrar clientes  
✔ Listar clientes  
✔ Atualizar clientes  
✔ Excluir clientes  

---

## 🛠 Tecnologias utilizadas

- Java 17  
- JDBC (Java Database Connectivity)  
- MySQL  
- Maven

---

## 📁 Organização do projeto


---

## 🚀 Como executar

### 1. Clone o projeto

```bash
git clone https://github.com/hyppoliteaurelus/cadastro-cliente-jdbc.git

2. Configure o banco de dados

A partir do MySQL Workbench ou terminal:

CREATE DATABASE banco;
USE banco;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    cpf VARCHAR(11) UNIQUE NOT NULL
);
