package csheets.io;

import csheets.SpreadsheetAppEvent;
import csheets.core.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by berme on 6/16/2016.
 */
public class WorkbookLoader {
    private static transient WorkbookLoader loader = null;

    private WorkbookLoader() {}

    public static WorkbookLoader getInstance() {
        if (loader == null) {
            loader = new WorkbookLoader();
        }

        return loader;
    }

    public Workbook load(File file) throws IOException, ClassNotFoundException {
        Codec codec = new CodecFactory().getCodec(file);
        if (codec != null) {
            FileInputStream stream = null;
            Workbook workbook;
            try {
                // Reads workbook data
                stream = new FileInputStream(file);
                workbook = codec.read(stream);

                return workbook;
            } finally {
                try {
                    if (stream != null)
                        stream.close();
                } catch (IOException e) {}
            }
        } else
            throw new IOException("Codec could not be found");
    }
}
