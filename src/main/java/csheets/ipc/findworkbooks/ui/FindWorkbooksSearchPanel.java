package csheets.ipc.findworkbooks.ui;

import csheets.ui.ctrl.OpenWorkbookAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.Timer;

/**
 * @author Pedro Costa
 */
public class FindWorkbooksSearchPanel extends JPanel

{
    private FindWorkbooksController controller;

    private JButton searchBtn;
    private JList resultList;
    private JTextArea previewArea;
    private JCheckBox checkboxActiveSearch;
    private JScrollPane listScrollPane;
    private JScrollPane previewScrollPane;
    private OpenWorkbookAction openAction;
    private JTextField pathFld;
    private JTextField patternFld;

    private Map<File, java.util.Timer> watchs;

    /**
     * Creates new form FindWorkbooksPanel
     *
     */
    FindWorkbooksSearchPanel(OpenWorkbookAction action)
    {
        setName(FindWorkbooksExtension.NAME);
        this.controller = new FindWorkbooksController(this);
        this.openAction = action;
        this.watchs = new HashMap<>();
        initComponents();
    }

    private void initComponents()
    {
        createFields();
        createResultList();
        createPreviewArea();
        createButtons();
        createCheckBox();
        createLayout();
    }

    private void createButtons()
    {
        this.searchBtn = new JButton();
        this.searchBtn.setText("Find Workbooks");
        this.searchBtn.addActionListener(new ActionListenerButtonDirectory(this.controller, this.pathFld, this.patternFld, this.resultList));
    }

    private void createFields()
    {
        this.pathFld = new JTextField();
        this.pathFld.setToolTipText("root directory field");

        this.patternFld = new JTextField();
        this.patternFld.setToolTipText("pattern field");
    }

    private void createResultList()
    {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        this.resultList = new JList(listModel);

        this.resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());

                previewFile(index);

                if (evt.getClickCount() == 2) {
                    selectFile(index);
                }
            }
        });

        this.resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listScrollPane = new JScrollPane(this.resultList);
        this.listScrollPane.setViewportView(this.resultList);
    }

    private void createPreviewArea()
    {
        this.previewArea = new JTextArea();
        this.previewArea.setEditable(false);

        this.previewScrollPane = new JScrollPane(this.previewArea);
        this.previewScrollPane.setViewportView(this.previewArea);
    }

    private void createCheckBox()
    {
        this.checkboxActiveSearch = new JCheckBox("Active");
        this.checkboxActiveSearch.addActionListener(e -> {
            if(FindWorkbooksSearchPanel.this.checkboxActiveSearch.isSelected())
            {
                FindWorkbooksSearchPanel.this.watchs.keySet().forEach(FindWorkbooksSearchPanel.this::startWatchFile);
            }
            else
            {
                FindWorkbooksSearchPanel.this.watchs.keySet().forEach(FindWorkbooksSearchPanel.this::stopWatchFile);
            }
        });
    }

    private void createLayout()
    {

        this.setLayout(new BorderLayout());

        JPanel fieldsPanel = new JPanel(new GridLayout(2,2));
        fieldsPanel.add(new JLabel("Root"));
        fieldsPanel.add(this.pathFld);
        fieldsPanel.add(new JLabel("Pattern"));
        fieldsPanel.add(this.patternFld);

        this.add(fieldsPanel, BorderLayout.NORTH);


        JPanel listPanel = new JPanel(new GridLayout(2,1));
        listPanel.add(this.listScrollPane);
        listPanel.add(this.previewScrollPane);

        this.add(listPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(this.searchBtn, BorderLayout.WEST);
        southPanel.add(this.checkboxActiveSearch, BorderLayout.EAST);

        this.add(southPanel,BorderLayout.SOUTH);
    }

    protected void addFilesToList(List<File> fileList)
    {
        if (fileList != null && fileList.size() > 0) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.resultList.getModel();

            for (File file : fileList) {
                model.addElement(file.getAbsolutePath());
                this.watchs.put(file,null);
            }

            this.resultList.setModel(model);
            this.resultList.revalidate();
            this.resultList.repaint();
            refresh();
        }
    }

    private void selectFile(int index)
    {
        String path = (String) this.resultList.getModel().getElementAt(index);
        File file = new File(path);
        file.setReadable(true);
        file.setWritable(true);
        this.openAction.setFile(file);
        this.openAction.setWorkbook(null);
        this.openAction.actionPerformed(null);
    }

    private void previewFile(int index)
    {
        String path = (String) this.resultList.getModel().getElementAt(index);
        File file = new File(path);
        file.setReadable(true);
        String preview = this.openAction.createPreview(file);
        this.previewArea.setText(preview);
    }

    public void startWatchFile(File file)
    {
        TimerTask task = new FileWatcher(file)
        {
            @Override
            public void onChange(File file)
            {
                String newPreview = FindWorkbooksSearchPanel.this.openAction.updatePreview(file);
                FindWorkbooksSearchPanel.this.previewArea.setText(newPreview);
            }
        };

        java.util.Timer timer = new java.util.Timer();

        // repeat the check every second
        timer.schedule(task, new Date(), 1000);

        this.watchs.put(file, timer);
    }

    public boolean stopWatchFile(File file)
    {
        Timer timer = this.watchs.get(file);
        timer.cancel();
        return timer.purge() == 0;
    }

    /**
     * Refresh the view of the panel.
     */
    public void refresh()
    {
        Graphics graphic = this.getGraphics();
        this.paint(graphic);
    }

    /**
     * Return the list of files searched.
     *
     * @return JList
     */
    public JList resultList()
    {
        return this.resultList;
    }


    /**
     * Return the list of watches created.
     *
     * @return Map with file and associated timer
     */
    public Map<File,Timer> watchesList()
    {
        return this.watchs;
    }
}
