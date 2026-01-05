package br.com.banco.app;

import br.com.banco.config.ConexaoMYSQL;
import br.com.banco.dao.ClienteDAO;
import br.com.banco.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO(); // nossa classe de acesso ao banco

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE CADASTRO DE CLIENTES ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar clientes");
            System.out.println("4 - Excluir clientes");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();


                    // 🔒 Validação simples de CPF
                    if (cpf.length() != 11) {
                        System.out.println("CPF inválido. Deve conter 11 números.");
                        break; // volta para o menu
                    }


                    Cliente cliente = new Cliente(nome, email, cpf);
                    clienteDAO.salvar(cliente);
                }
                case 2 -> {
                    List<Cliente> clientes = clienteDAO.listarTodos();
                    System.out.println("\n=== LISTA DE CLIENTES ===");

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println("ID: " + c.getId() +
                                    " | Nome: " + c.getNome() +
                                    " | Email: " + c.getEmail() +
                                    " | CPF: " + c.getCpf());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\n=== ATUALIZAR CLIENTE ===");

                    System.out.print("Informe o ID do cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String email = scanner.nextLine();

                    System.out.print("Novo CPF: ");
                    String cpf = scanner.nextLine();

                    // validação simples
                    if (cpf.length() != 11) {
                        System.out.println("CPF inválido. Deve conter 11 números.");
                        break;
                    }

                    Cliente cliente = new Cliente(nome, email, cpf);
                    cliente.setId(id);

                    clienteDAO.atualizar(cliente);
                }


                case 4 -> {
                    System.out.println("\n=== EXCLUIR CLIENTE ===");

                    System.out.print("Informe o ID do cliente a ser excluído: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    System.out.print("Tem certeza que deseja excluir? (S/N): ");
                    String confirmacao = scanner.nextLine();

                    if (confirmacao.equalsIgnoreCase("S")) {
                        clienteDAO.excluir(id);
                    } else {
                        System.out.println("Exclusão cancelada.");
                    }
                }

                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }


        } while (opcao != 0);

        scanner.close();
    }
}







