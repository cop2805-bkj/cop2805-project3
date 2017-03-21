package GUI;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jonathan Llaneras
 */
public class File_UI extends javax.swing.JFrame {
    
    private File_Add fileAdd;
    private DefaultListModel model = new DefaultListModel(); 
    private File file = new File("list.txt");
    /**
     * Creates new form Files_UI and reads text file
     */
    public File_UI() {
        initComponents();
        
        fileAdd = new File_Add() {};
        try {
            fileAdd.readFile();
        } catch(IOException e){
            
        }
        int size = fileAdd.list.size();
        String s;
        
        for (int i = 0; i < size; i++) {
            s = fileAdd.list.get(i);
            model.addElement(s);           
        }
        
        fileList.setModel(model);
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
        fileRemoveButton = new javax.swing.JButton();
        fileScrollPane = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList<>();

        filesTitleLabel.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        filesTitleLabel.setText("Add/Remove Files");

        fileAddButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fileAddButton.setText("Add");
        fileAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileAddButtonActionPerformed(evt);
            }
        });

        fileRemoveButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fileRemoveButton.setText("Remove");
        fileRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileRemoveButtonActionPerformed(evt);
            }
        });

        fileList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {" "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        fileScrollPane.setViewportView(fileList);

        javax.swing.GroupLayout filesPanelLayout = new javax.swing.GroupLayout(filesPanel);
        filesPanel.setLayout(filesPanelLayout);
        filesPanelLayout.setHorizontalGroup(
            filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filesPanelLayout.createSequentialGroup()
                        .addComponent(filesTitleLabel)
                        .addGap(0, 216, Short.MAX_VALUE))
                    .addGroup(filesPanelLayout.createSequentialGroup()
                        .addGroup(filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fileAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(fileRemoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
                    .addComponent(fileScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap())
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

    // Adds files with full pathname to the list
    private void fileAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileAddButtonActionPerformed
       fileAdd.getFileString();
       int arrayListSize = fileAdd.list.size() - 1;
       model.addElement(fileAdd.list.get(arrayListSize));
       try {
           fileAdd.writeToFile(fileAdd.list.get(arrayListSize));
       } catch(IOException e) {
           
       }
    }//GEN-LAST:event_fileAddButtonActionPerformed

    // Removes files by selection
    private void fileRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileRemoveButtonActionPerformed
        int i =  fileList.getSelectedIndex();
        model.removeElementAt(i);
        fileAdd.list.remove(i);
        file.delete();
        try {
            file.delete();
            file.createNewFile();
            int size = fileAdd.list.size();
            String s;
        
            for (int j = 0; j < size; j++) {
                fileAdd.writeToFile(fileAdd.list.get(j));
            }
        } catch (IOException ex) {
            Logger.getLogger(File_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        fileList.setModel(model);
    }//GEN-LAST:event_fileRemoveButtonActionPerformed

    public static void main(String args[]) {
       
        // Gets look and feel for UI with try catch
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(File_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the form 
        java.awt.EventQueue.invokeLater(() -> {
            new File_UI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fileAddButton;
    private javax.swing.JList<String> fileList;
    private javax.swing.JButton fileRemoveButton;
    private javax.swing.JScrollPane fileScrollPane;
    private javax.swing.JPanel filesPanel;
    private javax.swing.JLabel filesTitleLabel;
    // End of variables declaration//GEN-END:variables
}