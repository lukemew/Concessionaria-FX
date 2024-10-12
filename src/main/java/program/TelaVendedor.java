package program;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Veiculo;
import model.dao.impl.VeiculoDaoJDBC;
import db.DB;

public class TelaVendedorFX extends Application {

    private TextField txtModelo, txtAno, txtCor;
    private VeiculoDaoJDBC veiculoDao;

    @Override
    public void start(Stage primaryStage) {
        veiculoDao = new VeiculoDaoJDBC(DB.getConnection());

        // Criação dos componentes
        Label lblModelo = new Label("Modelo:");
        txtModelo = new TextField();

        Label lblAno = new Label("Ano:");
        txtAno = new TextField();

        Label lblCor = new Label("Cor:");
        txtCor = new TextField();

        Button btnAdicionar = new Button("Adicionar Veículo");
        btnAdicionar.setOnAction(e -> adicionarVeiculo());

        // Layout
        GridPane grid = new GridPane();
        grid.add(lblModelo, 0, 0);
        grid.add(txtModelo, 1, 0);
        grid.add(lblAno, 0, 1);
        grid.add(txtAno, 1, 1);
        grid.add(lblCor, 0, 2);
        grid.add(txtCor, 1, 2);
        grid.add(btnAdicionar, 1, 3);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setTitle("Área do Vendedor - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para adicionar veículo
    private void adicionarVeiculo() {
        try {
            int ano = Integer.parseInt(txtAno.getText());
            String modelo = txtModelo.getText();
            String cor = txtCor.getText();

            Veiculo veiculo = new Veiculo(ano, modelo, cor);
            veiculoDao.adicionarVeiculo(veiculo);

            System.out.println("Veículo adicionado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um ano válido.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
