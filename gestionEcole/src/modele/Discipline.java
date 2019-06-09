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
public class Discipline {
    private int id = 0;
    private String nom = "";
    private String nomEnseignant = "";
    private int classeId;
    
    public int getClasseId(){
        return classeId;
    }
    public void setClasseId(int classeId){
        this.classeId = classeId;
    }
    
    public Discipline(){
        
    }
    public Discipline(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
  
    public String getNomE(){
        return nomEnseignant;
    }
    
    public void setNomE(String nomE){
        this.nomEnseignant = nomE;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
}
