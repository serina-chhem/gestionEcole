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
import modele.Discipline;

/**
 *
 * @author serina
 */

//Classe Discipline 
public final class listeDiscipline extends javax.swing.JFrame {
    
    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";
    int discId, persId;
    int classeId ;

    /**
     * Creates new form listeDiscipline
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    
    //Constructeur par defaut
    public listeDiscipline() throws ClassNotFoundException, SQLException {
        initComponents();
        afficherDisciplines();
    }
    
    //Getters et setters
    public int getClasseId(){
        return classeId;
    }
    public void setClasseId(int classeId){
        this.classeId = classeId;
    }
     public int getPersId(){
        return persId;
    }
    public void setPersId(int pId){
        this.persId = pId;
    }
     public int getDiscId(){
        return discId;
    }
    public void setDiscId(int discId){
        this.discId = discId;
    }
    
    //constructeur 
    public listeDiscipline(int cId, int dId, int pId) throws ClassNotFoundException, SQLException{
        initComponents();
        assignerMatiere(cId, dId, pId);

        afficherDisciplines();
        this.classeId = cId;
        this.persId = pId;
        this.discId = dId;
    }
    
    
    //inscrire un prof a une matiere et une classe
    public void assignerMatiere(int cId, int dId, int pId) throws ClassNotFoundException{
        
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
             String sql = "INSERT INTO enseignement(classe_id, discipline_id, personne_id ) VALUES ('" + cId + "',' " + dId + "',' " + pId + "')" ;
       

            pst = conn.prepareStatement(sql);
//            pst.setInt(1, cId);
//            pst.setInt(2, dId);
//            pst.setInt(3, pId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DONE");

            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    
    //Liste des disciplines 
    public ArrayList<Discipline> listeDiscipline() throws ClassNotFoundException, SQLException{
        
        ArrayList<Discipline> listeDiscipline = new ArrayList<>();
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select e.id as disciplineID , e.classe_id as classeId, d.nom as matiere, p.nom as enseignant from enseignement e inner join discipline d on e.discipline_id = d.id inner join personne p on e.personne_id = p.id order by e.id ASC");
            while(rset.next()){
                Discipline d = new Discipline();
                d.setId(rset.getInt("disciplineID"));
                d.setClasseId(rset.getInt("classeId"));
                d.setNom(rset.getString("matiere"));
                d.setNomE(rset.getString("enseignant"));
                listeDiscipline.add(d);
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        return listeDiscipline;
        
    }
    
    public void afficherDisciplines() throws ClassNotFoundException, SQLException{
        
        ArrayList<Discipline> liste = listeDiscipline();
        DefaultTableModel model =  (DefaultTableModel)listeDisc.getModel();
        Object[] row = new Object[4];
        for(int i =0;i<liste.size();i++)
        {
            row[0]=liste.get(i).getId();
            row[1]=liste.get(i).getClasseId();
           
            row[2]=liste.get(i).getNom();
            row[3]=liste.get(i).getNomE();

            model.addRow(row);
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listeDisc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listeDisc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Classe ID", "Matière", "Enseignant"
            }
        ));
        listeDisc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeDiscMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeDisc);

        jLabel1.setText("Liste des enseignements");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/retour.png"))); // NOI18N
        jButton1.setText("Retour vers la liste des professeurs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeDiscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeDiscMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_listeDiscMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try {
            gestionProfs g;
            g = new gestionProfs();
            g.setVisible(true);
            g.setSize(1000,700);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listeDiscipline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(listeDiscipline.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(listeDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listeDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listeDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listeDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new listeDiscipline().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(listeDiscipline.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeDisc;
    // End of variables declaration//GEN-END:variables
}
