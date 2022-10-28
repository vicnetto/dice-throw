package com.vicnetto.tp0demouran1u;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXApplication extends Application {

    public static final int WINDOW_X = 500;
    public static final int WINDOW_Y = 350;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Dice Throw - JavaFX");

        // Creating play button.
        ScreenComponent screenComponent = new ScreenComponent();
        VBox vBoxTop = screenComponent.createVBoxForUpperInformation();
        HBox hBoxCenter = screenComponent.createHBoxForDiceRollButtons();
        HBox hBoxBottom = screenComponent.createPlayAndQuitButtons();

        // Inserting the borderPane, it will be used for separating the components.
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBoxTop);
        borderPane.setCenter(hBoxCenter);
        borderPane.setBottom(hBoxBottom);
        borderPane.setStyle("-fx-background-color: #6272a4");

        // Setting up the scene.
        Scene scene = new Scene(borderPane, WINDOW_X, WINDOW_Y);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
   }
}