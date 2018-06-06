/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.ui.AutomaticSortListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class SetColumnAutomaticSortAction extends FocusOwnerAction {

    @Override
    protected String getName() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "Set column for automatic sort";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Cell cell=focusOwner.getSelectedCell();
        int column = cell.getAddress().getColumn();
        for(CellListener cl : cell.getCellListeners()){
            if(cl instanceof AutomaticSortListener){
                AutomaticSortListener asl = (AutomaticSortListener) cl;
                asl.setSortColumn(column);
                break;
            }
        }
        
    }
    
}
