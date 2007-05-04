/*
 * NewClass.java
 *
 * Created on 2 de Maio de 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.jenquete.model;

import br.com.jenquete.dto.AlternativaDTO;
import br.com.jenquete.dto.EnqueteDTO;
import br.com.jenquete.exception.JEnqueteException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface EnqueteModel {
    public List<EnqueteDTO> listarEnquetesAtivas()throws JEnqueteException;;
    public List<EnqueteDTO> listarEnquetesEncerradas()throws JEnqueteException;;
    public List<EnqueteDTO> listarEnquetes()throws JEnqueteException;;    
    public EnqueteDTO getEnquete(int codigoEnquete)throws JEnqueteException;;
    public void votar(int codigoAlternativa)throws JEnqueteException;
    public void criarEnquete(EnqueteDTO enquete)throws JEnqueteException;;
    public void adicionarAlternativa(int codigoEnquete, AlternativaDTO alternativa)throws JEnqueteException;;
    public void ativarEnquete(int codigoEnquete)throws JEnqueteException;;
    public void encerrarEnquete(int codigoEnquete)throws JEnqueteException;;    
}
