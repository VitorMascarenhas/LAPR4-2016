/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import csheets.ext.comments.CommentableCellListener;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo Silva
 */
public class ImageableCell extends CellExtension{

    /*The list of images*/
    private List<String> images;
    
    /*The list of ImageableCellListeners*/
    private transient List<ImageableCellListener> listeners = new ArrayList<ImageableCellListener>();
    
    /*Construct*/
    public ImageableCell(Cell cell) {
        super(cell, ImagesExtension.NAME);
        images = new ArrayList<String>();
        
    }

    /**
    * Returns whether the cell has an image.
    * @return true if the cell has an image
    */
    public boolean hasImage() {
            return this.images != null;
    }

    
    public void setImage(String image) {
            this.images.add(image);
            fireImagesChanged();
    }
    
    public void removeImage(String image) {
            this.images.remove(image);
            fireImagesChanged();
    }   
    
    
    /**
     * Notifies all registered listeners that the cell's images changed.
     */
    protected void fireImagesChanged() {
        for (ImageableCellListener listener : listeners){
                listener.imagesChanged(this);
        }
    }
        
    public void addImageableCellListener(ImageableCellListener listener) {
        if(listeners != null)
 		    listeners.add(listener);
    }
    
    public void removeImageableCellListener(ImageableCellListener listener) {
            listeners.remove(listener);
    }
    
    @Override
    public void styleChanged(Cell cell) {}
    
    public List<String> returnAllImages() {
        return this.images;
    }
    
    private void readObject(java.io.ObjectInputStream stream)
			throws java.io.IOException, ClassNotFoundException {
	    stream.defaultReadObject();
		listeners = new ArrayList<ImageableCellListener>();
    }
    
    
}
