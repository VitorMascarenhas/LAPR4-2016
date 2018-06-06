/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contacts.controller;

import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.Professions.IProfession;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import csheets.persistence.ICompanyContactRepository;
import csheets.persistence.IContactRepository;
import csheets.persistence.ITagRepository;
import csheets.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author José Vilela - 1010500
 */
public class SearchContactsByTagsController {
    
    /* IRepositories to retrieve data */
    private IContactRepository contactRepository;
    private ICompanyContactRepository companyContactRepository;
    private ITagRepository tagRepository;
    
    /* Contact to delete or edit */
    private IContact contact;

    /* List of contacts in db*/
    private List<IContact> contactsList;
    /* List of available professions */
    private Set<IProfession> professionsList;

    private Set<ITag> tagsList;
    
    /**
     * Creates a new contact controller.
     *
     */
    public SearchContactsByTagsController()
    {
        this.contactRepository = PersistenceContext.repositories().contacts();
        this.companyContactRepository = PersistenceContext.repositories().companyContacts();
        this.tagRepository = PersistenceContext.repositories().tags();
        this.professionsList = new HashSet<>();
        this.tagsList = new HashSet<>();
    }
    
    /**
     * Get all contacts implementing IContact interface stored in persist system.
     *
     * @return Iterable
     */
    public List<IContact> getContacts(String ex)
    {
        this.contactsList = new ArrayList<>();
        Iterator<Contact> it = this.contactRepository.all().iterator();
        boolean found;
        while(it.hasNext()){
            found = false;
            Contact c = it.next();
            for(ITag t : c.tags()){
                Tag tag = (Tag) t;
                if(tag.tagName().contains(ex))
                    found = true;
            }
            if(found)
                this.contactsList.add(c);
        }
        return this.contactsList;
    }
}
