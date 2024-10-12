package model.dao.impl;

import db.DB;
import db.DbException;
import model.Veiculo;
import model.dao.VeiculoDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDaoJDBC implements VeiculoDao {

    private Connection conn;

    public VeiculoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO veiculos (modelo, ano, cor) VALUES (?, ?, ?)",  // Mudança no nome da tabela
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, veiculo.getModelo());
            st.setInt(2, veiculo.getAno());
            st.setString(3, veiculo.getCor());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Veículo adicionado com sucesso!");
            } else {
                throw new DbException("Erro inesperado! Nenhuma linha foi afetada.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Veiculo encontrarVeiculoPorModelo(String modelo) {
        return null;
    }

    @Override
    public void deletarVeiculoPelaCor(String modelo) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM veiculos WHERE modelo = ?");  // Mudança no nome da tabela

            st.setString(1, modelo);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected == 0) {
                throw new DbException("Erro: Nenhum veículo encontrado com o modelo fornecido.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM veiculos ORDER BY modelo");  // Mudança no nome da tabela

            rs = st.executeQuery();

            List<Veiculo> list = new ArrayList<>();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setCor(rs.getString("cor"));
                list.add(veiculo);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


    public void atualizarVeiculo(Veiculo veiculo) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE veiculos "  // Mudança no nome da tabela
                            + "SET ano = ?, cor = ? "
                            + "WHERE modelo = ?");

            st.setInt(1, veiculo.getAno());
            st.setString(2, veiculo.getCor());
            st.setString(3, veiculo.getModelo());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Veículo atualizado com sucesso!");
            } else {
                System.out.println("Erro: Nenhum veículo encontrado com o modelo fornecido.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }
}
