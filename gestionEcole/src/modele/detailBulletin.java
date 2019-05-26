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
public class detailBulletin {
    private int id = 0;
    private float moyenne = 0;
    private String appreciation = "";
    private int bulletinId;
    private int enseignementId;
    
    
    public detailBulletin(int id, float moyenne, String app, Bulletin bullId, Enseignement ensId){
        this.id = id ;
        this.moyenne = moyenne;
        this.appreciation = app;
        this.bulletinId = bullId.getId();
        this.enseignementId = ensId.getId();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
     public float getMoyenne(){
        return moyenne;
    }
    public void setMoy(float moy){
        this.moyenne = moy;
    }
    
    public String getAppre(){
        return appreciation;
    }
    
    public void setAppre(String app){
        this.appreciation = app;
    }
    
    
    public int getBulletinId(){
        return bulletinId;
    }
    public void setBulletinId(Bulletin bullId){
        this.bulletinId = bullId.getId();
    }
    
    public int getEnseignementId(){
        return enseignementId;
    }
    public void setEnseignementId(Enseignement enseignementId){
        this.enseignementId = enseignementId.getId();
    }
}
