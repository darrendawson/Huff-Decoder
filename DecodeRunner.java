import java.util.*;
import java.io.*;

public class DecodeRunner {
  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
    HuffDecoder decoder = new HuffDecoder();

    //set up wordList
    String filePath = "google-10000-english-usa.txt";
    ArrayList<String> wordList = createWordList(filePath);

    // DEV LOOP
    while(true) {

      System.out.print("Encoded Message: ");

      String encoded = kb.nextLine();
      String decoded = decoder.decode(encoded, wordList);
      System.out.println("Decoded: " + decoded);
    } // END DEV LOOP
  }

  //---createWordList----------------------------------------------------

  // returns word list
  public static ArrayList<String> createWordList(String filePath) {
    ArrayList<String> wordMap = new ArrayList<String>();
    
    BufferedReader br = null;
    FileReader fr = null;
      
    try {
      fr = new FileReader(filePath);
      br = new BufferedReader(fr);   
      String line;	
      br = new BufferedReader(new FileReader(filePath));
      
      while ((line = br.readLine()) != null) {
	wordMap.add(line);
      }  
    } catch (IOException e) {      
      e.printStackTrace();    
    } finally {    
      try {	  
	if (br != null)
	  br.close();	
	if (fr != null)
	  fr.close();	  
      } catch (IOException ex) {
	ex.printStackTrace();	  
      }	
    }   
    return wordMap;
  }

}
