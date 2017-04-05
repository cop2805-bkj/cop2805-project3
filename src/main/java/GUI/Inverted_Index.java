package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;

/**
 *
 * @author Jonathan Llaneras
 */
public class Inverted_Index {
    
    private String searchWord;
    private ArrayList<String> list = new ArrayList<>();
    private Scanner reader;
    
    public String getWord() {
        return searchWord;       
    }
    
    public void setWord(String word) {
        searchWord = word;
    }

    public void run() throws FileNotFoundException {
        File file =new File("list.txt");
        Scanner in = null;
            in = new Scanner(new FileReader(file));
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains(""))
                    System.out.println("1");
                try{
                    reader = new Scanner(new FileReader(line));
                }catch(FileNotFoundException e){
                    System.err.println(e);
                    return;
            }
            while(reader.hasNext()){
                    searchWord = reader.next();
                    searchWord = searchWord.toLowerCase();
                    searchWord = searchWord.replaceAll("[^a-zA-Z0-9\\s]", "");
                    list.add(searchWord);
            }
            
        }
    }
    /**
     *
     * @param searchWord
     */
    public void searchMap(String searchWord){
    	System.out.println(list.contains(searchWord));
    }
}