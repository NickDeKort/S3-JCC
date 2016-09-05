/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcc.opdracht1;

import drawing.domain.Drawing;
import drawing.domain.DrawingItem;
import drawing.domain.DrawingTool;
import drawing.domain.IPaintable;
import drawing.domain.Image;
import drawing.domain.Oval;
import drawing.domain.PaintedText;
import drawing.domain.Spline;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import static java.util.Collections.sort;

/**
 *
 * @author Nick de Kort
 */
public class JCCOpdracht1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(DrawingTool.class);
            }
        }.start();
        
        DrawingTool drawingTool = new DrawingTool();
        
    }
    
    private void week1()
    {
        Drawing drawing = new Drawing();
        
        // Create Image drawingitem
        DrawingItem image = new Image(null, 2.2, new Point(2, 2), Color.BLACK);
        drawing.addItem(image);
        
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
        String fileName = Integer.toString(3);
        Spline changedSpline = (Spline)drawing.getDrawingItems().get(3);
        changedSpline.setPreviousState(changedSpline, fileName);
        changedSpline.setDegree(50);
        
        // Sort by location
        sort(drawing.getDrawingItems());
        
        // Show drawingitem object strings
        System.out.println("CurrentState:");
        drawing.getDrawingItems().stream().forEach((d) -> {
            System.out.println(d.toString());
        });
        
        System.out.println("-------");
        
        // Check changedSpline previous state
        System.out.println("PreviousState:");
        System.out.println(changedSpline.getPreviousState(fileName).toString());
        System.out.println("-------");
        
        
        // Rever changedSpline previous state
        System.out.println("Revert PreviousState");
        System.out.println("Current State: " + changedSpline.toString());
        System.out.println("Previous State: " + changedSpline.getPreviousState(fileName).toString());
        drawing.revertState(3);
        
        Spline lastSpline = (Spline)drawing.getDrawingItems().get(3);
        System.out.println("New Current State: " + lastSpline.toString());
        System.out.println("-------");
    }

    
}
