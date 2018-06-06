/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images.ui;

import csheets.ext.images.ImageableCell;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Eduardo Silva
 */
public class ImagesController {
    /** The user interface controller */
    private UIController uiController;

    /** User interface panel **/
    private ImagesPanel uiPanel;
    
    public ImagesController(UIController uiController, ImagesPanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
    }
    
    public boolean setImage(ImageableCell cell, String imagePath) {
        if(cell.hasImage()){
            if(cell.returnAllImages().contains(imagePath)){
                return false;
            }else{
                cell.setImage(imagePath);
                uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
            //uiPanel.setImage(cell);
                return true;
            }                    
        }else{
            cell.setImage(imagePath);
            uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
            return true;
        }
    }
    
    public boolean removeImage(ImageableCell cell, String imagePath) {
        cell.removeImage(imagePath);
        uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        //uiPanel.setImage(cell);
        return true;
    }
    
    public void cellSelected(ImageableCell cell) {
        uiPanel.setImage(cell);
    }
    
}
