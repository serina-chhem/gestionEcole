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
public class Personne {
    private int id = 0 ;
    private int type = 0;
    private String nom = "";
    private String prenom = "";
    
    public Personne (int id, int type, String nom, String prenom){
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public Personne (){
        
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
}
