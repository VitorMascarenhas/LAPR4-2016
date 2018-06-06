package csheets.ext.manager.controller;

import csheets.ext.manager.MetadataManager;
import java.util.List;

/**
 *
 * @author André Oliveira
 */
public class AutoDescriptionController {
    
    private MetadataManager metadataManager;
    
    /**
     * Constructor of AutoDescription Controller
     */
    public AutoDescriptionController() {
        this.metadataManager = new MetadataManager();
    }
    
    /**
     * 
     * Method to read the metadata file with the extension data (Name, 
     * versions and description)
     * 
     * @param fileName Name of the file to be read
     * @param descriptions List for save the description of current metadata file
     * @param versions List for save the versions of current metadata file
     * @return 
     */
    public boolean readMetadataInfo(String fileName,  List<String> descriptions, List<String> versions){
        return this.metadataManager.readXml(fileName, descriptions, versions);
    }
    
    public boolean loadExtensions(List<String> extensions){
        return this.metadataManager.loadExtension(extensions);
    }
    
    /**
     * 
     * 
     * @param lineToRemove
     * @return 
     */
    public boolean removeExtension(String lineToRemove){
        return this.metadataManager.removeExtensionFromFile(lineToRemove);
    }

    /**
     * Return the metadata manager
     * @return 
     */
    public MetadataManager getMetadataManager() {
        return metadataManager;
    }
 

}
