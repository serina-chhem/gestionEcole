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
import modele.affichagebulletin;

/**
 *
 * @author Hugo
 */
public class Bulletin extends javax.swing.JFrame {

    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";
    int pId;
    /**
     * Creates new form Bulletin
     */
    public Bulletin() throws ClassNotFoundException, SQLException {
        initComponents();
        afficher_note();
    }
    public Bulletin(int pId) throws ClassNotFoundException, SQLException {
        initComponents();
        this.pId = pId;
        afficher_note();
        afficher_nom();

    }
    
      public int getId(){
        return pId;
    }
      
        public ArrayList<affichagebulletin> listenote() throws ClassNotFoundException, SQLException{
        
        ArrayList<affichagebulletin> listenote = new ArrayList<>();
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT e.note, e.appreciation, d.moyenneG, n.nom, b.trimestre_id FROM evaluation e inner join detailbulletin d on e.detailBulletin_id = d.id inner join bulletin b on b.id=d.bulletin_id inner join inscription i on i.id = b.inscription_id inner join enseignement en on d.enseignement_id = en.id INNER JOIN discipline n on en.discipline_id = n.id INNER join personne p on " + pId + " = p.id");
            while(rset.next()){
                affichagebulletin c = new affichagebulletin();
                c.setNote(rset.getInt("note"));
                System.out.println(c.getId());
                c.setAppre(rset.getString("appreciation"));
                System.out.println(c.getNote());
                c.setModule(rset.getString("nom"));
                c.setMoyenne(rset.getFloat("moyenneG"));
                c.setTrimestre(rset.getInt("trimestre_id"));
                listenote.add(c);
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        return listenote;
        
    }
        
         public void afficher_note() throws ClassNotFoundException, SQLException{
        ArrayList<affichagebulletin> list = listenote();
        DefaultTableModel model =  (DefaultTableModel)Listenote.getModel();
        Object[] row = new Object[5];
        for(int i =0;i<list.size();i++)
        {
            row[0]=list.get(i).getModule();
            row[1]=list.get(i).getNote();
            row[2]=list.get(i).getMoyenne();
            row[3]=list.get(i).getAppre();
            row[4]=list.get(i).getTrimestre();

            model.addRow(row);
            
        }
    }
       public void afficher_nom() throws ClassNotFoundException, SQLException{
       try{
            String nomprenom;
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT nom, prenom FROM personne WHERE id = " + pId);
            while(rset.next()){
                this.champsNom.setText(  String.valueOf( rset.getString("nom")) + " " + String.valueOf( rset.getString("prenom")));
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
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
        Listenote = new javax.swing.JTable();
        label1 = new java.awt.Label();
        champsNom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Listenote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module", "Note Eleve", "Moyenne", "Appreciation", "Trimestre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Listenote);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Bulletin de ");

        champsNom.setEditable(false);
        champsNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        champsNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champsNomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(champsNom, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(champsNom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void champsNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champsNomActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_champsNomActionPerformed

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
            java.util.logging.Logger.getLogger(Bulletin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bulletin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bulletin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bulletin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Bulletin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Bulletin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Bulletin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Listenote;
    private javax.swing.JTextField champsNom;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
