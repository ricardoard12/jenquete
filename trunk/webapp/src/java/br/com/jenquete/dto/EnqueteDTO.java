/*
 * EnqueteDTO.java
 *
 * Created on 2 de Maio de 2007, 22:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.jenquete.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class EnqueteDTO implements Serializable {
    
    private int codigoEnquete;
    private String questao;
    private String status;
    private Date dataCriacao;
    private List<AlternativaDTO> alternativas;
    
    public int getCodigoEnquete(){
        return this.codigoEnquete;
    }
    
    public String getQuestao(){
        return this.questao;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public Date getDataCriacao(){
        return this.dataCriacao;
    }
    
    public List<AlternativaDTO> getAlternativas(){
        return this.alternativas;
    }
    
    
    public void setCodigoEnquete(int codigoEnquete){
        this.codigoEnquete = codigoEnquete;
    }
    
    public void setQuestao(String questao){
        this.questao = questao;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setDataCriacao(Date dataCriacao){
        this.dataCriacao = dataCriacao;
    }
    
    public void setAlternativas(List<AlternativaDTO> alternativas){
        this.alternativas = alternativas;
    }
}
    
    
    
    
    
    
    
    
}
