module fes.aragon.interprete {
    requires javafx.controls;
    requires javafx.fxml;
    requires jlayer;


    opens fes.aragon.interprete to javafx.fxml;
    exports fes.aragon.interprete;
}