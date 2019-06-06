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
    
    public Inscription (int id, Classe cId, Personne pId){
        this.id = id;
        this.classeId = cId.getId();
        this.personneId = pId.getId();
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
    
    public void setClasseId(Classe classeId){
        this.classeId = classeId.getId();
    }
    
    public int getPersonneId(){
        return personneId;
    }
    
    public void setPersonneId(Personne personneId){
        this.personneId = personneId.getId();
    }
}
