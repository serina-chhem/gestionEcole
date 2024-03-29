/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modele.Inscription;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author serina
 */
public final class inscriptionClasse extends javax.swing.JFrame {
    
    Statement stmt;
    Connection conn;
    ResultSet rset;
    PreparedStatement pst;
    String nameDatabase = "ecole";
    String loginDatabase = "root";
    String passwordDatabase = "root";

    /**
     * Creates new form inscriptionClasse
     * @throws java.lang.ClassNotFoundException
     */
    public inscriptionClasse() throws ClassNotFoundException {
        initComponents();
        afficherInscriptions();
    }
    
    public ArrayList<Inscription> personneList() throws ClassNotFoundException{
                ArrayList<Inscription> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            
            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            
            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();
            String sql = "SELECT c.nom as td, c.anneeScolaire_id, n.nom as niveau, i.classe_id, i.personne_id, p.nom, p.prenom FROM classe c inner join inscription i on i.classe_id = c.id left join personne p on p.id = i.personne_id INNER JOIN niveau n on c.niveau_id = n.id";
            rset = stmt.executeQuery(sql);
            
            while(rset.next())
            {
                Inscription i = new Inscription();
              //  i.setId(rset.getInt("id"));
                i.setTD(rset.getString("td"));
                i.setAnneeSco(rset.getInt("anneeScolaire_id"));
                i.setNiveau(rset.getString("niveau"));
                i.setClasseId(rset.getInt("classe_id"));
                i.setPersonneId(rset.getInt("personne_id"));
                i.setNom(rset.getString("nom"));
                i.setPrenom(rset.getString("prenom"));
                
                list.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gestionEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
     public void afficherInscriptions() throws ClassNotFoundException{
        ArrayList<Inscription> list = personneList();
        DefaultTableModel model =  (DefaultTableModel)tabInscription.getModel();
        Object[] row = new Object[7];
        for(int i =0;i<list.size();i++)
        {
          //  row[0]=list.get(i).getId();
            row[0]=list.get(i).getTD();
            row[1]=list.get(i).getAnneeId();
            row[2]=list.get(i).getNiveau();
            row[3]=list.get(i).getClasseId();
            row[4]=list.get(i).getPersonneId();
            row[5]=list.get(i).getPersNom();
            row[6]=list.get(i).getPersPrenom();
          
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
        tabInscription = new javax.swing.JTable();
        boutonHistogramme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabInscription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TD", "Annee Scolaire ID", "Niveau", "Classe ID", "Étudiants ID de la classe", "Nom étudiant", "Prénom étudiant"
            }
        ));
        jScrollPane1.setViewportView(tabInscription);

        boutonHistogramme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/histp.png"))); // NOI18N
        boutonHistogramme.setText("Afficher l'histogramme");
        boutonHistogramme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonHistogrammeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(boutonHistogramme)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(boutonHistogramme)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonHistogrammeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonHistogrammeActionPerformed
        // TODO add your handling code here:
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            stmt = conn.createStatement();
           // String sql = "select count(classe_id) as number from inscription where classe_id = 1";
            
            String sql = "SELECT classe_id, count( `classe_id`) as nombreEtudiants from inscription GROUP by classe_id";
            rset = stmt.executeQuery(sql);     
            
            
           // DefaultTableModel model =  (DefaultTableModel)tabInscription.getModel();

      //  int classeID = tabInscription.getModel().getValueAt(row_index, 4);
             DefaultCategoryDataset d = new DefaultCategoryDataset();

            while(rset.next()){

                
                d.setValue(rset.getInt("nombreEtudiants"), "Classe", rset.getString("classe_id"));            

            }
            JFreeChart graph = ChartFactory.createBarChart("Nb d'étudiants dans une classe", "Classe", "Etudiants", d, PlotOrientation.HORIZONTAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
            CategoryPlot plot = graph.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.black);
            ChartFrame chartFrm = new ChartFrame("Nb d'étudiants dans une classe", graph, true);
            chartFrm.setVisible(true);
            chartFrm.setSize(1000,800);
            

            
        }
        
        catch(SQLException e){
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(inscriptionClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_boutonHistogrammeActionPerformed

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
            java.util.logging.Logger.getLogger(inscriptionClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inscriptionClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inscriptionClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inscriptionClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new inscriptionClasse().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(inscriptionClasse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonHistogramme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabInscription;
    // End of variables declaration//GEN-END:variables
}
