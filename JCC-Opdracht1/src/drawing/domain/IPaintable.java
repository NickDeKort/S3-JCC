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
public interface IPaintable {
    
    // method signatures
    void setColor (Color color);
    void paintOval (Oval oval);
    void paintLine (Point from, Point weight);
    void paintText (PaintedText text);
    void paintImage (Image image);
    void clear();
    
}
