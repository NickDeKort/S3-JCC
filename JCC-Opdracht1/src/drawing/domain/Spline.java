/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author Nick de Kort
 */
public class Spline extends DrawingItem {
    
    private static final long serialVersionUID = 1L;
    
    private final Point[] points;
    private Integer weight;
    private Integer degree;

    public Spline(Point[] points, Integer weight, Integer degree, Point anchor, Color color) {
        super(anchor, color);
        this.points = points.clone();
        this.weight = weight;
        this.degree = degree;
    }

    public Point[] getPoints() {
        return points.clone();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
    
    @Override
    public String toString() { 
        return "Spline - Anchor: '" + super.toString() + "', Points: '" + Arrays.toString(this.points) + "', Weight: '" + this.weight + "', Degree: '" + this.degree + "'";
    }
    
}
