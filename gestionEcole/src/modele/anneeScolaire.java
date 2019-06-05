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
public class anneeScolaire {
    private int id = 0;
    public anneeScolaire(int id){
        this.id = id;
    }
    public anneeScolaire(){
    
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
