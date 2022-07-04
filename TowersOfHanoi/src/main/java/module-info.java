module com.example.towersofhanoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.towersofhanoi to javafx.fxml;
    exports com.example.towersofhanoi;
}