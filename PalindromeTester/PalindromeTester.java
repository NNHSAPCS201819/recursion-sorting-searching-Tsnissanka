import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Demonstrates the use of nested while loops.
 * 
 * @author Lewis/Loftus/Cocking
 */
public class PalindromeTester
{
    /**
     * Tests strings to see if they are palindromes.
     *
     */
   public static void main (String[] args) throws FileNotFoundException
   {
      String str = "";
      String fileName = "palindrome.txt";
      
      // read from the specified file
      if(args.length > 0){
          fileName = args[0];
        }
          
      
      /*
       * open the file based on the specified file path;
       *    throws an exception if the file is not found
       */
      File inputFile = new File(fileName);
      Scanner s = new Scanner(inputFile);
      
      /*
       * make everything that isnt a letter, a delimiter
       */
      s.useDelimiter("[^A-Za-z]+");
      
      /*
       * Read the entire file, one word at a time, and 
       * concatenate each word into str
       * (the StringBuilder class is a much more efficient way to do this)
       */
      while(s.hasNext())
      {
          str += s.next();
        }
      /*
       * close the scanner object to indicate we are done reading from the file
       */
      s.close();
      // make the entire string lowercase
      str = str.toLowerCase();
      
      System.out.println(str);
      if(isPalindrome(str)){
         System.out.println ("That string IS a palindrome.");
        }
     else{
         System.out.println("That string is NOT a palindrome.");
        }

   }
   
   public static boolean isPalindrome(String str){
        // must have a terminating case
        if(str.length() <= 1){
            return true;
        }
        String firstChar = str.substring(0, 1);
        String lastChar = str.substring(str.length() - 1);
        if(firstChar.equals(lastChar))
        {
            // recurse with a simpler version of the problem
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        else{
            return false;
        }
        
    }
}
