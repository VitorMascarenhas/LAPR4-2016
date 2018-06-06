/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

/**
 *
 * @author Sara Ramos
 */
public class ImportFactory
{
    private static final ImportFactory factory = new ImportFactory();
    
    public static ImportFactory importFactory(){
        return factory;
    } 
    /**
     * Adequate the import strategy with file to import
     * @param fileExtension
     * @return  an object ImportStrategy
     */
    public ImportStrategy importStrategy(String fileExtension){
        
        try{
            
           return (ImportStrategy)Class.forName("csheets.lang.files" + ".Import" + 
                   fileExtension.toUpperCase()+"Strategy").newInstance();
        
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            throw new IllegalArgumentException("The extension of the selected file is not implemented! \nTry another file.");

        }
    }
    
}
