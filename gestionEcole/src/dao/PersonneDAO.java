/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Personne;
//import connection.SdzConnection;



/**
 *
 * @author serina
 */
public class PersonneDAO extends DAO<Personne>{

    public PersonneDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Personne obj) {
        return false;

    }

    @Override
    public boolean delete(Personne obj) {
        return false;
    }

    @Override
    public boolean update(Personne obj) {
        return false;
    }

    @Override
    public Personne findEleve(int id) {
        
        Personne eleve = new Personne();
        
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE type = 1 and id = " + id);
            
            if(result.first())
                eleve = new Personne(id, 1, result.getString("nom"), result.getString("prenom"));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
       
        return eleve;
        
        
    }
    @Override
    public Personne findProf(int id) {
        
        Personne prof = new Personne();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE type = 2 and id = " + id);
            if(result.first())
                prof = new Personne(id, 2, result.getString("nom"), result.getString("prenom"));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
       
        return prof;
        
        
    }
    
    
    
}
