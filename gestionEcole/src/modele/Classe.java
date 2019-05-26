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
public class Classe {
    private int id = 0;
    private String nom = "";
    private int anneeScolaire_id;
    private int niveau_id;
    
    public Classe (int id, String nom, anneeScolaire anneeScolaire_id, Niveau niveau_id){
        this.id = id;
        this.nom = nom;
        this.anneeScolaire_id = anneeScolaire_id.getId();
        this.niveau_id = niveau_id.getId();
    }
    
    public Classe(){
        
    }
    
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public int getAnneeScolaireId(){
      return anneeScolaire_id;
  }
  
  public void setAnneeScolaireId(anneeScolaire anneeId){
      this.anneeScolaire_id = anneeId.getId();
  }
  
  public int getNiveauId(){
      return niveau_id;
  }
  
  public void setNiveauId(Niveau niveauId){
      this.niveau_id = niveauId.getId();
  }
  
  
}
