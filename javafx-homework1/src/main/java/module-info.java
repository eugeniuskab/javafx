module com.example.javafxhomework1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxhomework1 to javafx.fxml;
    exports com.example.javafxhomework1;
}