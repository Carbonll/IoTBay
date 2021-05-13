/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.*;
import java.util.*;



/**
 *
 * @author Anthony
 */
public class OrderCart implements java.io.Serializable {
    protected Vector items;
    
    public OrderCart(){
        items = new Vector();
    }
    
    public Vector getProducts(){
        return (Vector) items.clone();
    }
    
    public void addProduct(Product newProduct){
        items.addElement(newProduct);
    }
    
    public void removeProduct(int productIndex){
        items.removeElementAt(productIndex);
    }
  
    
}
