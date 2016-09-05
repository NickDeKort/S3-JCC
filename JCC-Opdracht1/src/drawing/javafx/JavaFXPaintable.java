/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.javafx;

import javafx.scene.canvas.GraphicsContext;
import drawing.domain.IPaintable;
import drawing.domain.Image;
import drawing.domain.Oval;
import drawing.domain.PaintedText;
import java.awt.Point;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 *
 * @author Nick de Lang
 */
public class JavaFXPaintable implements IPaintable {
    
    
    public GraphicsContext gc;
    
    public JavaFXPaintable(Canvas canvas){
        gc = canvas.getGraphicsContext2D();
    }

    
    @Override
    public void setColor(Color color) {
        gc.setFill(color);
    }

    @Override
    public void paintOval(Oval oval) {
        gc.strokeOval(oval.getAnchor().getX(), oval.getAnchor().getY(), oval.getWidth(), oval.getHeight());
    }

    @Override
    public void paintLine(Point from, Point to, Integer weight) {
        gc.strokeLine(from.x, from.y, to.x, to.y);
    }

    @Override
    public void paintText(PaintedText text) {
        gc.strokeText(text.getContent(), text.getAnchor().getX(), text.getAnchor().getY());
    }

    @Override
    public void paintImage(Image image) {
        
        gc.drawImage(new javafx.scene.image.Image(image.getFile().getPath()), image.getAnchor().getX(), image.getAnchor().getY());
    }

    @Override
    public void clear() {
        int maxwith = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int maxheight = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        gc.clearRect(0, 0, maxwith, maxheight);
    }
    
}
