/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controleur.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modele.Classe;
import modele.Personne;

/**
 *
 * @author dePlanta
 */
public class gestionEleve extends javax.swing.JFrame {
    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";

    /** Creates new form ApresEleve */
    public gestionEleve() throws ClassNotFoundException {
        initComponents();
        afficher_eleve();
    }
    
    public ArrayList<Personne> personneList() throws ClassNotFoundException{
                ArrayList<Personne> personneList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            
            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            
            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();
            
            rset = stmt.executeQuery("select * from personne where type = 1"  );
            
            while(rset.next())
            {
                Personne e = new Personne();
                e.setId(rset.getInt("id"));
                e.setNom(rset.getString("nom"));
                e.setPrenom(rset.getString("prenom"));
                personneList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personneList;
    }
    
    public void afficher_eleve() throws ClassNotFoundException{
        ArrayList<Personne> list = personneList();
        DefaultTableModel model =  (DefaultTableModel)listeEtudiants.getModel();
        Object[] row = new Object[3];
        for(int i =0;i<list.size();i++)
        {
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getNom();
            row[2]=list.get(i).getPrenom();
            model.addRow(row);
            
        }
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeEtudiants = new javax.swing.JTable();
        boutonSupprimer = new javax.swing.JButton();
        boutonModifier = new javax.swing.JButton();
        boutonInscrire = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        champsNom = new javax.swing.JTextField();
        champsPrenom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        champsId = new javax.swing.JTextField();
        boutonInscrireClasse = new javax.swing.JButton();
        voirBulletin = new javax.swing.JButton();
        boutonRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LISTE DES ÉTUDIANTS");

        listeEtudiants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listeEtudiants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeEtudiantsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeEtudiants);

        boutonSupprimer.setText("Supprimer l'éleve selectionné");
        boutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSupprimerActionPerformed(evt);
            }
        });

        boutonModifier.setText("Modifier l'élève sélectionné");
        boutonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonModifierActionPerformed(evt);
            }
        });

        boutonInscrire.setText("Inscrire un nouvel eleve");
        boutonInscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonInscrireActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom :");

        jLabel3.setText("Prénom :");

        champsNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champsNomActionPerformed(evt);
            }
        });

        champsPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champsPrenomActionPerformed(evt);
            }
        });

        jLabel4.setText("Identifiant :");

        boutonInscrireClasse.setText("Inscrire l'étudiant à une classe");
        boutonInscrireClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonInscrireClasseActionPerformed(evt);
            }
        });

        voirBulletin.setText("Voir bulletin de l'élève");
        voirBulletin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voirBulletinActionPerformed(evt);
            }
        });

        boutonRetour.setText("Retour");
        boutonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonModifier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonSupprimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonInscrire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonInscrireClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(champsId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(champsNom, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champsPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(voirBulletin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(boutonRetour)
                .addGap(217, 217, 217)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(boutonRetour))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(champsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champsNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(champsPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(voirBulletin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonInscrireClasse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonInscrire)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonModifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonSupprimer)))
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSupprimerActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model =  (DefaultTableModel)listeEtudiants.getModel();
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
//            String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            
          
        int selectedRowIndex = listeEtudiants.getSelectedRow();
        model.removeRow(selectedRowIndex);
        
   //ALTER TABLE inscription add CONSTRAINT `personne_id` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`);
        String sql1 = "delete from inscription where personne_id = " + champsId.getText();
        
         try{
                    pst = conn.prepareStatement(sql1);
                    pst.execute();

                }catch(Exception e){
                     JOptionPane.showMessageDialog(null, e);

                }
        
        String sql = "delete from personne  where id = " + champsId.getText();//REQUETE MARCHE PAS car mauvaise vvaleur de cellule
        
                try{
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, " " + champsPrenom.getText()+ " a été supprimé de sa classe");

                    inscriptionClasse iC = new inscriptionClasse();
                    iC.setVisible(true);

                }catch(Exception e){
                     JOptionPane.showMessageDialog(null, " " + champsPrenom.getText()+ " ne peut pas être supprimé car il ne fait pas parti d'une classe" );

                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_boutonSupprimerActionPerformed

    private void boutonInscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonInscrireActionPerformed
        // TODO add your handling code here:
        AddEleve add = new AddEleve();
        add.setVisible(true);
     
        
    }//GEN-LAST:event_boutonInscrireActionPerformed

    private void boutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonModifierActionPerformed
        // TODO add your handling code here:
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

            //String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();


            String sql = "UPDATE personne SET nom = ' " +  champsNom.getText() + " ', prenom = ' " + champsPrenom.getText()+ "' WHERE type = 1 AND id = " + champsId.getText()  ;
            
            stmt.executeUpdate(sql);
            gestionEleve liste = new gestionEleve();
            liste.setVisible(true);
        
               
        } catch(Exception e){
              JOptionPane.showMessageDialog(null, e);

        }

        
        
    }//GEN-LAST:event_boutonModifierActionPerformed

    private void champsNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champsNomActionPerformed

    private void champsPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champsPrenomActionPerformed

    private void listeEtudiantsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeEtudiantsMouseClicked
        // TODO add your handling code here:
        int i = listeEtudiants.getSelectedRow();
        DefaultTableModel model =  (DefaultTableModel)listeEtudiants.getModel();
        champsId.setText(model.getValueAt(i, 0).toString());
        champsNom.setText(model.getValueAt(i, 1).toString());
        champsPrenom.setText(model.getValueAt(i, 2).toString());
        
         
           
    }//GEN-LAST:event_listeEtudiantsMouseClicked

      
    
    private void boutonInscrireClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonInscrireClasseActionPerformed
        // TODO add your handling code here:
       int id = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//        String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;

            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();

            rset = stmt.executeQuery("select * from personne where type = 1 and id = " + champsId.getText() );
            while(rset.next()){
                id = rset.getInt("id");
            }
            new listeClasses(id).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cet eleve est deja inscrit dans une classe... ");

            Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_boutonInscrireClasseActionPerformed

    private void voirBulletinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voirBulletinActionPerformed
        // TODO add your handling code here:
     int id = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
                        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

            //String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();

            rset = stmt.executeQuery("select * from personne where type = 1 and id = " + champsId.getText() );
            while(rset.next()){
                id = rset.getInt("id");
            }
            new Bulletin(id).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_voirBulletinActionPerformed

    private void boutonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonRetourActionPerformed
        // TODO add your handling code here:
        connexionAdmin c = new connexionAdmin();
        c.setVisible(true);
    }//GEN-LAST:event_boutonRetourActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gestionEleve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionEleve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionEleve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionEleve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new gestionEleve().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonInscrire;
    private javax.swing.JButton boutonInscrireClasse;
    private javax.swing.JButton boutonModifier;
    private javax.swing.JButton boutonRetour;
    private javax.swing.JButton boutonSupprimer;
    private javax.swing.JTextField champsId;
    private javax.swing.JTextField champsNom;
    private javax.swing.JTextField champsPrenom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeEtudiants;
    private javax.swing.JButton voirBulletin;
    // End of variables declaration//GEN-END:variables

}
