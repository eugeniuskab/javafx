module com.example.seminar3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar3 to javafx.fxml;
    exports com.example.seminar3;
}