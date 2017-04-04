/*
 * This version of the project contains my approach for the Search Engine 
 * project. Anything that is useful will be integrated into the main project.
 * This is not to be used as the main project submission. -Kelvin
 */
/**
 *
 * @author Kelvin
 */
package com.bkj.search.GomezGUI;
import com.bkj.search.GomezClasses.FileManager;
import com.bkj.search.GomezClasses.Mapping;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class Maintenance extends javax.swing.JFrame {    
    private DefaultListModel list = new DefaultListModel();
    private Mapping map = new Mapping();
    private FileManager fm;
    /**
     * Creates new form Maintenance
     */
    public Maintenance() {
        initComponents();
        // Start: Loads data from InFile upon window init
        fm = new FileManager();
        try {
            fm.readFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found.","Error",
            JOptionPane.PLAIN_MESSAGE);
        }
        
        int contents = fm.list.size();
        String str;
        for(int i = 0; i < contents; i++){
            str = fm.list.get(i);
            list.addElement(str);
        }
        list_Files.setModel(list);
        // End
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_MaintenanceHeading = new javax.swing.JLabel();
        button_AddFile = new javax.swing.JButton();
        button_RemoveFile = new javax.swing.JButton();
        button_RebuildList = new javax.swing.JButton();
        button_CloseWindow = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Files = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_MaintenanceHeading.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        label_MaintenanceHeading.setText("INDEX MAINTENANCE");

        button_AddFile.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_AddFile.setText("Add File...");
        button_AddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AddFileActionPerformed(evt);
            }
        });

        button_RemoveFile.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_RemoveFile.setText("Remove File");
        button_RemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RemoveFileActionPerformed(evt);
            }
        });

        button_RebuildList.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_RebuildList.setText("Rebuild");
        button_RebuildList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RebuildListActionPerformed(evt);
            }
        });

        button_CloseWindow.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_CloseWindow.setText("Close");
        button_CloseWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CloseWindowActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list_Files);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(button_AddFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_RemoveFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_RebuildList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_CloseWindow))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(label_MaintenanceHeading)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button_AddFile, button_CloseWindow, button_RebuildList, button_RemoveFile});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label_MaintenanceHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(button_AddFile)
                    .addComponent(button_RemoveFile)
                    .addComponent(button_CloseWindow)
                    .addComponent(button_RebuildList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button_AddFile, button_CloseWindow, button_RebuildList, button_RemoveFile});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Closes this window and returns user to main window. -Kelvin
     * @param evt 
     */
    private void button_CloseWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CloseWindowActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_button_CloseWindowActionPerformed
    /**
     * Rebuilds the Index. -Kelvin
     * @param evt 
     */
    private void button_RebuildListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RebuildListActionPerformed
        try {
            map.map(fm.list);
        } catch (IOException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_RebuildListActionPerformed
    /**
     * Adds files to the file list. -Kelvin
     * @param evt 
     */
    private void button_AddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddFileActionPerformed
        int result = fm.getPathStr();
        if(result == 0){
            int index = fm.list.size() -1;
            list.addElement(fm.list.get(index));
            try {
                fm.writeToFile(fm.list.get(index));
            } catch (IOException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
            list_Files.setModel(list);
        }else{
            JOptionPane.showMessageDialog(null,"Operation canceled","Warning",
                JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_button_AddFileActionPerformed
    /**
     * Removes selected file from the file list. -Kelvin
     * @param evt 
     */
    private void button_RemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RemoveFileActionPerformed

        try {
            int delete = list_Files.getSelectedIndex();
            if(list_Files.getSelectedIndex() >= 0){
                list.removeElementAt(delete);
                fm.list.remove(delete);
                new FileManager().clearFile();
                int content = fm.list.size();
                for(int i =0; i < content; i++){
                    fm.writeToFile(fm.list.get(i));
                }
            }else{
                JOptionPane.showMessageDialog(null,"No file selected","Warning",
                JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        list_Files.setModel(list);
    }//GEN-LAST:event_button_RemoveFileActionPerformed
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws java.io.IOException {
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
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Maintenance().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_AddFile;
    private javax.swing.JButton button_CloseWindow;
    private javax.swing.JButton button_RebuildList;
    private javax.swing.JButton button_RemoveFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_MaintenanceHeading;
    private javax.swing.JList<String> list_Files;
    // End of variables declaration//GEN-END:variables
}