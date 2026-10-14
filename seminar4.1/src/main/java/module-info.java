module com.example.seminar41 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar41 to javafx.fxml;
    exports com.example.seminar41;
}