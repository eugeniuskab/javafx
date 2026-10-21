module com.example.seminar52 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar52 to javafx.fxml;
    exports com.example.seminar52;
}