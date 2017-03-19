package GUI;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Llaneras
 */
public class Files_UI extends javax.swing.JFrame {

    /**
     * Creates new form Files_UI
     */
    public Files_UI() {
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

        filesPanel = new javax.swing.JPanel();
        filesTitleLabel = new javax.swing.JLabel();
        fileAddButton = new javax.swing.JButton();
        filesScrollPane = new javax.swing.JScrollPane();
        filesTextArea = new javax.swing.JTextArea();
        fileRemoveButton = new javax.swing.JButton();

        filesTitleLabel.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        filesTitleLabel.setText("Add/Remove Files");

        fileAddButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fileAddButton.setText("Add");
        fileAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileAddButtonActionPerformed(evt);
            }
        });

        filesTextArea.setColumns(20);
        filesTextArea.setRows(5);
        filesScrollPane.setViewportView(filesTextArea);

        fileRemoveButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fileRemoveButton.setText("Remove");
        fileRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileRemoveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filesPanelLayout = new javax.swing.GroupLayout(filesPanel);
        filesPanel.setLayout(filesPanelLayout);
        filesPanelLayout.setHorizontalGroup(
            filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filesPanelLayout.createSequentialGroup()
                        .addComponent(filesTitleLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(filesPanelLayout.createSequentialGroup()
                        .addGroup(filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fileAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(fileRemoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                .addContainerGap())
        );
        filesPanelLayout.setVerticalGroup(
            filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filesTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filesPanelLayout.createSequentialGroup()
                        .addComponent(fileAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(filesPanelLayout.createSequentialGroup()
                        .addComponent(filesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileAddButtonActionPerformed
    
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Users"));
        chooser.setDialogTitle("File Explorer");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file;
            file = chooser.getSelectedFile();
            String pathName = file.toString().trim();
            System.out.println(pathName);
            filesTextArea.append(pathName + "\n");
        } else if (chooser.showOpenDialog(null) == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null,"ALERT MESSAGE","TITLE",JOptionPane.WARNING_MESSAGE);
        }
        
       /* File_Add file = new File_Add() {};
        file.run();
        filesTextArea.append(pathName + "\n"); */    
    }//GEN-LAST:event_fileAddButtonActionPerformed

    private void fileRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileRemoveButtonActionPerformed
        String textToBeDeleted = filesTextArea.getText();
        int length = textToBeDeleted.length();
        filesTextArea.replaceRange(" ", 0, length);
        System.out.println(textToBeDeleted);
    }//GEN-LAST:event_fileRemoveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Files_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Files_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Files_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Files_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Files_UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fileAddButton;
    private javax.swing.JButton fileRemoveButton;
    private javax.swing.JPanel filesPanel;
    private javax.swing.JScrollPane filesScrollPane;
    public static javax.swing.JTextArea filesTextArea;
    private javax.swing.JLabel filesTitleLabel;
    // End of variables declaration//GEN-END:variables
}
