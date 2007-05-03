/*
 * EnqueteModelMemoryImpl.java
 *
 * Created on 2 de Maio de 2007, 23:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.jenquete.model;

import br.com.jenquete.dto.EnqueteDTO;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class EnqueteModelMemoryImpl implements EnqueteModel {
    
    private static EnqueteModelMemoryImpl impl;
    
    public static EnqueteModelMemoryImpl getInstance(){
        if (impl == null)
           impl = new EnqueteModelMemoryImpl();  
    }
    
    /** Creates a new instance of EnqueteModelMemoryImpl */
    private EnqueteModelMemoryImpl() {
    }

    public List<EnqueteDTO> listarEnquetesAtivas() {
    }

    public List<EnqueteDTO> listarEnquetesEncerradas() {
    }

    public List<EnqueteDTO> listarEnquetes() {
    }

    public EnqueteDTO getEnquete(int codigoEnquete) {
    }

    public void votar(int codigoAlternativa) {
    }
    
}
