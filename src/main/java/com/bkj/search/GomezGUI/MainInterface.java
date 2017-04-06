/*
 * This version of the project contains my approach for the Search Engine 
 * project. Anything that is useful will be integrated into the main project.
 * This is not to be used as the main project submission. -Kelvin
 */
package com.bkj.search.GomezGUI;
import com.bkj.search.GomezClasses.FileManager;
import com.bkj.search.GomezClasses.IndexSearchTools;
import com.bkj.search.GomezClasses.Mapping;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Kelvin
 */
public class MainInterface extends javax.swing.JFrame {
    private DefaultListModel list = new DefaultListModel();
    private IndexSearchTools search = new IndexSearchTools();
    private Mapping map = new Mapping();
    private FileManager fm;
    /**
     * Creates new form MainInterface
     * @throws java.io.IOException
     */
    public MainInterface() throws IOException {
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
        map.map(fm.list);
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

        Maintain = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Files = new javax.swing.JList<>();
        Header = new javax.swing.JLabel();
        DeleteFromIndex = new javax.swing.JButton();
        Rebuild_ = new javax.swing.JButton();
        label_Heading = new javax.swing.JLabel();
        label_SearchHeading = new javax.swing.JLabel();
        textField_SearchBar = new javax.swing.JTextField();
        button_Search = new javax.swing.JButton();
        button_About = new javax.swing.JButton();
        radioBtn_All = new javax.swing.JRadioButton();
        radioBtn_OrSearch = new javax.swing.JRadioButton();
        radioBtn_PhraseSearch = new javax.swing.JRadioButton();
        button_Exit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchResults = new javax.swing.JList<>();
        AddFile_ = new javax.swing.JButton();
        RemoveFile_ = new javax.swing.JButton();

        Maintain.setTitle("File Maintenance");
        Maintain.setAlwaysOnTop(true);
        Maintain.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        Maintain.setSize(new java.awt.Dimension(400, 300));
        Maintain.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                MaintainWindowOpened(evt);
            }
        });

        jScrollPane1.setViewportView(list_Files);

        Header.setText("Select file to delete:");

        DeleteFromIndex.setText("Delete");
        DeleteFromIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteFromIndexActionPerformed(evt);
            }
        });

        Rebuild_.setText("Rebuild");
        Rebuild_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rebuild_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MaintainLayout = new javax.swing.GroupLayout(Maintain.getContentPane());
        Maintain.getContentPane().setLayout(MaintainLayout);
        MaintainLayout.setHorizontalGroup(
            MaintainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaintainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MaintainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(MaintainLayout.createSequentialGroup()
                        .addComponent(Header)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MaintainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DeleteFromIndex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rebuild_)))
                .addContainerGap())
        );
        MaintainLayout.setVerticalGroup(
            MaintainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaintainLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(MaintainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteFromIndex)
                    .addComponent(Rebuild_))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frameMainInterface"); // NOI18N

        label_Heading.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        label_Heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Heading.setText("FILE SEARCH ENGINE");

        label_SearchHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        label_SearchHeading.setText("Search:");

        textField_SearchBar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        button_Search.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_Search.setText("Search");
        button_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SearchActionPerformed(evt);
            }
        });

        button_About.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_About.setText("About");
        button_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AboutActionPerformed(evt);
            }
        });

        radioBtn_All.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        radioBtn_All.setText("All");
        radioBtn_All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_AllActionPerformed(evt);
            }
        });

        radioBtn_OrSearch.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        radioBtn_OrSearch.setSelected(true);
        radioBtn_OrSearch.setText("Or Search");
        radioBtn_OrSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_OrSearchActionPerformed(evt);
            }
        });

        radioBtn_PhraseSearch.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        radioBtn_PhraseSearch.setText("Phrase");
        radioBtn_PhraseSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_PhraseSearchActionPerformed(evt);
            }
        });

        button_Exit.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button_Exit.setText("Exit");
        button_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExitActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(searchResults);

        AddFile_.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        AddFile_.setText("Add File...");
        AddFile_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFile_ActionPerformed(evt);
            }
        });

        RemoveFile_.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        RemoveFile_.setText("Remove...");
        RemoveFile_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFile_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(radioBtn_OrSearch)
                            .addComponent(radioBtn_PhraseSearch)
                            .addComponent(AddFile_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoveFile_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_About, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioBtn_All)
                            .addComponent(label_SearchHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField_SearchBar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddFile_, button_About, button_Exit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_SearchHeading)
                    .addComponent(textField_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioBtn_All)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBtn_OrSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBtn_PhraseSearch)
                        .addGap(23, 23, 23)
                        .addComponent(AddFile_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveFile_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_About)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_Exit))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button_Search, label_SearchHeading, textField_SearchBar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AddFile_, button_About, button_Exit});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Disables the other radio buttons when this button is clicked. -Kelvin
     * @param evt 
     */
    private void radioBtn_OrSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_OrSearchActionPerformed
        radioBtn_OrSearch.setSelected(true);
        radioBtn_All.setSelected(false);
        radioBtn_PhraseSearch.setSelected(false);
    }//GEN-LAST:event_radioBtn_OrSearchActionPerformed
    /**
     * Displays the About dialog when clicked. -Kelvin
     * @param evt 
     */
    private void button_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AboutActionPerformed
        JFrame frame = new JFrame();        
        JOptionPane.showMessageDialog(frame,
            "\tSearch Engine Project (Gomez-Version)\n"
            +"Developed by: Bradley Claus, Jonathan Llaners, Kelvin Gomez\n"
            +"COP 2805 (JAVA Advanced).",
            "Search Engine",
            JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_button_AboutActionPerformed
    /**
     * Disables the other radio buttons when this button is clicked.
     * @param evt 
     */
    private void radioBtn_AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_AllActionPerformed
        radioBtn_All.setSelected(true);
        radioBtn_OrSearch.setSelected(false);
        radioBtn_PhraseSearch.setSelected(false);
    }//GEN-LAST:event_radioBtn_AllActionPerformed
    /**
     * Disables the other radio buttons when this button is clicked.
     * @param evt 
     */
    private void radioBtn_PhraseSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_PhraseSearchActionPerformed
        radioBtn_PhraseSearch.setSelected(true);
        radioBtn_All.setSelected(false);
        radioBtn_OrSearch.setSelected(false);
    }//GEN-LAST:event_radioBtn_PhraseSearchActionPerformed

   /**
     * Exits the application when clicked.
     * @param evt 
     */
    private void button_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button_ExitActionPerformed
    /**
     * Searches the file index.
     * @param evt 
     */
    private void button_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SearchActionPerformed
        empty();
        DefaultListModel model;

        if(textField_SearchBar.getText().length() > 0){
            String[] str = textField_SearchBar.getText().toLowerCase().split("[ \n\t\r,.;:!?*--+(){}}]");
            ArrayList<Integer> results = search.searchOR(map.map, str);
            if(results.size() > 0){
                model = new DefaultListModel();
                for(int i = 0; i < results.size(); i++){
                    if((model.contains(fm.list.get(results.get(i)))) == false){
                        model.addElement(fm.list.get(results.get(i)));                                            
                    }
                }
                searchResults.setModel(model); 
            }else{
                empty();
                JOptionPane.showMessageDialog(null, "No matching results",
                        "Sorry", JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            empty();
        }
    }//GEN-LAST:event_button_SearchActionPerformed
    /**
     * Clears the JList model and removes entries.
     */
    public void empty(){
        searchResults.removeAll();
        DefaultListModel model = new DefaultListModel();
        model.removeAllElements();
        searchResults.setModel(model);        
    }
    /**
     * Adds file to index
     * @param evt 
     */
    private void AddFile_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFile_ActionPerformed
        int result = fm.getPathStr();
        if(result == 0){
            int index = fm.list.size() -1;
            list.addElement(fm.list.get(index));
            try {
                fm.writeToFile(fm.list.get(index));
            } catch (IOException ex) {
            }
            list_Files.setModel(list);
        }else{
            JOptionPane.showMessageDialog(null,"Operation canceled","Warning",
                JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_AddFile_ActionPerformed
    private void RemoveFile_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFile_ActionPerformed
        MainInterface n;
        try {
            n = new MainInterface();
            n.Maintain.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveFile_ActionPerformed

    private void MaintainWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MaintainWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_MaintainWindowOpened

    private void DeleteFromIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteFromIndexActionPerformed
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
        }
        list_Files.setModel(list);        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteFromIndexActionPerformed

    private void Rebuild_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rebuild_ActionPerformed
        try {
            map.map(fm.list);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_Rebuild_ActionPerformed
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
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * Brings up the Main Interface when
         * the program runs. -Kelvin
         */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainInterface().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFile_;
    private javax.swing.JButton DeleteFromIndex;
    private javax.swing.JLabel Header;
    private javax.swing.JFrame Maintain;
    private javax.swing.JButton Rebuild_;
    private javax.swing.JButton RemoveFile_;
    private javax.swing.JButton button_About;
    private javax.swing.JButton button_Exit;
    private javax.swing.JButton button_Search;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_Heading;
    private javax.swing.JLabel label_SearchHeading;
    private javax.swing.JList<String> list_Files;
    public javax.swing.JRadioButton radioBtn_All;
    public javax.swing.JRadioButton radioBtn_OrSearch;
    public javax.swing.JRadioButton radioBtn_PhraseSearch;
    private javax.swing.JList<String> searchResults;
    private javax.swing.JTextField textField_SearchBar;
    // End of variables declaration//GEN-END:variables
}