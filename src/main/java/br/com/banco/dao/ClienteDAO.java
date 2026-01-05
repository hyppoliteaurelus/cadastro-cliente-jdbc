package br.com.banco.dao;

import br.com.banco.config.ConexaoMYSQL;
import br.com.banco.model.Cliente;
import com.mysql.cj.xdevapi.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERIR CLIENTE
    public void salvar(Cliente cliente){
        String sql ="INSERT INTO clientes (nome, email, cpf) values(?, ?, ?)";

        try (Connection conn = ConexaoMYSQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());

            stmt.executeUpdate();


            // Pegar ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                cliente.setId(rs.getInt(1));
            }

            System.out.println("Cliente salvo com sucesso!");


        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente.");
            e.printStackTrace();
        }
    }


    // LISTAR TODOS CLIENTES
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConexaoMYSQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getString("cpf"));
                clientes.add(c);
            }

        } catch (SQLException e ){
            System.out.println("Erro ao listar clientes.");
            e.printStackTrace();
        }

        return clientes;
    }
    // FUTURO: ATUALIZAR, EXCLUIR

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, cpf = ? WHERE id = ?";

        try (Connection conn = ConexaoMYSQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setInt(4, cliente.getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente.");
            e.printStackTrace();
        }
    }

    // ========================
    // DELETE - Excluir cliente
    // ========================
    public void excluir(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = ConexaoMYSQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente.");
            e.printStackTrace();
        }
    }
}

