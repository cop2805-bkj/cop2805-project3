import Jons_GUI.Main_UI;

/**
 * Created by Jonathan Llaneras on 3.18.17
 */
public class Main {
    public static void main(String[] args){
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                Main_UI userInterface = new Main_UI();
                userInterface.setVisible(true);
            }
        });    
    }
}
