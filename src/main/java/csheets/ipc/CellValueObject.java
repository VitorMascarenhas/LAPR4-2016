/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Value;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.text.Format;
import java.util.Objects;
import javax.swing.border.Border;

/**
 * An object with some attributes from a cell
 * @author smoli
 */
public class CellValueObject implements Serializable{
    
    private Value value;
    private Address address;
    //private Format format;
    private Font font;
    private int hAlignment;
    private int vAlignment;
    private Color fgColor;
    private Color bgColor;
    //private Border border;

    
    
    public CellValueObject(Cell cell){
        this.value = cell.getValue();
        this.address = cell.getAddress();
        //this.format = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getFormat();
        this.font = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getFont();
        this.hAlignment = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getHorizontalAlignment();
        this.vAlignment = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getVerticalAlignment();
        this.fgColor = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getForegroundColor();
        this.bgColor = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getBackgroundColor();
        //this.border = ((StylableCell)cell.getExtension(StyleExtension.NAME)).getBorder();
    }
    
    public Value getValue(){
        return this.value;
    }
    
    public Address getAddress(){
        return this.address;
    }


    /**
     * @return the font
     */
    public Font getFont() {
        return this.font;
    }


    /**
     * @return the hAlignment
     */
    public int gethAlignment() {
        return this.hAlignment;
    }

    /**
     * @return the vAlignment
     */
    public int getvAlignment() {
        return this.vAlignment;
    }

    /**
     * @return the fgColor
     */
    public Color getFgColor() {
        return this.fgColor;
    }

    /**
     * @return the bgColor
     */
    public Color getBgColor() {
        return this.bgColor;
    }
   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.value);
        hash = 73 * hash + Objects.hashCode(this.address);
        //hash = 73 * hash + Objects.hashCode(this.format);
        hash = 73 * hash + Objects.hashCode(this.font);
        hash = 73 * hash + this.hAlignment;
        hash = 73 * hash + this.vAlignment;
        hash = 73 * hash + Objects.hashCode(this.fgColor);
        hash = 73 * hash + Objects.hashCode(this.bgColor);
        //hash = 73 * hash + Objects.hashCode(this.border);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CellValueObject other = (CellValueObject) obj;
        if (this.hAlignment != other.hAlignment) {
            return false;
        }
        if (this.vAlignment != other.vAlignment) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.font, other.font)) {
            return false;
        }
        if (!Objects.equals(this.fgColor, other.fgColor)) {
            return false;
        }
        if (!Objects.equals(this.bgColor, other.bgColor)) {
            return false;
        }

        return true;
    }
}
