/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninscription;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.GestionBdd;

import java.awt.*;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
/**
 *
 * @author C103-image
 */
public class FenSessions extends javax.swing.JFrame {

    /**
     * Creates new form FenSessions
     */
    Statement stmt1, stmt2;
    public FenSessions() {
        initComponents();
    }
    
//    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
//        stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
//    } 
//    private void formWindowActivated(java.awt.event.WindowEvent evt) throws SQLException {                                     
//        renseigne();
//    } 
    private void renseigne() throws SQLException
    {
        btnFeuille.setVisible(false);
        try
        {
        // On vide le JTable
            int j, k;
            String req;
             for(int i=0;i<tableSession.getRowCount();i++)
            {
                for (j=0;j<tableSession.getColumnCount();j++)
		{
                    tableSession.setValueAt(null,i,j);
		}
            }
            String format = "yyyy-MM-dd";
            java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
            java.util.Date date = new java.util.Date(); 
           
            req = "SELECT `numero`,`datedebut`,`libelleform`,`niveauform`,`nb_places`,`nb_inscrits`,`close`from session_form ";
            req += "Where 'datedebut' > '"+ formater.format(date)+"' And close = 0 order by `datedebut` ";
            stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root",""); 
            ResultSet rs2 = GestionBdd.envoiRequeteLMD(stmt1, req);
            k=0;
            while(rs2.next())
            {
                    
                for (j=0;j<(tableSession.getColumnCount() );j++)
                {
                    
                    tableSession.setValueAt(rs2.getObject(j+1), k, j);
                    
                }
                k++;
            }
            rs2.close();
        }
        catch(NullPointerException npe)
        {
            System.out.println("Erreur : " + npe.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSession = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnFeuille = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DES INSCRIPTIONS");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableSession.setModel(new ModeleSession());
        tableSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSessionMouseClicked(evt);
            }
        });
        tableSession.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tableSessionInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tableSession);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GESTION DES SESSIONS");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnFeuille.setText("Création de la feuille d'émargement");
        btnFeuille.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFeuilleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addComponent(btnFeuille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnFeuille)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSessionMouseClicked
       if(tableSession.getValueAt(tableSession.getSelectedRow(), 0) != null) //permet de savoir si on a selectionner quelque chose ou non
       {
           btnFeuille.setVisible(true);           
       }
       else
       {
           btnFeuille.setVisible(false);
       }
    }//GEN-LAST:event_tableSessionMouseClicked

    private void tableSessionInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tableSessionInputMethodTextChanged
        //
    }//GEN-LAST:event_tableSessionInputMethodTextChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            renseigne();
        } catch (SQLException ex) {
            Logger.getLogger(FenSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated
    private final static String out = "contents2.pdf";
    private void btnFeuilleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeuilleMouseClicked
        String req;
        
        req = "select numero, libelleform, niveauform, datedebut, nb_places, nb_inscrits, c.matricule, nom, typestatut, rue, cp, ville ";
        req += "from session_form s, inscription i, client c where s.numero = i.num_session and i.matricule = c.matricule and s.numero =" + tableSession.getValueAt(tableSession.getSelectedRow(),0);
        stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root",""); 
        ResultSet rs2 = GestionBdd.envoiRequeteLMD(stmt1, req);
        Document document = new Document(PageSize.A4);
        System.out.println(req); 
	try {
            // etape 2:
            // creation du writer -> PDF ou HTML 
            PdfWriter.getInstance(document, new FileOutputStream(out));
                      	
            // etape 3: Ouverture du document
            document.open();
           
            // etape 4: Ajout du contenu au document
            document.add(new Phrase("texte dans le pdf"));
           
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        // etape 5: Fermeture du document
        document.close();
        System.out.println("Document '"+out+"' generated");
    }//GEN-LAST:event_btnFeuilleMouseClicked

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
            java.util.logging.Logger.getLogger(FenSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenSessions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFeuille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSession;
    // End of variables declaration//GEN-END:variables
}
