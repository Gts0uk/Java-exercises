import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WeeklyProject1 {

	  public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    File file = new File(args[0]);
	    LocalTime localTime = LocalTime.now();
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    
	    //Checks if the correct text files exists and if the arguments are more/less than 2
	    if (file.exists()) {
	    	System.out.println(localTime.format(timeFormatter) + " : File " + args[0].toString() + " found!");
	    } else {
	      System.out.println(file + " is not a valid file path");
	      System.exit(0);
	    }
	    if (args.length != 2) {
	    	 System.out.println("Please provide valid arguments");
             System.out.println("Argument 1: Provide path to text file");
             System.out.println("Argument 2: Provide command to apply (wc or find)");
	    }
        
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	      switch (args[1].toLowerCase()) {
	      
	        case "wc":
	        	System.out.println(localTime.format(timeFormatter) + " : Total word count started");
	          int wordCount = countWords(reader);
	          System.out.println(localTime.format(timeFormatter) + " : Word count finished. Counted " + wordCount + " words");
	          try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("wordcount.txt"),true))){
	        	  writer.println(args[1] + "        " + file + "     " + wordCount);
		    }
	          catch (FileNotFoundException e){
			        System.err.println("File not found");
			    }
	          break;
	          
	        case "find":   	
	          System.out.println("Enter the word you wish to search in the file: ");
	          int timesOccured = countOccuranceOfWord(reader, sc.nextLine());
	          System.out.println(localTime.format(timeFormatter) + ": Count of word clouds finished. Occurrences found: " + timesOccured);
	          
	          try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("wordcount.txt"),true))){
	          writer.println(localTime.format(timeFormatter) + "        " +args[1] + "        " + file + "     " + timesOccured);
	          }
	          catch (FileNotFoundException e){
			        System.err.println("File not found");
			    }
	          
	          break;
	          
	        default:
	          System.out.println("Argument " + args[1] + " is invalid. Only wc and find are supported");
	          break;
	      }
	         
	      
	    } catch (FileNotFoundException e) {
	      System.err.println(file + " is not a valid file path");
	    } catch (IOException e) {
	      System.err.println("Input/Output error has occured");
	    }
	    
	    
	    sc.close();
	  }
        
	  //public static void printTimeFormattedString(String string) {
	    
	   // System.out.println(localTime.format(timeFormatter) + string);
	  //}

	  //Counts all the words in the text file.
	  public static int countWords(BufferedReader reader) throws FileNotFoundException, IOException {
	    int count = 0;
	    String line;
	    
	      while ((line = reader.readLine()) != null) {
	          if (line.equals("")) {
	            continue;
	          }
	          for (String string : line.split(" ")) {
	        	  count++;
	          }
	        }
		return count;
	  }
	  
     //Counts how many times the word that the user inputs exists in the file.
	  public static int countOccuranceOfWord(BufferedReader reader, String word)
	      throws FileNotFoundException, IOException {
		  int countWord = 0;
		  
	    String line;
	      while ((line = reader.readLine()) != null) {
	          if (line.equals("")) {
	            continue;
	          }
	          for (String string : line.split(" ")) {
	            if (string.contains(word)) {
	              countWord++;
	            }
	          }
	        }
	    return countWord;
	  }
}

	