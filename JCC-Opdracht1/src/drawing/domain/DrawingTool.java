/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import javafx.application.Application;
import javafx.stage.Stage;
import drawing.javafx.JavaFXPaintable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;


/**
 *
 * @author martijn
 */
public class DrawingTool extends Application{

    public Drawing drawing = new Drawing();
    public Canvas canvas = new Canvas();
    public JavaFXPaintable painttable;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try {

            // Create Oval drawingitem
            DrawingItem oval = new Oval(2.2, 2.2, new Point(1, 1), Color.BLACK);
            oval.setColor(Color.BLACK);
            drawing.addItem(oval);

            // Create PaintedText drawingitem
            Font newFont = new Font("Verdana", Font.BOLD, 12);
            DrawingItem paintedText = new PaintedText(null, newFont, new Point(3, 3), Color.BLACK);
            drawing.addItem(paintedText);

            // Create Spline drawingitem
            Point[] points = new Point[2];
            points[0] = new Point(4, 4);
            points[1] = new Point(5, 5);
            DrawingItem spline = new Spline(points, 15, 90, new Point(5, 5), Color.BLACK);
            drawing.addItem(spline);

            // Change object and revert it to the previous state
            //String fileName = Integer.toString(3);
            //Spline changedSpline = (Spline)drawing.getDrawingItems().get(3);
            //changedSpline.setPreviousState(changedSpline, fileName);
            //changedSpline.setDegree(50);

            this.draw();
        } catch(Exception EX) {
            System.out.println(EX);
        }
        
        primaryStage.show();
        primaryStage.setTitle("Test");
        Group root = new Group();
        root.getChildren().add(canvas);
    }
    
    public void draw() {
        this.painttable = new JavaFXPaintable(canvas);
        for (DrawingItem drawingItem : this.drawing.getDrawingItems()) {
            if (drawingItem instanceof Oval) {
                this.painttable.paintOval((Oval)drawingItem);
            } else if (drawingItem instanceof Image) {
                this.painttable.paintImage((Image)drawingItem);
            } else if (drawingItem instanceof PaintedText) {
                this.painttable.paintText((PaintedText)drawingItem);
            } else if (drawingItem instanceof Spline) {
                Point[] points = ((Spline) drawingItem).getPoints();
                this.painttable.paintLine(points[0], points[1]);
            }
        }
    }
    
}
