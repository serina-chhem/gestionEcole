/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Hugo
 */
public class affichagebulletin {
 private int id = 0;
    private int classeId;
    private int personneId;
    private String module;
    private int note;
    private float moyenne;
    private String Appre;
    private int trimestre;
    
    
    public affichagebulletin(int id, Classe classeId, Personne personneId){
        this.id = id;
        this.classeId = classeId.getId();
        this.personneId = personneId.getId();
    }

    public affichagebulletin() {
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
    
    public String getModule(){
        return module;
    }
    
    public void setModule(String newmodule){
        this.module = newmodule;
    }
    
    public int getNote(){
        return note;
    }
    
    public void setNote(int newNote){
        this.note = newNote;
    }
     
    public String getAppre(){
        return Appre;
    }
    
    public void setAppre(String newappre){
        this.Appre = newappre;
    }
    
    public float getMoyenne(){
        return moyenne;
    }
    
    public void setMoyenne(float newMoyenne){
        this.moyenne = newMoyenne;
    }
    
    public int getTrimestre(){
        return trimestre;
    }
    
    public void setTrimestre(int newTrimestre){
        this.trimestre = newTrimestre;
    }
  
  
}
