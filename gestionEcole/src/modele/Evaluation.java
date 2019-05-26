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
public class Evaluation {
    private int id = 0;
    private float note =0;
    private String appreciation = "";
    private int detailBullId;
    
    public Evaluation(int id, float n, String a, detailBulletin d){
        this.id = id;
        this.appreciation = a;
        this.note = n;
        this.detailBullId = d.getId();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
     public float getNote(){
        return note;
    }
    public void setNote(float n){
        this.note = n;
    }
    
    public String getAppre(){
        return appreciation;
    }
    
    public void setAppre(String app){
        this.appreciation = app;
    }
    
    public int getDetailBullId(){
        return detailBullId;
    }
    public void setDetailBullId(detailBulletin dBullId){
        this.detailBullId = dBullId.getId();
    }
}
