module com.example.concessionariafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.concessionariafx to javafx.fxml;
    exports com.example.concessionariafx;
}