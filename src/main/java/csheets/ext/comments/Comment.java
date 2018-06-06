/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.comments;

import java.awt.Font;
import java.security.cert.CertificateFactory;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class Comment {
    
    //identifier object
    private int id;
    
    //content of comment
    private String comment;
    
    //date of comment
    private Calendar calendar;
    
    //font of comment
    private String author;
    
    private Font font;
    
    private Format format;
    
    /**
     * Create a object Comment
     * 
     * @param comment
     * @param commentDate
     * @param author
     * @param font 
     * @param format
     */
    public Comment(String comment, Font font, Format format) {
        this.comment = comment;
        this.calendar = Calendar.getInstance();
        this.author = System.getProperty("user.name");
        this.font = font;
        this.format = format;
    }
    
    public Comment(int id, String comment, Font font, Format format) {
        this.comment = comment;
        this.calendar = Calendar.getInstance();
        this.author = System.getProperty("user.name");
        this.font = font;
        this.format = format;
        this.id = id;
    }
    
    public int returnCommentId() {
        return this.id;
    }
    
    public void setCommentId(int id) {
        this.id = id;
    }
    
    /**
     * Returns the content of the Comment
     * @return 
     */
    public String toString() {
        return String.format("%s : %s : %s", this.comment, this.author, calendar.getTime());
    }
    
    public String returnComment() {
        return this.comment;
    }
    
    public String returnCommentDate() {
        return String.format("%s", calendar.getTime());
    }
    
    public String returnAuthor() {
        return this.author;
    }
    
    
}
