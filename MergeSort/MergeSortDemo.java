import java.util.Arrays;

/**
   This program demonstrates the merge sort algorithm by
   sorting an array that is filled with random numbers.
*/
public class MergeSortDemo
{  
   public static void main(String[] args)
   {  
      int[] a = ArrayUtil.randomIntArray(8, 100);
      System.out.println(Arrays.toString(a));

      MergeSorter.sort(a);

      System.out.println(Arrays.toString(a));
      
      String[] b = ArrayUtil.randomStringArray(8, 3);
      System.out.println(Arrays.toString(b));
      MergeSorter.stringSort(b);
      System.out.println(Arrays.toString(b));
   }
}

