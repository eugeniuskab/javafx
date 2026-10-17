module com.example.seminar4_homework1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar4_homework1 to javafx.fxml;
    exports com.example.seminar4_homework1;
}