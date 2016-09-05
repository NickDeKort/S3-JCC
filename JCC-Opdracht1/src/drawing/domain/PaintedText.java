/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

/**
 *
 * @author Nick de Kort
 */
public class PaintedText extends DrawingItem {
    
    private static final long serialVersionUID = 1L;
    
    private String content;
    private Font font;

    public PaintedText(String content, Font font, Point anchor, Color color) {
        super(anchor, color);
        this.content = content;
        this.font = font;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
    
    @Override
    public String toString() { 
        return "PaintedText - Anchor: '"+ super.toString() + "', Content: '" + this.content + "', Font: '" + this.font + "'";
    }

    @Override
    public void Paint(IPaintable paintable) {
        paintable.paintText(this);
    }
    
}
