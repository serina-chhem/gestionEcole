/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author serina
 */
public class Inscription {
    private int id = 0;
    private int classeId;
    private int personneId;
    private String td;
    private int anneeScolaireId;
    private String niveau;
    private String pNom;
    private String pPrenom;
    
    public Inscription (int id, int cId, int pId){
        this.id = id;
        this.classeId = cId;
        this.personneId = pId;
    }
    
    public Inscription(){
        
    }
    
    public void setTD(String td){
        this.td = td;    
    }
    
    public void setAnneeSco(int anneeId){
        this.anneeScolaireId = anneeId;    
    }
    
    public void setNiveau(String niv){
        this.niveau = niv;    
    }
    public void setNom(String n){
        this.pNom = n;    
    }
    public void setPrenom(String p){
        this.pPrenom = p;    
    }
    
    public int getAnneeId(){
        return anneeScolaireId;
    }
    public String getPersNom(){
        return pNom;
    }
    public String getPersPrenom(){
        return pPrenom;
    }
    public String getNiveau(){
        return niveau;
    }
    public String getTD(){
        return td;
    }
    
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getClasseId(){
        return classeId;
    }
    
    public void setClasseId(int classeId){
        this.classeId = classeId;
    }
    
    public int getPersonneId(){
        return personneId;
    }
    
    public void setPersonneId(int personneId){
        this.personneId = personneId;
    }
}
