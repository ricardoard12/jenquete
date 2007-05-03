/*
 * EnqueteModelFactory.java
 *
 * Created on 2 de Maio de 2007, 23:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.jenquete.model;

/**
 *
 * @author Administrador
 */
public class EnqueteModelFactory {
    
    private static EnqueteModelFactory factory;
   
    private EnqueteModelFactory(){               
    }
    
    public static EnqueteModelFactory getInstance(){
        if (factory == null)
            factory = new EnqueteModelFactory();
    }
    
    public EnqueteModel getModel(){
        return EnqueteModelMemory.getInstance();
    }
    
}
