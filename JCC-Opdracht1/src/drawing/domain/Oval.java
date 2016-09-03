/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nick de Kort
 */
public class Oval extends DrawingItem {
    
    private static final long serialVersionUID = 1L;
    
    private double width;
    private double height;

    public Oval(double width, double height, Point anchor, Color color) {
        super(anchor, color);
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }

    public void setWidth(double Width) {
        this.width = Width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double Height) {
        this.height = Height;
    }
    
    @Override
    public String toString() { 
        return "Oval - Anchor: '"+ super.toString() + "', Width: '" + this.width + "', Height: '" + this.height + "'";
    }
    
}
