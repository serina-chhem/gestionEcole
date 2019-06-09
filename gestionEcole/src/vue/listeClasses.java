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
import modele.Classe;
import modele.Discipline;

/**
 *
 * @author serina
 */
public class listeClasses extends javax.swing.JFrame {
    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";
    int pId;
    

    /**
     * Creates new form listeClasses
     */
    public listeClasses() throws ClassNotFoundException, SQLException {
        initComponents();
        afficherClasses();
    }
    
    public listeClasses(int pId) throws ClassNotFoundException, SQLException{
        initComponents();
        afficherClasses();
        this.pId = pId;
        //System.out.println(pId);
          
    }
    
    public int getId(){
        return pId;
    }
    
   
    
    public ArrayList<Classe> listeClasse() throws ClassNotFoundException, SQLException{
        
        ArrayList<Classe> listeClasse = new ArrayList<>();
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select * from classe");
            while(rset.next()){
                Classe c = new Classe();
                c.setId(rset.getInt("id"));
                c.setNom(rset.getString("nom"));
                c.setAnneeScolaireId(rset.getInt("anneeScolaire_id"));
                c.setNiveauId(rset.getInt("niveau_id"));   
                listeClasse.add(c);
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        return listeClasse;
        
    }
    
    
public void afficherClasses() throws ClassNotFoundException, SQLException{
        
        ArrayList<Classe> liste = listeClasse();
        DefaultTableModel model =  (DefaultTableModel)listeClasse.getModel();
        Object[] row = new Object[4];
        for(int i =0;i<liste.size();i++)
        {
            row[0]=liste.get(i).getId();
            row[1]=liste.get(i).getNom();
            row[2]=liste.get(i).getAnneeScolaireId();
            row[3]=liste.get(i).getNiveauId();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeClasse = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listeClasse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "TD", "Id année scolaire", "Niveau"
            }
        ));
        listeClasse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeClasseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeClasse);

        jLabel1.setText("SÉLECTIONNER LA CLASSE DANS LAQUELLE VOUS SOUHAITEZ INSCRIRE L'ÉTUDIANT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeClasseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeClasseMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model =  (DefaultTableModel)listeClasse.getModel();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
            
            //ArrayList<Classe> liste = listeClasse();
            int selectedRowIndex = listeClasse.getSelectedRow();
            String cell =  listeClasse.getModel().getValueAt(selectedRowIndex, 0).toString();
            
       
            String sql = "INSERT INTO inscription(classe_id, personne_id) VALUES (?,?);" ;
       
            pst = conn.prepareStatement(sql);
            pst.setString(1, cell );
            
            pst.setInt(2, getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inscription dans la classe réussie !!");
            
            inscriptionClasse ins = new inscriptionClasse();
            ins.setVisible(true);


            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Eleve deja inscrit dans une classe");

                Logger.getLogger(listeClasses.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Eleve deja inscrit dans une classe");
                Logger.getLogger(listeClasses.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }//GEN-LAST:event_listeClasseMouseClicked

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
            java.util.logging.Logger.getLogger(listeClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listeClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listeClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listeClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new listeClasses().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(listeClasses.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(listeClasses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeClasse;
    // End of variables declaration//GEN-END:variables
}
