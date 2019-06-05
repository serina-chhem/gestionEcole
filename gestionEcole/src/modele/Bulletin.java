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
public class Bulletin {
    private int id = 0;
    private int classeId;
    private int personneId;
    
    
    public Bulletin(int id, Classe classeId, Personne personneId){
        this.id = id;
        this.classeId = classeId.getId();
        this.personneId = personneId.getId();
    }
    public int getId() {
    return id;
    }

  public void setId(int id) {
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
