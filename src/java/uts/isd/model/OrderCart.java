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
    private ArrayList<Product> items;
    
    public OrderCart(){
        items = new ArrayList<Product>();
    }
    
    public void addProduct(Product newItem)
    {
    items.add(newItem);
    }
    
    public void removeProduct(Product newItem)
    {
    items.remove(newItem);
    }
    
    public int getStock(){
        return items.size();
    }
    
    public ArrayList<Product> getIt(){
        return items;
    }
    
}
