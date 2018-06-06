/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ext.images.ui.UIExtensionImages;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Miguel Ferrão
 */
public class ImagesExtension extends Extension{
    
    public static final String NAME = "Images"; 
    
    public ImagesExtension() {
        super(NAME);
    }
    
    public ImageableCell extend(Cell cell){
        return new ImageableCell(cell);
    }
    
    public UIExtension getUIExtension(UIController uiController){
        return new UIExtensionImages(this, uiController);
    }
}
