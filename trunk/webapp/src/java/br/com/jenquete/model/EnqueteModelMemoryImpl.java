/*
 * EnqueteModelMemoryImpl.java
 *
 * Created on 2 de Maio de 2007, 23:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.jenquete.model;

import br.com.jenquete.dto.AlternativaDTO;
import br.com.jenquete.dto.EnqueteDTO;
import br.com.jenquete.exception.JEnqueteException;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrador
 */
public class EnqueteModelMemoryImpl implements EnqueteModel {
    
    private static EnqueteModelMemoryImpl impl;
    
    private Map <Integer, EnqueteDTO> enquetes;
    private Map <Integer, AlternativaDTO> alternativas;
    private List<EnqueteDTO> lstEnquetes;
    
    private int codigoEnqueteAtual;
    private int codigoAlternativaAtual;
    
    public static EnqueteModelMemoryImpl getInstance(){
        if (impl == null)
           impl = new EnqueteModelMemoryImpl();  
    }
    
    /** Creates a new instance of EnqueteModelMemoryImpl */
    private EnqueteModelMemoryImpl() {
        lstEnquetes = new ArrayList<EnqueteDTO>();
        enquetes = new HashMap<Integer, EnqueteDTO>();
        alternativas = new HashMap<Integer, AlternativaDTO>();
        codigoEnqueteAtual = 0;
        codigoAlternativaAtual = 0;
    }
    
    private int nextCodigoEnquete(){
        return codigoEnqueteAtual++;
    }
    
    private int nextCodigoAlternativa(){
        return codigoAlternativaAtual++;
    }

    public List<EnqueteDTO> listarEnquetesAtivas() throws JEnqueteException {
        List<EnqueteDTO> resultado = new ArrayList<EnqueteDTO>();
        for(int i=0; i<lstEnquetes.size(); i++){
            if (lstEnquetes.get(i).getStatus().equals("1")){
                resultado.add(lstEnquetes.get(i));                
            }
        }
        return resultado;
    }
    

    public List<EnqueteDTO> listarEnquetesEncerradas()throws JEnqueteException  {
                List<EnqueteDTO> resultado = new ArrayList<EnqueteDTO>();
        for(int i=0; i<lstEnquetes.size(); i++){
            if (lstEnquetes.get(i).getStatus().equals("2")){
                resultado.add(lstEnquetes.get(i));                
            }
        }
        return resultado;
    }

    public List<EnqueteDTO> listarEnquetes()throws JEnqueteException  {
        return lstEnquetes;
    }

    public EnqueteDTO getEnquete(int codigoEnquete)throws JEnqueteException  {
        EnqueteDTO enquete = enquetes.get(new Integer(codigoEnquete));
        if (enquete == null)
            throw new JEnqueteException("Enquete inexistente");
        
        return enquete;                
    }

    public void votar(int codigoAlternativa)throws JEnqueteException  {
        AlternativaDTO alternativa = alternativas.get(new Integer(codigoAlternativa));
        
        if (alternativa == null)
            throw new JEnqueteException("Alternativa inexistente");
        
        EnqueteDTO enquete = enquetes.get(new Integer(alternativa.getCodigoEnquete()));
        if (enquete == null)
            throw new JEnqueteException("Enquete inexistente");
        
        if (!enquete.getStatus().equals("1"))
            throw new JEnqueteException("Enquete não está ativa");
        
        alternativa.setQuantidadeVotacao(alternativa.getQuantidadeVotacao()+1);        
    }

    public void criarEnquete(EnqueteDTO enquete)throws JEnqueteException  {
        if (enquete != null){
            enquete.setCodigoEnquete(nextCodigoEnquete());
            enquete.setStatus("0");
            enquete.setDataCriacao(new Date());
            
            lstEnquetes.add(enquete);
            enquetes.put(new Integer(enquete.getCodigoEnquete()), enquete);
            
            if (enquete.getAlternativas() != null && enquete.getAlternativas().length > 0){
                for(int i=0; i<enquete.getAlternativas().length; i++){
                    List<AlternativaDTO> a = enquete.getAlternativas();
                    a.get(i).setCodigoAlternativa(nextCodigoAlternativa());
                    a.get(i).setQuantidadeVotacao(0);
                    alternativas.put(new Integer(a.get(i).getCodigoAlternativa()), a.get(i));
                }
            }
            
        }
        
    }

    public void adicionarAlternativa(int codigoEnquete, AlternativaDTO alternativa)throws JEnqueteException  {
        EnqueteDTO enquete = enquetes.get(new Integer(codigoEnquete));
        if (enquete == null)
            throw new JEnqueteException("Enquete inexistente");
        
        if (!enquete.getStatus().equals("0"))
            throw new JEnqueteException("Enquete não está em aberto");
        
        alternativa.setCodigoAlternativa(nextCodigoAlternativa());
        alternativa.setQuantidadeVotacao(0);
                
        if (enquete.getAlternativas() == null){
            List<AlternativaDTO> list = new ArrayList<AlternativaDTO>();
            list.add(alternativa);
            enquete.setAlternativas(list);
        }else{
            List<AlternativaDTO> list = enquete.getAlternativas();
            list.add(alternativa);
        }
        alternativas.put(new Integer(alternativa.getCodigoAlternativa()), alternativa);
           
    }

    public void ativarEnquete(int codigoEnquete)throws JEnqueteException  {
        EnqueteDTO enquete = enquetes.get(new Integer(codigoEnquete));
        if (enquete == null)
            throw new JEnqueteException("Enquete inexistente");
        
        if (!enquete.getStatus().equals("0"))
            throw new JEnqueteException("Enquete não está em aberto");
        
        enquete.setStatus("1");

    }

    public void encerrarEnquete(int codigoEnquete)throws JEnqueteException  {
        EnqueteDTO enquete = enquetes.get(new Integer(codigoEnquete));
        if (enquete == null)
            throw new JEnqueteException("Enquete inexistente");
        
        if (!enquete.getStatus().equals("1"))
            throw new JEnqueteException("Enquete não ativa");
        
        enquete.setStatus("2");        
    }
    
}
