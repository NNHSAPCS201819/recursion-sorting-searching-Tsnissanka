import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Write a description of class WC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WC
{
    public static void main (String[] args) throws FileNotFoundException{
        Scanner s = new Scanner(System.in);
        System.out.println("What is your filename?");
        String fileName = s.next();
        
        File inputFile = new File(fileName);
        Scanner charScan = new Scanner(inputFile);
        
        charScan.useDelimiter("(?<=.)");
        ArrayList<String> charArray = new ArrayList<String>();
        while(charScan.hasNext()){
            charArray.add(charScan.next());
        }
        System.out.println("Characters: " + charArray.size());
        
        Scanner wordScan = new Scanner(inputFile);
        wordScan.useDelimiter("[^A-Za-z]+");
        ArrayList<String> words = new ArrayList<String>();
        while(wordScan.hasNext()){
            words.add(wordScan.next());
        }
        System.out.println("Words: " + words.size());
        
        Scanner lineScan = new Scanner(inputFile);
        lineScan.useDelimiter("\r\n|\r\n");
        ArrayList<String> lines = new ArrayList<String>();
        while(lineScan.hasNext()){
            lines.add(lineScan.next());
        }
        System.out.println("Lines: " + lines.size());
    }
}
