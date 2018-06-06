/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contacts.controller;

import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.TagsManagerXml;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author José Vilela - 1010500
 */
public class TagsController {
    private Set<ITag> tagsList;
    
    public TagsController(){
        this.tagsList = new HashSet<>();
    }
    
    /**
     * Return the list of tags available.
     * @return Set of tags
     */
    public Set<ITag> getTagsList()
    {
        if(this.tagsList.isEmpty()) {
            TagsManagerXml manager = new TagsManagerXml();
            this.tagsList = manager.read();
        }

        return this.tagsList;
    }
}
