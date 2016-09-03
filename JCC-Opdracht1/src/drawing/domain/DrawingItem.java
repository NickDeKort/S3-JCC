/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Nick de Kort
 */
public class DrawingItem implements Comparable, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private DrawingItem previousState;
    
    private Point anchor;
    private Color color;

    /**
     * Constructor for drawingItem and subclasses
     * @param anchor anchor of drawingitem
     * @param color Color of the drawingitem
     */
    public DrawingItem(Point anchor, Color color) {
        this.anchor = anchor;
        this.color = color;
    }

    /**
     * Get object containing the previous saved state of the current drawingItem
     * @param fileName Name that corresponds to the index of the current drawingItem
     * @return returns drawingitem of the current drawingitem's previous state
     */
    public DrawingItem getPreviousState(String fileName) {
        FileInputStream fis;
        ObjectInputStream ois = null;
        Object obj = null;
        
        try {
            fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DrawingItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DrawingItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return (DrawingItem)obj;
    }
    
    /**
     * Set object containing the previous saved state of the current drawingItem
     * @param previousState Object containing the previousstate of the current drawingItem
     * @param fileName Name that corresponds to the index of the current drawingItem
     */
    public void setPreviousState(DrawingItem previousState, String fileName) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(previousState);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawingItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DrawingItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DrawingItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString() { 
        return "DrawingItem - Anchor: '" + this.anchor + "', Color: '" + this.color + "'" + Double.toString(Math.sqrt(Math.pow((double)getAnchor().x, 2) + Math.pow((double)getAnchor().y, 2)));
    }

    @Override
    public int compareTo(Object o) {
        if (Math.sqrt(Math.pow((double)this.getAnchor().x, 2) + Math.pow((double)this.getAnchor().y, 2)) < Math.sqrt(Math.pow((double)((DrawingItem)o).getAnchor().x, 2) + Math.pow((double)((DrawingItem)o).getAnchor().y, 2))) {
            return 1;
        } else {
            return -1;
        }
    }
    
}
