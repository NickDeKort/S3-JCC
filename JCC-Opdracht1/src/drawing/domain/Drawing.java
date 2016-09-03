/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.util.ArrayList;

/**
 *
 * @author Nick de Kort
 */
public class Drawing {
    
    private final ArrayList<DrawingItem> drawingItems = new ArrayList();
    
    private String name;
    private Integer width;
    private Integer height;

    /**
     *  Returns the current list of all drawingitem objects
     * @return List of all drawingitems
     */
    public ArrayList<DrawingItem> getDrawingItems() {
        return drawingItems;
    }
    
    /**
     * Revert state of drawingitem at index in drawingitems to previous saved state
     * @param index Index of the drawingitem that needs to be reverted
     */
    public void revertState(int index) {
        DrawingItem drawingItem = drawingItems.get(index);
        drawingItems.set(index, drawingItem.getPreviousState(Integer.toString(index)));
    }
    
    /**
     * Add drawingitem to list of drawingitems
     * @param drawingItem Drawingitem to add to list of drawingitems
     */
    public void addItem(DrawingItem drawingItem) {
        drawingItems.add(drawingItem);
    }
    
    /**
     * Get drawing name
     * @return Name of this current drawing
     */
    public String getName() {
        return name;
    }
    
    /**
     * Change drawing name
     * @param name New drawing name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get drawing width
     * @return Current width of the current drawing
     */
    public Integer getWidth() {
        return width;
    }
    
    /**
     * Set drawing width
     * @param width New width of the current drawing
     */
    public void setWidth(Integer width) {
        this.width = width;
    }
    
    /**
     * Get drawing height
     * @return Current height of the current drawing
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Set drawing height
     * @param height New height of the current drawing
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
    
}
