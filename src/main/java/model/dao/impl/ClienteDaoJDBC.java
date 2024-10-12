package model.dao.impl;
import model.dao.ClienteDao;

import db.DB;
import model.dao.ClienteDao;
import model.dao.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDaoJDBC implements ClienteDao {

    private Connection conn;

    public ClienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    public void adicionarCliente(Cliente cliente) {

        PreparedStatement st = null;
        String sql = "INSERT INTO clientes (nome, idade, email, telefone ) VALUES (?, ?, ?, ?)";

        try {
        st = conn.prepareStatement(sql);

        st.setString(1, cliente.getNome());
        st.setInt(2, cliente.getIdade());
        st.setString(3, cliente.getEmail());
        st.setString(4, cliente.getTelefone());

        int rowsAffected = st.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Feito! linhas geradas: " + rowsAffected);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
    }

    public void deletarClientePeloEmail(String email){
        PreparedStatement st = null;
        String sql = "DELETE FROM clientes WHERE email = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, email);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente com email " + email + " deletado com sucesso.");
            } else {
                System.out.println("Nenhum cliente encontrado com o email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
    }

    public Cliente encontrarClientePorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM clientes WHERE nome = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, nome);

            rs = st.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }
}
