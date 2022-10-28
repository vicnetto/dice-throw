package com.vicnetto.tp0demouran1u;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class DieListener implements EventHandler<ActionEvent> {

    private List<Die> dice;

    public void setDice(List<Die> dice) {
        this.dice = dice;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        Die die = null;
        for (int i = 0; i < 3; i++) {
            if (button.equals(dice.get(i).getButton())) {
                die = dice.get(i);
            }
        }

        if (die != null) {
            boolean isSelected = die.getAndInvertSelected();

            if (isSelected)
                button.setStyle(Die.PRESSED_STYLE);
            else
                button.setStyle(Die.NORMAL_STYLE);
        }
    }
}
