package program;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class TelaCliente extends Application {

    private VeiculoDaoJDBC veiculoDao;
    private List<Veiculo> listaVeiculos;

    @Override
    public void start(Stage primaryStage) {
        // Configurando conexão com o banco e buscando veículos
        veiculoDao = new VeiculoDaoJDBC(DB.getConnection());
        listaVeiculos = veiculoDao.buscarTodosVeiculos();

        primaryStage.setTitle("Área do Cliente - Concessionária TOPcar");

        // Layout principal com fundo escuro
        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setAlignment(Pos.TOP_CENTER);
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.setStyle("-fx-background-color: #1e1e1e;"); // Fundo totalmente escuro

        // Título "Concessionária TOPcar"
        Label lblCabecalho = new Label("Concessionária TOPcar");
        lblCabecalho.setStyle("-fx-font-size: 30px; -fx-text-fill: yellow; -fx-font-weight: bold;");
        lblCabecalho.setAlignment(Pos.CENTER);

        // Grid para exibição dos veículos
        GridPane gridVeiculos = new GridPane();
        gridVeiculos.setHgap(20);
        gridVeiculos.setVgap(20);
        gridVeiculos.setAlignment(Pos.CENTER);

        // Caminhos das imagens (ajuste conforme necessário)
        String[] imagens = {
                "src/main/java/imagens/bmw_serie3.png",
                "src/main/java/imagens/chevrolet_camaro.png",
                "src/main/java/imagens/ford_mustang.png",
                "src/main/java/imagens/toyotacorolla.png",
                "src/main/java/imagens/mercedes-benz_classe_c.png",
                "src/main/java/imagens/honda_civic2.png"
        };

        // Preenchendo o grid com os veículos
        for (int i = 0; i < listaVeiculos.size(); i++) {
            Veiculo veiculo = listaVeiculos.get(i);

            // Imagem do veículo
            ImageView imgView = new ImageView(new Image("file:" + imagens[i]));
            imgView.setFitWidth(150);
            imgView.setFitHeight(100);

            // Detalhes do carro
            Label lblCarro = new Label(veiculo.getModelo() + "\nCor: " + veiculo.getCor() + "\nAno: " + veiculo.getAno());
            lblCarro.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

            // Botão de agendamento de test drive
            Button btnTestDrive = new Button("Test Drive");
            btnTestDrive.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
            btnTestDrive.setOnAction(e -> agendarTestDrive(veiculo));

            // Adicionando ao grid
            VBox veiculoBox = new VBox(10, imgView, lblCarro, btnTestDrive);
            veiculoBox.setAlignment(Pos.CENTER);
            veiculoBox.setStyle("-fx-background-color: #2c3e50; -fx-padding: 10; -fx-background-radius: 10;"); // Fundo escuro para cada veículo

            gridVeiculos.add(veiculoBox, i % 3, i / 3); // Coloca 3 veículos por linha
        }

        // ScrollPane para permitir rolagem se necessário
        ScrollPane scrollPane = new ScrollPane(gridVeiculos);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent;");

        // Botão sair
        Button btnSair = new Button("Sair");
        btnSair.setStyle("-fx-background-color: black; -fx-text-fill: yellow;");
        btnSair.setOnAction(e -> primaryStage.close());

        // Layout final com espaçamento e fundo escuro
        VBox layoutFinal = new VBox(20, lblCabecalho, scrollPane, btnSair);
        layoutFinal.setAlignment(Pos.TOP_CENTER);
        layoutFinal.setPadding(new Insets(20));
        layoutFinal.setStyle("-fx-background-color: #1e1e1e;"); // Garantindo fundo escuro em toda a tela

        Scene scene = new Scene(layoutFinal, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agendarTestDrive(Veiculo veiculo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Agendar Test Drive");
        alert.setHeaderText(null);
        alert.setContentText("Deseja agendar um test drive para o " + veiculo.getModelo() + "?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                new Alert(Alert.AlertType.INFORMATION, "Test Drive agendado com sucesso!").showAndWait();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
