package com.vicnetto.tp0demouran1u;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiceImage {

    private final List<Image> diceImages = new ArrayList<>();

    /**
     * Getting all die images, for each value.
     */
    public DiceImage() {
        for (int i = 1; i <= 6; i++) {
            String imagePath = Objects.requireNonNull(getClass().getResource(i +".png")).toExternalForm();
            Image die = new Image(imagePath);
            diceImages.add(die);
        }
    }

    /**
     * Changing the image of a die, according to the random number.
     * @param die -> It's where the image will be changed.
     */
    public void changeImageAccordingToNumber(Die die) {
        die.getImageView().setImage(diceImages.get(die.getNumber() - 1));
    }
}