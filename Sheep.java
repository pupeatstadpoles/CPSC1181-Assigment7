package com.example.assignment7;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * Sheep class for constructing a sheep in the GUI
 */


public class Sheep{

    private Ellipse body, head, leftEar, rightEar;
    private Rectangle box, leftEye, rightEye, leg1, leg2, leg3, leg4;


    /**
     * Public Constructor
     * @param x x-coordinate for the reference Rectangle box
     * @param y y-coordinate for the reference Rectangle box
     */
    public Sheep(int x, int y) {
        box = new Rectangle(x, y, 5, 5);

        leg1 = new Rectangle(x-45, y-55,10,50);
        leg2 = new Rectangle(x-15, y-55, 10, 50);
        leg3 = new Rectangle(x+15, y-55, 10, 50);
        leg4 = new Rectangle(x+35, y-55, 10, 50);

        body = new Ellipse(x, y-45, 55, 25);
        body.setFill(Color.WHITESMOKE);
        body.setStroke(Color.DARKGREY);

        head = new Ellipse(x-50, y-75, 25, 35);
        head.setStroke(Color.DARKGREY);
        head.setFill(Color.WHITESMOKE);

        leftEar = new Ellipse(x-70, y-105, 12, 7);
        leftEar.setStroke(Color.DARKGREY);
        leftEar.setFill(Color.FLORALWHITE);
        rightEar = new Ellipse(x-30, y-105, 12, 7);
        rightEar.setStroke(Color.DARKGREY);
        rightEar.setFill(Color.FLORALWHITE);

        leftEye = new Rectangle(x-62, y-90, 4, 6);
        rightEye = new Rectangle(x-42, y-90, 4, 6);
    }

    /**
     * Returns all the Nodes created
     * @return Nodes in an array
     */
    public Node[] getAllNodes() {
        return new  Node[] {box, leg4, leg3, leg2, leg1, body, leftEar, rightEar, head, leftEye, rightEye};
    }
}
