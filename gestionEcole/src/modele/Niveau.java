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
public class Niveau {
    private int id = 0;
    private String nom = "";
    public Niveau(){
        
    }
    public Niveau(int id, String nom){
        this.id = id;
        this.nom = nom;
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
