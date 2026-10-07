module com.example.seminar31 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar31 to javafx.fxml;
    exports com.example.seminar31;
}