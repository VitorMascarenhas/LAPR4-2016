/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 *
 * @author Eduardo Silva
 */
public class UIExtensionImages extends UIExtension {
    
    /** A cell decorator that visualizes images on cells */
    private CellDecorator cellDecorator;
        
    /** A side bar that provides editing of comments */
    private JComponent sideBar;
    
    /*Constructor*/
    public UIExtensionImages(Extension extension, UIController uiController) {
        super(extension, uiController);
    }
    
    	/**
	 * Returns an icon to display with the extension's name.
	 * @return an icon with style
	 */
	public Icon getIcon() {
		return null;
	}

	/**
	 * Returns an instance of a class that implements JMenu.
	 * In this simple case this class only supplies one menu option.
	 * @see ExampleMenu
	 * @return a JMenu component
	 */
	public JMenu getMenu() {
		return null;
	}
	
	/**
	 * Returns a cell decorator that visualizes comments on cells.
	 * @return decorator for cells with comments
	 */
	public CellDecorator getCellDecorator() {
		if (cellDecorator == null)
			cellDecorator = new ImagedCellDecorator();
		return cellDecorator;
	}

	/**
	 * Returns a table decorator that visualizes the data added by the extension.
	 * @return a table decorator, or null if the extension does not provide one
	 */
	public TableDecorator getTableDecorator() {
		return null;
	}	
	
	/**
	 * Returns a toolbar that gives access to extension-specific
	 * functionality.
	 * @return a JToolBar component, or null if the extension does not provide one
	 */
	public JToolBar getToolBar() {
		return null;
	}

    
    public JComponent getSideBar() {
		if (sideBar == null)
			sideBar = new ImagesPanel(uiController);
		return sideBar;
    }
    
    
    
    
}
