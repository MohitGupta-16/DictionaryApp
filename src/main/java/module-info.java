module com.example.dictionaryapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionaryapp to javafx.fxml;
    exports com.example.dictionaryapp;
}