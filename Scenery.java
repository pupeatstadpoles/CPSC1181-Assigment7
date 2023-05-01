package com.example.assignment7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;


/**
 *  Name: Pup Abdulgapul
 * Professor: Hengameh Hamavand
 * Course: CPSC 1181
 * Date: Mar 8, 2023
 * Purpose: Program for using JavaFX to create a Scenery with Trees, a Sheep, and several Rainbow stripes. Uses radio buttons to rotate the caption, buttons to close the program and update the caption with the text from the text field, and checkboxes to toggle showing the Rainbow or the Sheep
 */


public class Scenery extends Application {
    private VBox bigBox, degrees, captioning;
    private HBox backgroundOptions, bottom;
    private CheckBox showRainbow, showSmiley;
    private RadioButton degrees0, degrees90, degrees180, degrees270;

    private Button close, changeCaption;
    private Text backgroundTitle, captionTitle;
    private TextField userInput;

    private Sheep squart;
    private Smiley smiley;

    private Pane root;

    private Rainbow rainbow;

    private Text caption;

    private ToggleGroup rotation;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Overrides start() from Application
     *
     * @param primaryStage the Stage for adding Nodes
     */
    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        RainbowEvent rainbowListener = new RainbowEvent();
        SmileEvent smileyListener = new SmileEvent();
        Eventy closeListener = new Eventy();
        Eventy togglesListener = new Eventy();
        Eventy captionListener = new Eventy();
        BorderPane pwet = new BorderPane();


        //forming the scenery's ground and trees
        Rectangle ground = new Rectangle(0, 400, 600, 100);
        ground.setFill(Color.DARKGREEN);
        root.getChildren().add(ground);

        Tree t1 = new Tree(100, 420);
        root.getChildren().addAll(t1.getAllNodes());

        Tree t2 = new Tree(200, 440, 100, 100, Color.rgb(100, 100, 80));
        root.getChildren().addAll(t2.getAllNodes());

        Tree t3 = new Tree(250, 440, 100, 250, Color.rgb(120, 120, 10));
        root.getChildren().addAll(t3.getAllNodes());

        caption = new Text(160, 470, "Caption here!");
        caption.setFont(Font.font("Comic Sans MS", 32));
        root.getChildren().add(caption);

        squart = new Sheep(220, 430);
        root.getChildren().addAll(squart.getAllNodes());

        pwet.setCenter(root);
        root.setPadding(new Insets(0, 0, 0, 20));

        close = new Button("Close");
        close.setOnAction(closeListener);
        bottom = new HBox(20, close);
        pwet.setBottom(bottom);



        //options for the background
        backgroundTitle = new Text("Background");

        smiley = new Smiley();
        rainbow = new Rainbow();

        showRainbow = new CheckBox("Rainbow");
        showRainbow.setOnAction(rainbowListener);

        showSmiley = new CheckBox("Smiley");
        showSmiley.setOnAction(smileyListener);

        backgroundOptions = new HBox(10, showRainbow, showSmiley);




        //group of radio buttons for rotating the caption text
        rotation = new ToggleGroup();
        degrees0 = new RadioButton("0 degrees");
        degrees0.setOnAction(togglesListener);

        degrees90 = new RadioButton("90 degrees");
        degrees90.setOnAction(togglesListener);

        degrees180 = new RadioButton("180 degrees");
        degrees180.setOnAction(togglesListener);

        degrees270 = new RadioButton("270 degrees");
        degrees270.setOnAction(togglesListener);

        degrees0.setToggleGroup(rotation);
        degrees90.setToggleGroup(rotation);
        degrees180.setToggleGroup(rotation);
        degrees270.setToggleGroup(rotation);

        degrees = new VBox(10, degrees0, degrees90, degrees180, degrees270);
        degrees.setPadding(new Insets(15, 0, 15, 0));



        //for changing the captions
        captionTitle = new Text("Caption");
        userInput = new TextField("caption here");
        userInput.setOnAction(captionListener);

        changeCaption = new Button("Change Text");
        changeCaption.setOnAction(captionListener);

        captioning = new VBox(10, captionTitle, userInput, changeCaption);
        captioning.setAlignment(Pos.BASELINE_CENTER);





        //left side of the borderpane will be one big vbox
        bigBox = new VBox(backgroundTitle, backgroundOptions, degrees, captioning);
        bigBox.setPadding(new Insets(5, 15, 0, 0));
        bigBox.setAlignment(Pos.TOP_CENTER); //aligning them according to the center of the top
        pwet.setLeft(bigBox);


        Scene scene = new Scene(pwet);
        primaryStage.setTitle("JavaFX Trees");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);  //make sure it can't be resized
    }


    /**
     * General event handler class, used for handling events from the rotation ToggleGroup, the close Button, the userInput TextField and the changeCaption button
     */
    private class Eventy implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            if (rotation.getSelectedToggle() == degrees0) {
                caption.setRotate(0);
            }
            if (rotation.getSelectedToggle() == degrees90) {
                caption.setRotate(90);
            }
            if (rotation.getSelectedToggle() == degrees180) {
                caption.setRotate(180);
            }
            if (rotation.getSelectedToggle() == degrees270) {
                caption.setRotate(270);
            }

            if (event.getSource() == changeCaption) {
                caption.setText(userInput.getText());
            }

            if (event.getSource() == close)
                System.exit(0); //close the jvm
        }
    }

    /**
     * Event handler for the Checkbox showSheep
     */
    private class SmileEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (showSmiley.isSelected()) {
                root.getChildren().addAll(smiley.getAllNodes());
                System.out.print("\nAdding smiley");
            }
            if (!showSmiley.isSelected()) {
                root.getChildren().removeAll(smiley.getAllNodes());
                System.out.print("\nRemoving smiley");
            }
        }
    }

    /**
     * Event handler for the showRainbow Checkbox
     */
    private class RainbowEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (showRainbow.isSelected()) {
                root.getChildren().addAll(rainbow.getAllNodes());
                System.out.print("\nAdding rainbow");

            }
            if (!showRainbow.isSelected()) {
                root.getChildren().removeAll(rainbow.getAllNodes());
                System.out.print("\nRemoving rainbow");
            }
        }
    }


    /**
     * Rainbow class for constructing the stripes in a rainbow in the GUI using Arc objects
     */
    private class Rainbow extends Node {
        private Arc red, orange, yellow, green, blue, indigo, violet;

        /**
         * Public Constructor
         */
        public Rainbow() {

            //red stripe of the rainboww
            red = new Arc(300, 100, 300, 90, 0, 180);
            red.setStroke(Color.RED);
            red.setFill(null); //only want the stroke/border
            red.setStrokeWidth(20);
            red.setType(ArcType.OPEN);  //make it open so it doesn't join the 2 ends together

            orange = new Arc(300, 120, 300, 90, 0, 180);
            orange.setStroke(Color.ORANGE);
            orange.setFill(null);
            orange.setStrokeWidth(20);
            orange.setType(ArcType.OPEN);

            yellow = new Arc(300, 140, 300, 90, 0, 180);
            yellow.setStroke(Color.YELLOW);
            yellow.setFill(null);
            yellow.setStrokeWidth(20);
            yellow.setType(ArcType.OPEN);

            green = new Arc(300, 160, 300, 90, 0, 180);
            green.setStroke(Color.GREEN);
            green.setFill(null);
            green.setStrokeWidth(20);
            green.setType(ArcType.OPEN);

            blue = new Arc(300, 180, 300, 90, 0, 180);
            blue.setStroke(Color.BLUE);
            blue.setFill(null);
            blue.setStrokeWidth(20);
            blue.setType(ArcType.OPEN);

            indigo = new Arc(300, 200, 300, 90, 0, 180);
            indigo.setStroke(Color.INDIGO);
            indigo.setFill(null);
            indigo.setStrokeWidth(20);
            indigo.setType(ArcType.OPEN);

            violet = new Arc(300, 220, 300, 90, 0, 180);
            violet.setStroke(Color.VIOLET);
            violet.setFill(null);
            violet.setStrokeWidth(20);
            violet.setType(ArcType.OPEN);
        }

        /**
         * Returns all the Nodes created
         *
         * @return Nodes in an array
         */
        public Node[] getAllNodes() {
            return new Node[]{red, orange, yellow, green, blue, indigo, violet};
        }

    }

    private class Smiley extends Node{
        private Circle body;
        private Arc smile;
        private Ellipse leftEye, rightEye;
        public Smiley() {
            body = new Circle(150,200,100,Color.YELLOW);
            smile = new Arc(150,200,80,80,180,180);
            leftEye = new Ellipse(110,160,10,20);
            rightEye = new Ellipse(190,160,10,20);
        }

        public Node[] getAllNodes() {
            return new Node[] {body,smile,leftEye,rightEye};
        }
    }
}
