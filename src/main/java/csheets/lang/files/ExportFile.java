/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author VitorMascarenhas1120035
 */
public class ExportFile {
    
    private IFileType fileType;
    private File file;
    
    public ExportFile() {
        fileType = new ToXML();
    }
    
    /**
     * This method reiceves a File and a 
     * List\<String\>, then create a file xml.
     * @param file
     * @param content
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void createFile(File file, List<String> content) throws FileNotFoundException, IOException {
        
        FileOutputStream fileOutput = new FileOutputStream(file);
        
        ObjectOutputStream create = new ObjectOutputStream(fileOutput);
        
        for(String str : content) {
            create.writeBytes(str);
        }
        
        create.close();
    }
}
