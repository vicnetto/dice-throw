package com.vicnetto.tp0demouran1u;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Die {

    public static final String PRESSED_STYLE = "-fx-border-color: #44475a; -fx-background-color: #ffb86c";
    public static final String NORMAL_STYLE = "-fx-border-color: #282a36; -fx-background-color: #696c80";

    private int number = 1;

    private final Button button = new Button();

    private boolean isSelected = false;

    private final ImageView imageView = new ImageView();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Button getButton() {
        return button;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean getAndInvertSelected() {
        isSelected = !isSelected;

        return isSelected;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Die() {
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
    }
}
