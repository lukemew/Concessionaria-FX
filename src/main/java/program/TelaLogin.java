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
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;

public class TelaLogin extends Application {

    private TextField txtUsuario;
    private PasswordField txtSenha;
    private RadioButton radioCliente;
    private RadioButton radioVendedor;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login - Concessionária TOPcar");

        // Layout principal com imagem de fundo borrada e escurecida
        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setAlignment(Pos.CENTER);
        layoutPrincipal.setPadding(new Insets(20));

        // Adicionar a imagem de fundo
        ImageView backgroundImageView = new ImageView(new Image("file:src/main/java/imagens/eldorado.png")); // Substitua com o caminho da sua imagem
        backgroundImageView.setFitWidth(800); // Largura da cena
        backgroundImageView.setFitHeight(600); // Altura da cena
        backgroundImageView.setEffect(new GaussianBlur(15)); // Efeito de desfoque na imagem

        // Adicionar uma camada escura sobre a imagem
        StackPane backgroundPane = new StackPane(backgroundImageView);
        backgroundPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.9);");

        // Título
        Label lblCabecalho = new Label("Concessionária TOPcar");
        lblCabecalho.setStyle("-fx-padding: 10; -fx-background-color: rgba(0, 0, 0, 0.5); -fx-background-radius: 10px; -fx-font-size: 30px; -fx-text-fill: yellow; -fx-font-weight: bold;");
        lblCabecalho.setAlignment(Pos.CENTER);


        // Layout para os campos de login
        GridPane gridPane = new GridPane();
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1); -fx-background-radius: 10px;");

        // Campos de usuário e senha
        Label lblUsuario = new Label("Usuário:");
        lblUsuario.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        txtUsuario = new TextField();
        txtUsuario.setStyle("-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-prompt-text-fill: #95a5a6;");

        Label lblSenha = new Label("Senha:");
        lblSenha.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        txtSenha = new PasswordField();
        txtSenha.setStyle("-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-prompt-text-fill: #95a5a6;");

        // Opções de login
        radioCliente = new RadioButton("Cliente");
        radioCliente.setStyle("-fx-text-fill: white;");
        radioVendedor = new RadioButton("Vendedor");
        radioVendedor.setStyle("-fx-text-fill: white;");

        ToggleGroup group = new ToggleGroup();
        radioCliente.setToggleGroup(group);
        radioVendedor.setToggleGroup(group);

        // Botão de login
        Button btnLogin = new Button("Login");
        btnLogin.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-size: 14px;");
        btnLogin.setOnAction(e -> realizarLogin(primaryStage));

        // Adicionando ao grid
        gridPane.add(lblUsuario, 0, 0);
        gridPane.add(txtUsuario, 1, 0);
        gridPane.add(lblSenha, 0, 1);
        gridPane.add(txtSenha, 1, 1);
        gridPane.add(radioCliente, 0, 2);
        gridPane.add(radioVendedor, 1, 2);
        gridPane.add(btnLogin, 1, 3);

        layoutPrincipal.getChildren().addAll(lblCabecalho, gridPane);

        // Empilhar o layout principal e a imagem de fundo
        StackPane root = new StackPane(backgroundPane, layoutPrincipal);
        Scene scene = new Scene(root, 800, 600); // Tamanho maior da janela

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void realizarLogin(Stage primaryStage) {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals("user") && senha.equals("12345")) {
            if (radioCliente.isSelected()) {
                new TelaCliente().start(primaryStage);
            } else if (radioVendedor.isSelected()) {
                new TelaVendedor().start(primaryStage);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuário ou senha incorretos.");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
