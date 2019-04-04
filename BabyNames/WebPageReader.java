import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
   This program prints all lines from a web page that contain
   references to other web sites.
*/
public class WebPageReader
{
   public static void main(String[] args) throws IOException
   {
      String address = "https://en.wikipedia.org/wiki/Imperial_(Denzel_Curry_album)";
      URL pageLocation = new URL(address);
      Scanner in = new Scanner(pageLocation.openStream());
      int wordCount = 0;
      while (in.hasNext())
      {
         String line = in.next();
         if (line.contains("")) 
         {
            System.out.println(line);
            wordCount++;
         }
      }
      System.out.println(wordCount);
   }
}
