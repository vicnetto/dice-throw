package com.vicnetto.tp0demouran1u;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Random;

public class PlayListener implements EventHandler<ActionEvent> {

    private ScreenComponent screenComponent;

    private final Random random = new Random();

    public void setPlayButtonComponent(ScreenComponent screenComponent) {
        this.screenComponent = screenComponent;
    }

    /**
     * In case the play button is pressed, a new value will be assigned to each dice.
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        screenComponent.increaseAmountOfClicks();

        // Rolling a die every time the button is pressed.
        for(int i = 0; i < 3; i++) {
            Die die = screenComponent.getDice().get(i);

            if (!die.isSelected()) {
                die.setNumber(random.nextInt(1, 7));
                screenComponent.getDiceImage().changeImageAccordingToNumber(die);
            }
        }

        screenComponent.checkIfDicesAre421();

        System.out.println("Bienvenue!");
        System.out.println("Ce bouton a été pressé " + screenComponent.getAmountOfClicks() + " fois.");
    }
}
