package com.example.assignment7;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * Tree class for constructing trees in the GUI
 */
public class Tree {
    private Rectangle trunk;
    private Ellipse leaves;
    private Rectangle box;

    /**
     * Public constructor
     * @param x x-coordinate for the reference Rectangle box
     * @param y y-coordinate for the reference Rectangle box
     */
    public Tree(int x, int y){

        trunk = new Rectangle(x-10, y -100, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);
        box = new Rectangle(x, y, 5, 5);

        leaves = new Ellipse(x, y-100, 40, 60);
        leaves.setFill(Color.rgb(30, 120, 80));
    }

    /**
     * Public constructor
     * @param x x-coordinate for the reference Rectangle box
     * @param y y-coordinate for the reference Rectangle box
     * @param a used for radius-x of the Ellipse leaves
     * @param b used for radius-y of the Ellipse leaves
     * @param COLOR used for coloring the Ellipse leaves
     */
    public Tree(int x, int y, int a, int b, Color COLOR) {
        x = (int)(x * 1.5);
        trunk = new Rectangle(x-10, y-100, ((int)(x/7.5)), ((int)(y/4.5)));
        trunk.setFill(Color.SADDLEBROWN);
        box = new Rectangle(x, y, 5, 5);

        leaves = new Ellipse(x+10, y-100, ((int)(a/2.5)), ((int)(b/3.5)));
        leaves.setFill(COLOR);
    }

    /**
     * Returns all the Nodes created
     * @return Nodes in an array
     */
    public Node[] getAllNodes(){
        return new Node[] {trunk, leaves, box};
    }
}
