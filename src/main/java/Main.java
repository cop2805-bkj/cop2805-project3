import com.bkj.search.gui.MainWindow;

// Displays UI
public class Main {
    public static void main(String[] args){
        // In future versions we can handle different UI's for example from here
        javax.swing.SwingUtilities.invokeLater(new MainWindow.MainWindowBuilder().build());
    }
}
