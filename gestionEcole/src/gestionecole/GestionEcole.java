/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecole;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import controleur.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String nom = "";
        String prenom = "";
        String newNom = "";
        String newPrenom = "";
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
                 
             
                  rset = stmt.executeQuery("select id from personne where type = 1 and nom = " + "\"" + nom + "\""  );
                  rset.next();                  
                  int idEleve = rset.getInt("id");
     
               Personne el = new Personne(idEleve, 1, nom, prenom);
                Eleves.add(el);
               System.out.println("Inscription réussie!!! ");


                break;
            case 2 :
                System.out.println("SUPPRESSION D'UN ÉLÈVE ");
                System.out.println("Inscrire le nom de l'élève à supprimer : ");
                nom = sc.next();
                stmt.executeUpdate("DELETE FROM personne where type = 1 and nom = " + "\"" +nom + "\"" );
                rset = stmt.executeQuery("select id from personne where type = 1 and nom = " + "\"" + nom + "\""  );
                while(rset.next())
                {                 
                  int idEleveSupp = rset.getInt("id");
      
                  Personne p  = Eleves.get(idEleveSupp);
                  Eleves.remove(p);
                   
                }
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

                        break;
                    case 2 :
                        System.out.println("Tapez l'id de l'élève que vous souhaitez modifier : ");
                        id = sc.nextInt();
                        System.out.println("Nouveau prénom de l'élève : ");
                        newPrenom = sc.next();
                        stmt.executeUpdate("UPDATE personne SET nom = " + "\"" +newPrenom + "\"" + "WHERE type = 1 AND id = " + "\"" + id + "\"" );
                        System.out.println("Prénom de l'élève modifié");
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

                  rset = stmt.executeQuery("select id from personne where type = 2 and nom = " + "\"" + nom + "\""  );
                  rset.next();                  
                  int idProf = rset.getInt("id");
                    
               Personne prof = new Personne(idProf, 1, nom, prenom);
                Profs.add(prof);
               System.out.println("Inscription réussie!!! ");
                break; 
            case 5 :
                System.out.println("SUPPRESSION D'UN PROF ");
                System.out.println("Inscrire le nom du prof à supprimer : ");
                nom = sc.next();
                stmt.executeUpdate("DELETE FROM personne where type = 2 and nom = " + "\"" +nom + "\"" );
                rset = stmt.executeQuery("select id from personne where type = 2 and nom = " + "\"" + nom + "\""  );
                while(rset.next())
                {                 
                  int idEleveSupp = rset.getInt("id");
      
                  Personne p  = Profs.get(idEleveSupp);
                  Profs.remove(p);
                   
                }
                System.out.println("Eleve supprimé de la base de donnée ");
               
               
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
                        stmt.executeUpdate("UPDATE personne SET nom = " + "\"" +newNom + "\"" + "WHERE type = 2 AND id = " + "\"" + id + "\"" );
                        System.out.println("Nom du prof  modifié ");

                        break;
                    case 2 :
                        System.out.println("Tapez l'id du prof que vous souhaitez modifier : ");
                        id = sc.nextInt();
                        System.out.println("Nouveau prénom du prof : ");
                        newPrenom = sc.next();
                        stmt.executeUpdate("UPDATE personne SET nom = " + "\"" +newPrenom + "\"" + "WHERE type = 2 AND id = " + "\"" + id + "\"" );
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
