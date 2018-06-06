/*
 * Strategy interface for Metadata Files
 */
package csheets.ext.manager;

import java.util.List;

/**
 *
 * @author André Oliveira
 */
public interface MetadataFilesBehavior {
    
    /**
     * Read the content of a metadata file with a name at parameter.
     * 
     * @param fileName String with the Filename
     * @param description List to save the descriptions
     * @param versions List to save the versions
     * @return True if was read sucefully, false if was read with errors.
     */
    boolean readXml(String fileName, List<String> description, List<String> versions);
    
}
