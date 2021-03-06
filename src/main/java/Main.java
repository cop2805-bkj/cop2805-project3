import com.bkj.search.bradGUI.MainWindow;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Displays UI
public class Main {
    public static void main(String[] args){
        File f = new File("settings.json");
        if(f.exists() && !f.isDirectory()) {
            String jsonStr;
            MainWindow mw;
            try (FileReader fr = new FileReader(f)) {
                System.out.println("Found settings.json file...reading saved settings");
                mw = new MainWindow.MainWindowBuilder().makeFromJson(fr).build();
                javax.swing.SwingUtilities.invokeLater(mw);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        } else {
            System.out.println("settings.json is missing! Using default settings!");
            javax.swing.SwingUtilities.invokeLater(
                    new MainWindow.MainWindowBuilder().setWindowDimensions(500,650).build());
        }
    }
}
