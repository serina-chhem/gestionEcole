/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import modele.*;

/**
 *
 * @author serina
 */
public class GestionEcole {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) {
        String nom;
        String prenom ;
        String newNom ;
        String newPrenom ;
        int choixModif;
          Statement stmt;
          Connection conn;
          ResultSet rset;
          ResultSetMetaData rsetMeta;
          String nameDatabase = "ecole";
          String loginDatabase = "root";
          String passwordDatabase = "root";
          
         ArrayList<Personne> Eleves = new ArrayList<>();
         ArrayList<Personne> Profs = new ArrayList<>();
         ArrayList<anneeScolaire> Annees = new ArrayList<>();
         ArrayList<Trimestre> Trimestres = new ArrayList<>();

         
 
      try{
          
             //   Connexion conn = new Connexion("ecole", "root", "root");
            // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        
     
        
        rset = stmt.executeQuery("select * from anneeScolaire"  );
        while (rset.next())
        {   
            anneeScolaire a = new anneeScolaire();
            a.setId(rset.getInt("id"));    
            Annees.add(a);
        }
        System.out.println("Taille du tableau d'années : " + Annees.size());

        rset = stmt.executeQuery("select * from trimestre");
        while (rset.next())
        {
            anneeScolaire anneeScolaire_id = new anneeScolaire();
            Trimestre t = new Trimestre();
            t.setId(rset.getInt("id"));
            t.setAnneeScolaireId(anneeScolaire_id);
            t.setDebutDate(rset.getDate("debut"));
            t.setFinDate(rset.getDate("fin"));
            t.setNumero(rset.getInt("numero"));
            Trimestres.add(t);
        }
//        System.out.println("Taille du tableau des trimestres : " + Trimestres.size());
//        Trimestres.forEach(tri ->{
//               System.out.println( " \n Trimestre annee : " + tri.getAnneeScolaireId());
//        });


        
                  rset = stmt.executeQuery("select * from personne where type = 1"  );
                  while (rset.next()){   
                        Personne e = new Personne();
                        e.setId(rset.getInt("id"));
                        e.setNom(rset.getString("nom"));
                        e.setType(rset.getInt("type"));
                        e.setPrenom(rset.getString("prenom"));
                        Eleves.add(e);
                    }
                    Eleves.forEach(per -> {
                         System.out.println("\n Nom : " + per.getNom() + " \n Id : " + per.getId());
                    });
                    
                    
                    System.out.println("Taille du tableau d'élèves : " + Eleves.size());
                    
         rset = stmt.executeQuery("select * from personne where type = 2"  );
                  while (rset.next()){   
                        Personne p = new Personne();
                        p.setId(rset.getInt("id"));
                        p.setNom(rset.getString("nom"));
                        p.setType(rset.getInt("type"));
                        p.setPrenom(rset.getString("prenom"));
                        Profs.add(p);
                    }
                    Profs.forEach(per -> {
                         System.out.println("Nom : " + per.getNom() + " \n Id : " + per.getId());
                    });
                    
                    
                    System.out.println("Taille du tableau des profs : " + Profs.size());
                    
        
        
        
        
        System.out.println("Se connecter en tant que :");
        int type = 0;
     
        System.out.println("1. Eleve ");
        System.out.println("2. Prof");
        System.out.println("3. Admin/Direction");

        System.out.println("0. Quitter");

        Scanner sc = new Scanner(System.in);
       System.out.println("Faites votre choix :");
        type = sc.nextInt();
        switch (type) {
                case 1: 
                    //eleve entre ses identifiants (nom et prenom) pour se connecter, s'inscrire a un cours, visualiser ses notes etc
                   
                    
                    break;
                case 2: 
                    //prof peut choisir sa discipline, mettre des notes a un eleve et remplir son bulletin
           
              break;
                case 3 :
                    
                    int choixAdmin = 0;
                    int id ;
                    System.out.println("admin, quel est ton id : ");
                    id = sc.nextInt();
              
            
        // récupération de l'ordre de la requete
    rset = stmt.executeQuery("select prenom from personne where type = 3 and id = " + "\"" + id + "\""  );

        // récupération du résultat de l'ordre
        //rsetMeta = rset.getMetaData();              
              while (rset.next()){
                  prenom = rset.getString("prenom");
                  System.out.println("Bonjour " + prenom);
                  
                  System.out.println("Connexion réussie!!! ");
                  
              }
                   System.out.println("Admin, que veux tu faire maintenant ");
                       
        System.out.println("1. Inscrire un nouvel élève ");
        System.out.println("2. Supprimer un élève");
        System.out.println("3. Modifier les infos d'un élève");
        
        System.out.println("4. Inscrire un nouveau prof ");
        System.out.println("5. Supprimer un prof");
        System.out.println("6. Modifier les infos d'un prof");

        System.out.println("0. Quitter");
        System.out.println("Choisis stp");

        
        choixAdmin = sc.nextInt();

        switch(choixAdmin){
            case 1 :
             System.out.println("INSCRIPTION D'UN NOUVEL ÉLÈVE ");

                System.out.println("Inscrire le nom de l'élève : ");
              nom = sc.next();
              System.out.println("Inscrire le prénom de l'élève :  ");
                prenom = sc.next();
                 stmt.executeUpdate("INSERT INTO personne(nom, prenom, type) VALUES ( "  + "\"" +nom + "\"" + ", " + "\""  + prenom  + "\"" + ", " + "\"" + 1 + "\"" +" ); ");
           
                        Personne p1 = new Personne();
              
                        Eleves.add(p1);
             
                    
                    System.out.println("Taille du tableau d'élèves : " + Eleves.size());
                    
              
                    System.out.println("Inscription réussie!!! ");
               
               

                break;
                
            case 2 :
                System.out.println("SUPPRESSION D'UN ÉLÈVE ");
                System.out.println("Inscrire l'id de l'élève à supprimer : ");
                id = sc.nextInt();
                for (Iterator<Personne> it = Eleves.iterator(); it.hasNext();) 
                {
                        Personne p2 = it.next();
                        if (p2.getId() == id) { 
                            it.remove();
                            stmt.executeUpdate("DELETE FROM personne where type = 1 and id = " + "\"" +id + "\"" );
                            break;
                        }
                }
          
                System.out.println("Taille du tableau d'élèves : " + Eleves.size());
               
                    Eleves.forEach(p3 -> {
                         System.out.println("Nom : " + p3.getNom() + " \n Id : " + p3.getId());
                    });
                System.out.println("Eleve supprimé de la base de donnée ");
               
               
                
                break;        
            case 3 :
                System.out.println("MODIFICATION DES INFOS D'UN ÉLÈVE ");
                System.out.println("Quel champs voulez-vous modifier : ");
                System.out.println("1. Nom ");
                System.out.println("2. Prénom ");
                
                
                choixModif = sc.nextInt();
                switch(choixModif){
                    case 1 :
                        System.out.println("Tapez l'id de l'élève que vous souhaitez modifier : ");
                        id = sc.nextInt();
                        
                        System.out.println("Nouveau nom de l'élève : ");
                        newNom = sc.next();
                        
                        stmt.executeUpdate("UPDATE personne SET nom = " + "\"" +newNom + "\"" + "WHERE type = 1 AND id = " + "\"" + id + "\"" );
                        System.out.println("Nom de l'élève modifié ");
                        
                      
                        for (Personne p2 : Eleves) {
                            if (p2.getId() == id) {
                                p2.setNom(newNom);
                                break;
                            }
                        }
                        
                        break;
                    case 2 :
                        System.out.println("Tapez l'id de l'élève que vous souhaitez modifier : ");
                        id = sc.nextInt();
                        System.out.println("Nouveau prénom de l'élève : ");
                        newPrenom = sc.next();
                        stmt.executeUpdate("UPDATE personne SET prenom = " + "\"" +newPrenom + "\"" + "WHERE type = 1 AND id = " + "\"" + id + "\"" );
                        System.out.println("Prénom de l'élève modifié");

                        for (Personne p2 : Eleves) {
                            if (p2.getId() == id) {
                                p2.setPrenom(newPrenom);
                                break;
                            }
                        }
                        
                        break;
                        
                    default : 
                        System.out.println("Mauvais choix");
                }


                break; 
            case 4 :
                  System.out.println("INSCRIPTION D'UN NOUVEAU PROF ");

                 System.out.println("Inscrire le nom du prof : ");
              nom = sc.next();
              System.out.println("Inscrire le prénom du prof : ");
                prenom = sc.next();
                   stmt.executeUpdate("INSERT INTO personne(nom, prenom, type) VALUES ( "  + "\"" +nom + "\"" + ", " + "\""  + prenom  + "\"" + ", " + "\"" + 2 + "\"" +" ); ");

               Personne prof = new Personne();
                Profs.add(prof);
               System.out.println("Inscription réussie!!! ");
                break; 
            case 5 :
      System.out.println("SUPPRESSION D'UN PROF ");
                System.out.println("Inscrire l'id du prof à supprimer : ");
                id = sc.nextInt();
                for (Iterator<Personne> it = Profs.iterator(); it.hasNext();) 
                {
                        Personne p2 = it.next();
                        if (p2.getId() == id) { 
                            it.remove();
                            stmt.executeUpdate("DELETE FROM personne where type = 2 and id = " + "\"" +id + "\"" );
                            break;
                        }
                }
          
                System.out.println("Taille du tableau des profs : " + Profs.size());
               
                    Profs.forEach(p3 -> {
                         System.out.println("Nom : " + p3.getNom() + " \n Id : " + p3.getId());
                    });
                System.out.println("Prof supprimé de la base de donnée ");
                
               
                break; 
            case 6 :
                System.out.println("MODIFICATION DES INFOS D'UN PROF ");
 
                System.out.println("Quel champs voulez-vous modifier : ");
                System.out.println("1. Nom ");
                System.out.println("2. Prénom ");
                
                
                choixModif = sc.nextInt();
                switch(choixModif){
                    case 1 :
                        System.out.println("Tapez l'id du prof que vous souhaitez modifier : ");
                        id = sc.nextInt();
                        System.out.println("Nouveau nom du prof : ");
                        newNom = sc.next();
                        for (Personne p3 : Profs) {
                            if (p3.getId() == id) {
                                p3.setNom(newNom);
                                break;
                            }
                        }
                        stmt.executeUpdate("UPDATE personne SET nom = " + "\"" +newNom + "\"" + "WHERE type = 2 AND id = " + "\"" + id + "\"" );
                        System.out.println("Nom du prof  modifié ");
                        
                        break;
                    case 2 :
                        System.out.println("Tapez l'id du prof que vous souhaitez modifier : ");
                        id = sc.nextInt();
                        System.out.println("Nouveau prénom du prof : ");
                        newPrenom = sc.next();
                        for (Personne p3 : Profs) {
                            if (p3.getId() == id) {
                                p3.setPrenom(newPrenom);
                                break;
                            }
                        }
                        stmt.executeUpdate("UPDATE personne SET prenom = " + "\"" +newPrenom + "\"" + "WHERE type = 2 AND id = " + "\"" + id + "\"" );
                        System.out.println("Prénom du prof  modifié");
                        break;
                        
                    default : 
                        System.out.println("Mauvais choix");
                }
                break; 
            case 0 :
                System.exit(0);
                break; 
            default :
               System.out.println("Admin, t'as fais un choix bizarre");

            
        }
                   break;
                    
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erreur de choix");
            }
                
                
                
                
            //    stmt.close();
      }
      catch(SQLException q){
       
         System.out.println(q.getMessage());
         
      } 
      catch (ClassNotFoundException ex) {
            System.out.println("marche pas class");
        }
    }
    
}
