package csheets.ui;

import csheets.ui.ctrl.CustomSortAction;
import csheets.ui.ctrl.SetColumnAutomaticSortAction;
import csheets.ui.ctrl.SortAction;
import csheets.ui.ctrl.SortAscendingAction;
import csheets.ui.ctrl.SortDescendingAction;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by berme on 6/8/2016.
 */
public abstract class PopupHandler extends MouseAdapter {
    protected final SubMenu menu;

    public PopupHandler () {
        this.menu = new SubMenu();
        buildMenu();
    }

    @Override
    public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    protected void doPop(MouseEvent e){
        this.menu.show(e.getComponent(), e.getX(), e.getY());
    }

    private class SubMenu extends JPopupMenu {

        private SubMenu() {
        }

        private void createBaseItems() {
            SortAction sort = new SortAction();
            sort.setEnabled(true);

            JMenu newMenu = new JMenu("Sort..");
            newMenu.add(new SortAscendingAction());
            newMenu.add(new SortDescendingAction());
            newMenu.add(new CustomSortAction());
            newMenu.add(new SetColumnAutomaticSortAction());
            menu.add(newMenu);
            //menu.add(sort);
        }
    }

    public void buildMenu() {
        this.menu.createBaseItems();
    };
}
