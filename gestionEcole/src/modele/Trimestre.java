/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;

/**
 *
 * @author serina
 */
public class Trimestre {
    private int id = 0;
    private int numero = 0;
    private Date dateDebut;
    private Date dateFin;
    private int anneeId; 
    
    public Trimestre(int id, int num, Date debut, Date fin, anneeScolaire anneeId){
        this.id = id;
        this.numero = num;
        this.dateDebut = debut;
        this.dateFin = fin;
        this.anneeId = anneeId.getId();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int num){
        this.numero = num;
    }
    
    
    public Date getDebutDate(){
        return dateDebut;
    }
    public void setDebutDate(Date debut){
        this.dateDebut = debut;
    }
    
    public Date getFinDate(){
        return dateFin;
    }
    public void setFinDate(Date fin){
        this.dateFin = fin;
    }
    
    public int getAnneeScolaireId(){
      return anneeId;
  }
  
  public void setAnneeScolaireId(anneeScolaire anneeId){
      this.anneeId = anneeId.getId();
  }
}
