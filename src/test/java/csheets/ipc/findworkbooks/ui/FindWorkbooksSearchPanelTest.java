package csheets.ipc.findworkbooks.ui;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Pedro Costa
 */
public class FindWorkbooksSearchPanelTest
{
    private FindWorkbooksSearchPanel findPanel;

    @Before
    public void setUp()
    {
        this.findPanel = new FindWorkbooksSearchPanel(null);
    }

    @Test
    public void addFilesToList()
    {
        List<File> list = new ArrayList<>();

        final String nameFile1 = "test1";
        final String nameFile2 = "test2";

        final File file1 = new File(nameFile1);
        final File file2 = new File(nameFile2);

        list.add(file1);
        list.add(file2);



        this.findPanel.addFilesToList(list);
        assertTrue(this.findPanel.resultList().getModel().getSize()==2);

        String file1Str = this.findPanel.resultList().getModel().getElementAt(0).toString();
        String file2Str = this.findPanel.resultList().getModel().getElementAt(1).toString();

        assertTrue(file1Str.contains(nameFile1));
        assertTrue(file2Str.contains(nameFile2));
    }

    @Test
    public void addFilesToList2()
    {
        List<File> list = new ArrayList<>();

        final String nameFile1 = "test1";

        final File file1 = new File(nameFile1);

        list.add(file1);

        this.findPanel.addFilesToList(list);

        DefaultListModel<String> model = new DefaultListModel<>();

        model.addElement(file1.getAbsolutePath());

        assertTrue(model.getSize()==this.findPanel.resultList().getModel().getSize());
        assertTrue(this.findPanel.resultList().getModel().getElementAt(0).equals(model.elementAt(0)));

    }

    @Test
    public void stopWatchFile()
    {
        final String nameFile1 = "test1";
        final File file1 = new File(nameFile1);

        this.findPanel.startWatchFile(file1);
        assertTrue(this.findPanel.stopWatchFile(file1));
    }

    @Test
    public void startWatchFile()
    {
        final String nameFile1 = "test1";
        final File file1 = new File(nameFile1);

        this.findPanel.startWatchFile(file1);
        assertTrue(this.findPanel.watchesList().size()==1);
        assertTrue(this.findPanel.stopWatchFile(file1));
    }

    @Test
    public void startWatchFile2()
    {
        final String nameFile1 = "test1";
        final File file1 = new File(nameFile1);

        this.findPanel.startWatchFile(file1);
        assertTrue(this.findPanel.watchesList().get(file1) != null);
        assertTrue(this.findPanel.stopWatchFile(file1));
    }

}