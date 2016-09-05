/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Point;
import java.io.File;

/**
 *
 * @author Nick de Kort
 */
public class Image extends DrawingItem {
    
    private static final long serialVersionUID = 1L;
    
    private File file;
    private Double size;

    public Image(File file, Double size, Point anchor, Color color) {
        super(anchor, color);
        this.file = file;
        this.size = size;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
    
    @Override
    public String toString() { 
        return "Image - Anchor: '"+ super.toString() + "', File: '" + this.file + "', Size: '" + this.size + "'";
    }

    @Override
    public void Paint(IPaintable paintable) {
        paintable.paintImage(this);
    }
    
    
    
}
