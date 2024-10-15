package program;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Veiculo;
import model.dao.impl.VeiculoDaoJDBC;
import db.DB;

import java.util.List;

public class TelaVendedor extends Application {

    private ComboBox<String> comboVeiculos;
    private TextField txtModelo, txtAno, txtCor, txtPreco;
    private Button btnAdicionar, btnEditar, btnDeletar, btnSair;
    private VeiculoDaoJDBC veiculoDao;
    private List<Veiculo> listaVeiculos;

    @Override
    public void start(Stage primaryStage) {
        veiculoDao = new VeiculoDaoJDBC(DB.getConnection());
        listaVeiculos = veiculoDao.buscarTodosVeiculos(); 

        primaryStage.setTitle("Área do Vendedor - Concessionária TOPcar");

        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #1e1e1e;"); 

        
        GridPane panelForm = new GridPane();
        panelForm.setHgap(10);
        panelForm.setVgap(10);
        panelForm.setPadding(new Insets(20));
        panelForm.setStyle("-fx-background-color: #042640; -fx-background-radius: 10;"); 

        
        Label lblSelecionar = new Label("Selecionar Veículo:");
        lblSelecionar.setStyle("-fx-text-fill: white;");
        comboVeiculos = new ComboBox<>();
        carregarVeiculosNoComboBox(); 
        comboVeiculos.setOnAction(e -> carregarDadosVeiculoSelecionado());

       
        Label lblModelo = new Label("Modelo:");
        lblModelo.setStyle("-fx-text-fill: white;");
        txtModelo = new TextField();

        Label lblAno = new Label("Ano:");
        lblAno.setStyle("-fx-text-fill: white;");
        txtAno = new TextField();

        Label lblCor = new Label("Cor:");
        lblCor.setStyle("-fx-text-fill: white;");
        txtCor = new TextField();

        Label lblPreco = new Label("Preço:");
        lblPreco.setStyle("-fx-text-fill: white;");
        txtPreco = new TextField();

        panelForm.add(lblSelecionar, 0, 0);
        panelForm.add(comboVeiculos, 1, 0);
        panelForm.add(lblModelo, 0, 1);
        panelForm.add(txtModelo, 1, 1);
        panelForm.add(lblAno, 0, 2);
        panelForm.add(txtAno, 1, 2);
        panelForm.add(lblCor, 0, 3);
        panelForm.add(txtCor, 1, 3);
        panelForm.add(lblPreco, 0, 4);
        panelForm.add(txtPreco, 1, 4);

        
        HBox panelButtons = new HBox(10);
        panelButtons.setPadding(new Insets(20, 10, 0, 0));
        panelButtons.setStyle(" -fx-background-radius: 10;"); 
        panelButtons.setSpacing(10);

        
        btnAdicionar = new Button("Adicionar Veículo");
        btnAdicionar.setStyle("-fx-background-color: black; -fx-text-fill: yellow; -fx-background-radius: 10;");
        btnAdicionar.setOnAction(e -> adicionarVeiculo()); 

        
        btnEditar = new Button("Editar Veículo");
        btnEditar.setStyle("-fx-background-color: black; -fx-text-fill: orange; -fx-background-radius: 10; ");
        btnEditar.setOnAction(e -> editarVeiculo()); 

        
        btnDeletar = new Button("Deletar Veículo");
        btnDeletar.setStyle("-fx-background-color: black; -fx-text-fill: red; -fx-background-radius: 10; ");
        btnDeletar.setOnAction(e -> deletarVeiculo()); 

        
        btnSair = new Button("Sair");
        btnSair.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 10; ");
        btnSair.setOnAction(e -> {
            new TelaLogin().start(new Stage());
            primaryStage.close();
        });

        panelButtons.getChildren().addAll(btnAdicionar, btnEditar, btnDeletar, btnSair);

        root.setCenter(panelForm);
        root.setBottom(panelButtons);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private void carregarVeiculosNoComboBox() {
        comboVeiculos.getItems().clear(); 
        for (Veiculo veiculo : listaVeiculos) {
            comboVeiculos.getItems().add(veiculo.getModelo()); 
        }
    }

   
    private void carregarDadosVeiculoSelecionado() {
        int index = comboVeiculos.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Veiculo veiculoSelecionado = listaVeiculos.get(index);
            txtModelo.setText(veiculoSelecionado.getModelo());
            txtAno.setText(String.valueOf(veiculoSelecionado.getAno()));
            txtCor.setText(veiculoSelecionado.getCor());
            txtPreco.setText(String.valueOf(veiculoSelecionado.getPreco()));
        }
    }

    
    private void adicionarVeiculo() {
        try {
            int ano = Integer.parseInt(txtAno.getText());
            String modelo = txtModelo.getText();
            String cor = txtCor.getText();
            double preco = Double.parseDouble(txtPreco.getText());

            Veiculo veiculo = new Veiculo(ano, modelo, cor, preco);
            veiculoDao.adicionarVeiculo(veiculo); 

            showAlert("Sucesso", "Veículo adicionado com sucesso!", Alert.AlertType.INFORMATION);
            listaVeiculos = veiculoDao.buscarTodosVeiculos(); 
            carregarVeiculosNoComboBox(); 
        } catch (NumberFormatException e) {
            showAlert("Erro", "Por favor, insira um ano válido.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            showAlert("Erro", "Erro ao adicionar veículo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    
    private void editarVeiculo() {
        int index = comboVeiculos.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            try {
                int ano = Integer.parseInt(txtAno.getText());
                String modelo = txtModelo.getText();
                String cor = txtCor.getText();

                Veiculo veiculo = listaVeiculos.get(index);
                veiculo.setAno(ano);
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);

                veiculoDao.atualizarVeiculo(veiculo); 

                showAlert("Sucesso", "Veículo atualizado com sucesso!", Alert.AlertType.INFORMATION);
                listaVeiculos = veiculoDao.buscarTodosVeiculos(); 
                carregarVeiculosNoComboBox(); 
            } catch (NumberFormatException e) {
                showAlert("Erro", "Por favor, insira um ano válido.", Alert.AlertType.ERROR);
            } catch (Exception e) {
                showAlert("Erro", "Erro ao editar veículo: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    
    private void deletarVeiculo() {
        int index = comboVeiculos.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            String modelo = listaVeiculos.get(index).getModelo();

            veiculoDao.deletarVeiculoPelaCor(modelo); 
            showAlert("Sucesso", "Veículo deletado com sucesso!", Alert.AlertType.INFORMATION);
            listaVeiculos = veiculoDao.buscarTodosVeiculos(); 
            carregarVeiculosNoComboBox(); 
        } else {
            showAlert("Erro", "Por favor, selecione o modelo do veículo a ser deletado.", Alert.AlertType.ERROR);
        }
    }

   
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
