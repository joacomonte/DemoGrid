module com.example.demogrid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demogrid to javafx.fxml;
    exports com.example.demogrid;
}