module com.dam.arturoexameninterfaces {

    requires javafx.controls;
    requires javafx.fxml;


    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;

    opens com.dam.arturoexameninterfaces.model to org.hibernate.orm.core, javafx.base;

    opens com.dam.arturoexameninterfaces.controller to javafx.fxml;

    exports com.dam.arturoexameninterfaces;
    exports com.dam.arturoexameninterfaces.controller;
    exports com.dam.arturoexameninterfaces.model;
}