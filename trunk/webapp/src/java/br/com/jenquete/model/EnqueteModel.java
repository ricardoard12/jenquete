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
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface EnqueteModel {
    public List<EnqueteDTO> listarEnquetesAtivas();
    public List<EnqueteDTO> listarEnquetesEncerradas();
    public List<EnqueteDTO> listarEnquetes();    
    public EnqueteDTO getEnquete(int codigoEnquete);
    public void votar(int codigoAlternativa);
    public void criarEnquete(EnqueteDTO enquete);
    public void adicionarAlternativa(int codigoEnquete, AlternativaDTO alternativa);
    public void ativarEnquete(int codigoEnquete);
    public void encerrarEnquete(int codigoEnquete);    
}
