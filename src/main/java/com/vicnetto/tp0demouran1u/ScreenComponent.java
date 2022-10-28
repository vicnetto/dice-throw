package com.vicnetto.tp0demouran1u;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ScreenComponent {

    private static final String TITLE_COLOR = "#ffb86c";
    private static final String AMOUNT_OF_MOVES_COLOR = "#f8f8f2";
    private static final String AMOUNT_OF_421_COMBINATION_COLOR = "#f8f8f2";
    private static final String DEFAULT_MOVES_LABEL = "Number of moves: ";
    private static final String DEFAULT_421_LABEL = "Number of sequences 421: ";

    private final List<Label> diceRollInformation = new ArrayList<>();

    private final List<Die> dice = new ArrayList<>();

    private final DiceImage diceImage = new DiceImage();

    private int amountOfClicks = 0;
    private int amountOf421s = 0;

    public int getAmountOfClicks() {
        return amountOfClicks;
    }

    public void increaseAmountOfClicks() {
        amountOfClicks++;

        diceRollInformation.get(0).setText(DEFAULT_MOVES_LABEL + amountOfClicks);
    }

    public void increaseAmountOf421S() {
        amountOf421s++;

        diceRollInformation.get(1).setText(DEFAULT_421_LABEL + amountOf421s);
    }

    public List<Die> getDice() {
        return dice;
    }

    public DiceImage getDiceImage() {
        return diceImage;
    }

    /**
     * Checks if the current sequence of dices is 421.
     */
    public void checkIfDicesAre421() {
        String currentRollsConcatenated = dice.stream()
                .map(Die::getNumber).map(String::valueOf).collect(Collectors.joining());

        if (currentRollsConcatenated.equals("421")) {
            increaseAmountOf421S();
        }
    }

    /**
     * This function creates an HBox and adds a play/quit button to it.
     *
     * @return -> It returns a HBox with the button.
     */
    public HBox createPlayAndQuitButtons() {
        // Setting a HBox, that will be used for the  buttons.
        HBox leftHBox = new HBox();
        leftHBox.setAlignment(Pos.BOTTOM_LEFT);
        HBox.setHgrow(leftHBox, Priority.ALWAYS);

        HBox rightHBox = new HBox();
        rightHBox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setHgrow(rightHBox, Priority.ALWAYS);

        HBox bottomHBox = new HBox(leftHBox, rightHBox);
        bottomHBox.setPadding(new Insets(15));

        PlayListener playListener = new PlayListener();
        Button play = new Button("Play");
        play.setOnAction(playListener); // Setting this class as a listener to the button.

        // Configuring quit button, with the equivalent image.
        QuitListener quitListener = new QuitListener();
        Button quit = new Button();
        String imagePath = Objects.requireNonNull(getClass().getResource("quit.png")).toExternalForm();
        ImageView quitImage = new ImageView(imagePath);
        quitImage.setPreserveRatio(true);
        quitImage.setFitHeight(15);
        quitImage.setFitWidth(15);
        quit.setGraphic(quitImage);
        quit.setOnAction(quitListener);
        quit.setAlignment(Pos.BOTTOM_LEFT);

        playListener.setPlayButtonComponent(this);

        leftHBox.getChildren().add(play);
        rightHBox.getChildren().add(quit);

        return bottomHBox;
    }

    /**
     * Creates the central HBox for the dices.
     *
     * @return -> Returns the HBox with three dices.
     */
    public HBox createHBoxForDiceRollButtons() {
        HBox hBoxCenter = new HBox();
        hBoxCenter.setSpacing(20);
        hBoxCenter.setAlignment(Pos.CENTER);

        DieListener dieListener = new DieListener();

        for (int i = 0; i < 3; i++) {
            Die die = new Die();
            die.getButton().setOnAction(dieListener);
            die.getButton().setGraphic(die.getImageView());
            die.getButton().setStyle(Die.NORMAL_STYLE);

            diceImage.changeImageAccordingToNumber(die);
            dice.add(die);
        }
        dieListener.setDice(dice);

        hBoxCenter.getChildren().addAll(dice.stream().map(Die::getButton).toList());

        return hBoxCenter;
    }

    /**
     * This function sets three phrases at the beginning of the window.
     *
     * @return -> The created VBOX.
     */
    public VBox createVBoxForUpperInformation() {
        VBox vBoxTop = new VBox();
        vBoxTop.setPadding(new Insets(15));
        vBoxTop.setSpacing(20);
        vBoxTop.setAlignment(Pos.CENTER);

        Label title = new Label("Welcome to Dice Throw!");
        title.setFont(new Font("Arial", 20));
        title.setStyle("-fx-font-weight: bold");
        title.setTextFill(Paint.valueOf(TITLE_COLOR));
        Label amountOfMoves = new Label(DEFAULT_MOVES_LABEL + '0');
        amountOfMoves.setTextFill(Paint.valueOf(AMOUNT_OF_MOVES_COLOR));
        Label amountOf421Combination = new Label(DEFAULT_421_LABEL + '0');
        amountOf421Combination.setTextFill(Paint.valueOf(AMOUNT_OF_421_COMBINATION_COLOR));

        diceRollInformation.add(amountOfMoves);
        diceRollInformation.add(amountOf421Combination);

        vBoxTop.getChildren().add(title);
        vBoxTop.getChildren().addAll(diceRollInformation);

        return vBoxTop;
    }
}
