import java.util.ArrayList;

public class ListMethodsRunner
{
   public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(100);
      ArrayList<Integer> reversed = ListMethods.reverseList(tempList);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
      System.out.println();
      if (reversed.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : reversed)
         {
            System.out.println(i);
         }
      }
   }
}