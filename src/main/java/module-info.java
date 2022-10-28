module com.vicnetto.tp0demouran1u {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vicnetto.tp0demouran1u to javafx.fxml;
    exports com.vicnetto.tp0demouran1u;
}