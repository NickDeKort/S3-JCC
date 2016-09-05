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
import javafx.scene.Scene;
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
        draw();
        primaryStage.setTitle("Test");
        Group root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
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
