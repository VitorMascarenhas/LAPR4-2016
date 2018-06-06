package csheets.ipc.findworkbooks.ui;

import java.io.File;
import java.util.TimerTask;

/**
 * @author Pedro Costa
 */
public abstract class FileWatcher extends TimerTask
{
    private long timeStamp;
    private File file;


    public FileWatcher(File file)
    {
        this.file = file;
    }

    /**
     * Run method that check if that file has a modification. Its called by the
     * timer.
     */
    @Override
    public final void run() {
        long localTimeStamp = file.lastModified();

        //if a modification occurs
        if (this.timeStamp != localTimeStamp) {
            this.timeStamp = localTimeStamp;
            onChange(file);
        }
    }

    /**
     * Abstract methos to be overwrited.
     *
     * @param file
     */
    public abstract void onChange(File file);

}
