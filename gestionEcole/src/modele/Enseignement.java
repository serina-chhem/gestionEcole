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
public class Enseignement {
    private int id = 0; 
    private int classeId;
    private int disciplineId;
    private int personneId;
    
    public Enseignement(int id, Classe classeId, Discipline discId, Personne persId){
        this.id = id;
        this.classeId = classeId.getId();
        this.disciplineId = discId.getId();
        this.personneId = persId.getId();
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
    
    public int getDisciplineId(){
        return disciplineId;
    }
    public void setDisciplineId(Discipline disciplineId){
        this.disciplineId = disciplineId.getId();
    }
    
    public int getPersonneId(){
        return personneId;
    }
    public void setPersonneId(Personne personneId){
        this.personneId = personneId.getId();
    }
    
    
}
