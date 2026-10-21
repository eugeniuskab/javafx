module com.example.seminar51 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar51 to javafx.fxml;
    exports com.example.seminar51;
}