/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import Database.DatabaseCalls;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class SlotMachine extends Application {

    //Komponenter
    private Button playButton, insertFive, insertTen, insertFifty, insertHundred;
    private TextField leftSlot, middleSlot, rightSlot;
    private Label insertAmountLabel, userNameLabel, userCreditLabel, totalWinningLabel, jackpotLabel;
    private int insertAmount = 0;
    private WinCalculator winCalculator;
    private BorderPane root;
    private VBox banditContainer, userInfoContainer, betLabelContainer, insertButtonContainer;
    private HBox slotContainer;
    private DatabaseCalls databaseCalls;

    @Override
    public void start(Stage primaryStage) {
        databaseCalls = new DatabaseCalls();
        winCalculator = new WinCalculator();

        root = new BorderPane();
        banditContainer = new VBox();
        userInfoContainer = new VBox();
        slotContainer = new HBox();
        betLabelContainer = new VBox();
        insertButtonContainer = new VBox();

        Scene scene = new Scene(root, 600, 400);

        initializeUiItems();
        setStage();
        setFunctions();

        primaryStage.setTitle("Slot Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initializeUiItems() {
        //UI for the slotmachine.
        playButton = new Button();
        playButton.setText("Play");
        playButton.setMinWidth(80);
        insertFive = new Button();
        insertFive.setMinWidth(80);
        insertFive.setText("Insert 5");
        insertTen = new Button();
        insertTen.setMinWidth(80);
        insertTen.setText("Insert 10");
        insertFifty = new Button();
        insertFifty.setMinWidth(80);
        insertFifty.setText("Insert 50");
        insertHundred = new Button();
        insertHundred.setMinWidth(80);
        insertHundred.setText("Insert 100");
        insertAmountLabel = new Label("insert amount: " + insertAmount);
        jackpotLabel = new Label("Current jackpot = " + /*Hämta jackot här*/ "$500 Million");

        leftSlot = new TextField("BAR");
        middleSlot = new TextField("BAR");
        rightSlot = new TextField("BAR");
        leftSlot.setMaxWidth(50);
        middleSlot.setMaxWidth(50);
        rightSlot.setMaxWidth(50);

        //UI for the userinfo
        setUserInfo();
    }

    private void setUserInfo() {
        userNameLabel = new Label(databaseCalls.getUserInfo("name"));
        userCreditLabel = new Label(databaseCalls.getUserInfo("credit"));
        totalWinningLabel = new Label();
    }

    public void setStage() {
        banditContainer.setMinSize(200, 400);
        banditContainer.setPadding(new Insets(10, 20, 10, 20));
        banditContainer.getChildren().add(slotContainer);
        banditContainer.getChildren().add(insertButtonContainer);
        banditContainer.getChildren().add(betLabelContainer);
        banditContainer.getChildren().add(playButton);

        slotContainer.setPadding(new Insets(5, 0, 5, 0));
        slotContainer.getChildren().add(leftSlot);
        slotContainer.getChildren().add(middleSlot);
        slotContainer.getChildren().add(rightSlot);

        HBox buttonLine1 = new HBox();
        HBox buttonLine2 = new HBox();
        insertButtonContainer.setPadding(new Insets(5, 0, 5, 0));
        insertButtonContainer.getChildren().add(buttonLine1);
        insertButtonContainer.getChildren().add(buttonLine2);
        buttonLine1.getChildren().add(insertFive);
        buttonLine1.getChildren().add(insertTen);
        buttonLine2.getChildren().add(insertFifty);
        buttonLine2.getChildren().add(insertHundred);

        betLabelContainer.setPadding(new Insets(5, 0, 5, 0));
        betLabelContainer.getChildren().add(insertAmountLabel);
        betLabelContainer.getChildren().add(jackpotLabel);

        userInfoContainer.setMinSize(200, 600);
        userInfoContainer.getChildren().add(userNameLabel);
        userInfoContainer.getChildren().add(userCreditLabel);

        root.setLeft(banditContainer);
        root.setRight(userInfoContainer);
        root.setPadding(new Insets(50));
    }

    private void setFunctions() {
        betButtonFunc(insertFive, 5);
        betButtonFunc(insertTen, 10);
        betButtonFunc(insertFifty, 50);
        betButtonFunc(insertHundred, 100);
        playButtonFunc(playButton);
    }

    private void betButtonFunc(Button betButton, int amount) {
        betButton.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insertAmount += amount;
                insertAmountLabel.setText("insert amount: " + insertAmount);
            }
        }));
    }

    private void playButtonFunc(Button playButton) {
        playButton.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                play();
            }
        }));
    }

    private void play() {
        leftSlot.setText(winCalculator.slotCalculator());
        middleSlot.setText(winCalculator.slotCalculator());
        rightSlot.setText(winCalculator.slotCalculator());
        winCalculator.winCalculator(insertAmount, leftSlot.getText(), middleSlot.getText(), rightSlot.getText());
        updateUserUI();
    }

    //FIXME kom på ett bättre namn
    private void updateUserUI() {
        //Denna metod ska uppdatera användarens krediter i databasen.
        userCreditLabel.setText("Uppdaterade kreidterna");
        //Alltså när man spelar ska metoden skicka info som tar bort eller lägger till krediter i databasen
        //Denna metod ska använda sig av databaseCalls.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
