/*
 * AlternativaDTO.java
 *
 * Created on 2 de Maio de 2007, 23:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.jenquete.dto;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class AlternativaDTO implements Serializable {
    
  private int codigoEnquete;
  private int codigoAlternativa;
  private String alternativa;
  private int quantidadeVotacao;
  
  public int getCodigoEnquete(){
      return this.codigoEnquete;
  }

  public int getCodigoAlternativa(){
      return this.codigoAlternativa;
  }
  
  public String getAlternativa(){
      return this.alternativa;
  }
  
  public int getQuantidadeVotacao(){
      return this.quantidadeVotacao;
  }
  
  
  public void setCodigoEnquete(int codigoEnquete){
      this.codigoEnquete = codigoEnquete;
  }

  public void setCodigoAlternativa(int codigoAlternativa){
       this.codigoAlternativa = codigoAlternativa;
  }
  
  public void setAlternativa(String alternativa){
      this.alternativa = alternativa;
  }
  
  public void setQuantidadeVotacao(int quantidadeVotacao){
      this.quantidadeVotacao = quantidadeVotacao;
 }
  
    
}
