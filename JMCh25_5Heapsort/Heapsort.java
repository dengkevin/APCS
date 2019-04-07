/**
   TODO Heapsort
   TODO sort method sorts using heapsort and it calls reheapDown to sort

   @author  TODO Kevin Deng
   @version TODO 3/11/19

   @author  Period - TODO 3
   @author  Assignment - TODO Assignment Name

   @author  Sources - TODO none
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    //   using the Mergesort algorithm
    public static void sort(double[] a)
    {
        int n = a.length;
        for (int i = n / 2; i >= 1; i--)
        {
            reheapDown(a, i, n);
        }
        while (n > 1)
        {
            double t = a[0];
            a[0] = a[n - 1];
            a[n - 1] = t;
            
            n--;
            reheapDown(a, 1, n);
        }
    }

    // Should be private - made public for testing
    public static void reheapDown(double[] a, int i, int n)
    {
        int c = i - 1;
        
        while (c * 2 + 1 < n)
        {
            if (c * 2 + 2 == n)
            {
                if (a[c] > a[2 * c + 1])
                {
                    return;
                }
                double d = a[c];
                a[c] = a[2 * c + 1];
                a[2 * c + 1] = d;
                return;
            }
            
            if (a[c] >= a[2 * c + 1] && a[c] >= a[2 * c + 2])
            {
                return;
            }
            
            if (a[c * 2 + 1] > a[c * 2 + 2])
            {
                double d = a[c];
                a[c] = a[c * 2 + 1];
                a[c * 2 + 1] = d;
                c = 2 * c + 1;           
            }
            else
            {
                double d = a[c];
                a[c] = a[c * 2 + 2];
                a[c * 2 + 2] = d;
                c = 2 * c + 2; 
            }
        }
    }
}
