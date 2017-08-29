/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class SlotMachine extends Application {

    //Komponenter
    private Button insertFive, insertTen, insertFifty, insertHundred, spinButton;
    private TextField leftSlot, middleSlot, rightSlot;
    private Label insertAmountLabel, userNameLabel, userCreditLabel, totalWinningLabel, jackpotLabel;
    private int insertAmount = 0;

    private BorderPane root;
    private VBox banditContainer;
    private VBox userInfoContainer;
    private HBox slotContainer;
    private VBox betLabelContainer;
    private VBox insertButtonContainer;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        banditContainer = new VBox();
        userInfoContainer = new VBox();
        slotContainer = new HBox();
        betLabelContainer = new VBox();
        insertButtonContainer = new VBox();

        Scene scene = new Scene(root, 600, 400);

        initializeUiItems();
        setStage();

        primaryStage.setTitle("Slot Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initializeUiItems() {
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
    }

    public void setStage() {
        banditContainer.setMinSize(200, 400);
        banditContainer.setPadding(new Insets(10, 20, 10, 20));
        banditContainer.getChildren().add(slotContainer);
        banditContainer.getChildren().add(insertButtonContainer);
        banditContainer.getChildren().add(betLabelContainer);

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

        root.setLeft(banditContainer);
        root.setRight(userInfoContainer);
        root.setPadding(new Insets(50));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
