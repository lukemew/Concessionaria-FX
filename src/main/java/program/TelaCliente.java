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

import java.io.File;
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
        gridVeiculos.setHgap(25);
        gridVeiculos.setVgap(25);
        gridVeiculos.setAlignment(Pos.CENTER);
        gridVeiculos.setStyle("-fx-background-color: #000000; -fx-border-color: #042640");

        // Preenchendo o grid com os veículos
        for (int i = 0; i < listaVeiculos.size(); i++) {
            Veiculo veiculo = listaVeiculos.get(i);

            // Obtém a imagem do veículo com base no modelo
            ImageView imgView = new ImageView(obterImagemVeiculo(veiculo.getModelo()));
            imgView.setFitWidth(180);
            imgView.setFitHeight(100);

            // Detalhes do carro
            Label lblCarro = new Label(veiculo.getModelo() + "\nCor: " + veiculo.getCor() + "\nAno: " + veiculo.getAno() + "\nR$ " + veiculo.getPreco());
            lblCarro.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

            // Botão de agendamento de test drive
            Button btnTestDrive = new Button("Test Drive");
            btnTestDrive.setStyle("-fx-background-color: #ece70f; -fx-text-fill: #000000;");
            btnTestDrive.setOnAction(e -> agendarTestDrive(veiculo));

            Button btnComprar = new Button("Comprar");
            btnComprar.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
            btnComprar.setOnAction(e -> comprarVeiculo(veiculo));

            // Adicionando ao grid
            VBox veiculoBox = new VBox(10, imgView, lblCarro, btnTestDrive, btnComprar);
            veiculoBox.setAlignment(Pos.CENTER);
            veiculoBox.setStyle("-fx-background-color: #042640; -fx-padding: 10; -fx-background-radius: 10;");

            gridVeiculos.add(veiculoBox, i % 3, i / 3); // Coloca 3 veículos por linha
        }

        // ScrollPane para permitir rolagem se necessário
        ScrollPane scrollPane = new ScrollPane(gridVeiculos);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent;");

        // Botão sair
        Button btnSair = new Button("Sair");
        btnSair.setStyle("-fx-background-color: black; -fx-text-fill: yellow;");
        btnSair.setOnAction(e -> {
            new TelaLogin().start(new Stage());
            primaryStage.close();
        });

        // Layout final com espaçamento e fundo escuro
        VBox layoutFinal = new VBox(20, lblCabecalho, scrollPane, btnSair);
        layoutFinal.setAlignment(Pos.TOP_CENTER);
        layoutFinal.setPadding(new Insets(20));
        layoutFinal.setStyle("-fx-background-color: #1e1e1e;"); // Garantindo fundo escuro em toda a tela

        Scene scene = new Scene(layoutFinal, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Image obterImagemVeiculo(String modelo) {
        // Caminho base para as imagens
        String caminhoBase = "src/main/java/imagens/";

        // Nome do arquivo da imagem com base no modelo do veículo
        String caminhoImagem = caminhoBase + modelo.toLowerCase().replace(" ", "_") + ".png";

        // Verifica se o arquivo existe
        File arquivoImagem = new File(caminhoImagem);
        if (arquivoImagem.exists()) {
            return new Image("file:" + caminhoImagem);
        } else {
            // Retorna uma imagem padrão caso o arquivo não exista
            return new Image("file:" + caminhoBase + "imagem_padrao.png");
        }
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

    private void comprarVeiculo(Veiculo veiculo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comprar veículo");
        alert.setHeaderText(null);
        alert.setContentText("Você deseja comprar o veículo " + veiculo.getModelo() + " por " + veiculo.getPreco() + "?");

        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK) {
                new Alert(Alert.AlertType.INFORMATION, "Veículo comprado com sucesso \n\nAguarde o envio, agradecemos sua preferência!").showAndWait();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
