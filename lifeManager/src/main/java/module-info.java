module com.example.lifemanager {
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires javafx.controls;
    requires eu.hansolo.toolbox;
    requires javafx.swing;


    opens com.example.lifemanager to javafx.fxml;
    exports com.example.lifemanager;
}