import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = null;
      if (n <= 0)  // The smallest list we can make
      {
           return tempList = new ArrayList(0);
      }
      else        // All other size lists are created here
      { 
          tempList = makeList(n-1);
          tempList.add(n);
      }
      return tempList;
   }
   
   public static ArrayList<Integer> reverseList(ArrayList<Integer> list){
     ArrayList<Integer> reversed = ListMethods.deepClone(list);
     if (reversed.size() == 0 || reversed.size() == 1)
     {
       return reversed;
     }
     else
     {
       int num = reversed.remove(0);
       reversed = reverseList(reversed);
       reversed.add(num);
     }
     return reversed;
    }
    
   public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }
    
   /*
    * public static ArrayList even(ArrayList<Integer> list){
       ArrayList<Integer> evenIndexed = ListMethods.deepClone(list);
       if (evenIndexed.size() == 2){
           return evenIndexed;
        }
       else{
           int num = evenIndexed.remove(0);
           int num2 = evenIndexed.remove(0);
           evenIndexed = ListMethods.even(evenIndexed);
           evenIndexed.add(0, num2);
        }
       return evenIndexed;
    } 
    */

}