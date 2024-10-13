module com.example.concessionariafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;

    opens program to javafx.graphics;
    exports program; // Exporte o pacote onde suas telas estão
}
