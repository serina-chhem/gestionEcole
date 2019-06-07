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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.Personne;

/**
 *
 * @author dePlanta
 */
public class AddEnseignant extends javax.swing.JFrame {
    
    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";
    

    /**
     * Creates new form AddEleve
     */
    public AddEnseignant() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        champsNom = new javax.swing.JTextField();
        champsPrenom = new javax.swing.JTextField();
        bouttonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("INSCRIPTION D'UN NOUVEAU PROF");

        jLabel2.setText("Ajouter Nom :");

        jLabel3.setText("Ajouter Prénom :");

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

        bouttonValider.setText("Valider");
        bouttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(champsPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(champsNom, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(bouttonValider)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(champsNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(champsPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(bouttonValider)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void champsNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsNomActionPerformed

        
    }//GEN-LAST:event_champsNomActionPerformed

    private void champsPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsPrenomActionPerformed
        // TODO add your handling code here:
      

    }//GEN-LAST:event_champsPrenomActionPerformed

    private void bouttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonValiderActionPerformed

        // TODO add your handling code here:
        try{
         Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        
        String sql = "INSERT INTO personne(nom, prenom, type) VALUES (?,?,2)" ;
       

        pst = conn.prepareStatement(sql);
        pst.setString(1, champsNom.getText());
        pst.setString(2, champsPrenom.getText());
       
        pst.executeUpdate();
        gestionProfs liste = new gestionProfs();
        ArrayList<Personne> tabProfs = liste.personneList();

        liste.setVisible(true);
  
        JOptionPane.showMessageDialog(null, "Inscription réussie !!");
        conn.close();
        
 
     }
     catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
     } 
     catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex);
     }
        
        
    }//GEN-LAST:event_bouttonValiderActionPerformed

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
            java.util.logging.Logger.getLogger(AddEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
 
      
       // conn.executeUpdate("INSERT INTO personne(nom, prenom, type) VALUES ( "  + "\"" +nom + "\"" + ", " + "\""  + prenom  + "\"" + ", " + "\"" + 1 + "\"" +" ); ");
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AddEnseignant().setVisible(true);
     
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouttonValider;
    private javax.swing.JTextField champsNom;
    private javax.swing.JTextField champsPrenom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
