package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jonathan Llaneras
 */
public class Inverted_Index implements Runnable {
    
    private String searchWord;
    
    public String getWord() {
        return searchWord;       
    }
    
    public void setWord(String word) {
        searchWord = word;
    }
    
    /**
     *
     */
    @Override
    public void run() {
        File file =new File("list.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains(""))
                    System.out.println("1");
                File fileText;
                fileText = new File(line);
                Scanner readText = null;
                try {
                    readText = new Scanner(file);
                    while(in.hasNext())
                    {
                        String lineText=in.nextLine();
                        lineText = lineText.toLowerCase();
                        System.out.println("2");
                        while(lineText.contains(searchWord))
                            System.out.println(searchWord);
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        }
    
    }
        /*File file =new File("line.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains(""))
                    System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

        }
    }*/

    /**
     *
     */
    public void getfiles() {
        File file =new File("list.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains(""))
                    System.out.println(line);
                File fileText;
                fileText = new File(line);
                Scanner readText = null;
                try {
                    readText = new Scanner(file);
                    while(in.hasNext())
                    {
                        String lineText=in.nextLine();
                        System.out.println(lineText);
                        while(lineText.contains(searchWord))
                            System.out.println(searchWord);
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        }
    }
}
