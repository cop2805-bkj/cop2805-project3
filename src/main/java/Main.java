import com.bkj.search.gui.MainWindowFrame;
import GUI.Main_UI;

/**
 * Created by bclaus on 2/7/17.
 * Created by Jonathan Llaneras on 3.18.17
 */
public class Main {
    public static void main(String[] args){
        // In future versions we can handle different UI's for example from here
        javax.swing.SwingUtilities.invokeLater(new MainWindowFrame());
        
        
        java.awt.EventQueue.invokeLater(() -> {
            Main_UI userInterface = new Main_UI();
            userInterface.setVisible(true);
        });    
    }
}
