module com.example.seminar42 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar42 to javafx.fxml;
    exports com.example.seminar42;
}