package csheets.ui.ctrl;

import csheets.CleanSheets;
import csheets.io.WorkbookLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Pedro Costa
 */
public class OpenWorkbookActionTest {

    private static final String TEST_FILE_01="src/test/resources/csheets/ext/findworkbooks/testworksheet.cls";
    private OpenWorkbookAction action;

    @Before
    public void setUp()
    {
        this.action = new OpenWorkbookAction(null, null);
    }

    @Test
    public void updatePreview() throws Exception
    {
        File fileTest1 = new File(TEST_FILE_01);
        WorkbookLoader.getInstance().load(fileTest1);

        String expectedPreview = "A5 -> tests clean sheets 3\n";
        String preview = this.action.updatePreview(fileTest1);

        assertTrue(expectedPreview.equals(preview));
    }

}