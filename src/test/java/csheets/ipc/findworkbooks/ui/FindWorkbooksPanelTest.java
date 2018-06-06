package csheets.ipc.findworkbooks.ui;

import csheets.ui.ctrl.OpenWorkbookAction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pedro Costa
 */
public class FindWorkbooksPanelTest
{

    private  FindWorkbooksPanel panel;

    @Before
    public void setUp()
    {
        this.panel = new FindWorkbooksPanel(null);
    }

    @Test
    public void numberOfSearchPanels() throws Exception
    {
        assertTrue(this.panel.numberOfSearchPanels()==0);
        this.panel.addNewSearchTab();
        assertTrue(this.panel.numberOfSearchPanels()==1);
    }

}