/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images;

import java.util.EventListener;

/**
 *
 * @author Eduardo Silva
 */
public interface ImageableCellListener extends EventListener {
    
    public void imagesChanged(ImageableCell cell);
}
