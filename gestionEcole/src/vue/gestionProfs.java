/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

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
import modele.Personne;

/**
 *
 * @author dePlanta
 */
public class gestionProfs extends javax.swing.JFrame {
    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";

    /** Creates new form ApresEleve */
    public gestionProfs() throws ClassNotFoundException {
        initComponents();
        afficher_profs();
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
            
            rset = stmt.executeQuery("select * from personne where type = 2"  );
            
            while(rset.next())
            {
                Personne e = new Personne();
                e.setId(rset.getInt("id"));
                e.setNom(rset.getString("nom"));
                e.setPrenom(rset.getString("prenom"));
                personneList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gestionProfs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personneList;
    }
    
    public void afficher_profs() throws ClassNotFoundException{
        ArrayList<Personne> list = personneList();
        DefaultTableModel model =  (DefaultTableModel)listeProfs.getModel();
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
        listeProfs = new javax.swing.JTable();
        boutonSupprimer = new javax.swing.JButton();
        boutonModifier = new javax.swing.JButton();
        boutonInscrire = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        champsNom = new javax.swing.JTextField();
        champsPrenom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        champsId = new javax.swing.JTextField();
        champsRecherche = new javax.swing.JTextField();
        boutonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LISTE DES PROFESSEURS");

        listeProfs.setModel(new javax.swing.table.DefaultTableModel(
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
        listeProfs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeProfsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeProfs);

        boutonSupprimer.setText("Supprimer l'enseignant selectionné");
        boutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSupprimerActionPerformed(evt);
            }
        });

        boutonModifier.setText("Modifier l'enseignant sélectionné");
        boutonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonModifierActionPerformed(evt);
            }
        });

        boutonInscrire.setText("Inscrire un nouvel enseignant");
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

        champsRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champsRechercheActionPerformed(evt);
            }
        });

        boutonSearch.setText("Rechercher par ID");
        boutonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(champsId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(champsNom, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(champsPrenom)))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boutonSupprimer, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(boutonInscrire, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(boutonModifier)
                                .addGap(57, 57, 57)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(champsRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonSearch)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champsRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(champsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(champsNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(champsPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(boutonInscrire)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonModifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonSupprimer)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSupprimerActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model =  (DefaultTableModel)listeProfs.getModel();
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            
          
        int selectedRowIndex = listeProfs.getSelectedRow();
        model.removeRow(selectedRowIndex);
        
   
        String sql = "delete from personne where id = " + champsId.getText();//REQUETE MARCHE PAS car mauvaise vvaleur de cellule
        
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            
        }catch(Exception e){
            
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_boutonSupprimerActionPerformed

    private void boutonInscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonInscrireActionPerformed
        // TODO add your handling code here:
        AddEnseignant add = new AddEnseignant();
        add.setVisible(true);
     
        
    }//GEN-LAST:event_boutonInscrireActionPerformed

    private void boutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonModifierActionPerformed
        // TODO add your handling code here:
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();


            String sql = "UPDATE personne SET nom = ' " +  champsNom.getText() + " ', prenom = ' " + champsPrenom.getText()+ "' WHERE type = 2 AND id = " + champsId.getText()  ;
            
            stmt.executeUpdate(sql);
            gestionProfs liste = new gestionProfs();
            liste.setVisible(true);
        
               
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e);

        }

        
        
    }//GEN-LAST:event_boutonModifierActionPerformed

    private void champsNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champsNomActionPerformed

    private void champsPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champsPrenomActionPerformed

    private void listeProfsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeProfsMouseClicked
        // TODO add your handling code here:
        int i = listeProfs.getSelectedRow();
        DefaultTableModel model =  (DefaultTableModel)listeProfs.getModel();
        champsId.setText(model.getValueAt(i, 0).toString());
        champsNom.setText(model.getValueAt(i, 1).toString());
        champsPrenom.setText(model.getValueAt(i, 2).toString());
        
    }//GEN-LAST:event_listeProfsMouseClicked

    private void boutonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSearchActionPerformed
        // TODO add your handling code here:
        
        try{
            
        Class.forName("com.mysql.jdbc.Driver");
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
        stmt = conn.createStatement();
        pst = conn.prepareStatement("select * from personne where type = 2 and id = ?");
        pst.setString(1, champsRecherche.getText());
       
        rset = pst.executeQuery();
        
                while(rset.next()){
                    champsId.setText(champsRecherche.getText());
                    champsNom.setText(rset.getString("nom"));
                    champsPrenom.setText(rset.getString("prenom"));

                }
        
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(gestionProfs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Le professeur que vous recherchez n'existe pas...");
            Logger.getLogger(gestionProfs.class.getName()).log(Level.SEVERE, null, e);

            
        } 
    }//GEN-LAST:event_boutonSearchActionPerformed

    private void champsRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsRechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champsRechercheActionPerformed

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
            java.util.logging.Logger.getLogger(gestionProfs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionProfs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionProfs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionProfs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                    new gestionProfs().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(gestionProfs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonInscrire;
    private javax.swing.JButton boutonModifier;
    private javax.swing.JButton boutonSearch;
    private javax.swing.JButton boutonSupprimer;
    private javax.swing.JTextField champsId;
    private javax.swing.JTextField champsNom;
    private javax.swing.JTextField champsPrenom;
    private javax.swing.JTextField champsRecherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeProfs;
    // End of variables declaration//GEN-END:variables

}
