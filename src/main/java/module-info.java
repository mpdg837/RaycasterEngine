module com.example.rayx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rayx to javafx.fxml;
    exports com.example.rayx;
    exports com.example.rayx.View.UI;
    opens com.example.rayx.View.UI to javafx.fxml;
    exports com.example.rayx.View.UI.Components;
    opens com.example.rayx.View.UI.Components to javafx.fxml;
    exports com.example.rayx.Controller;
    opens com.example.rayx.Controller.Listeners to javafx.fxml;
    opens com.example.rayx.Controller to javafx.fxml;
    exports com.example.rayx.Controller.Listeners;
}