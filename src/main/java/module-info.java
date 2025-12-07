module org.example.invitro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.graphics;

    opens org.example.invitro to javafx.fxml;
    exports org.example.invitro;

    opens org.example.invitro.Controller to javafx.fxml;
    exports org.example.invitro.Controller;
}