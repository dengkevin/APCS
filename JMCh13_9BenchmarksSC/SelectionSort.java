public class SelectionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Selection Sort.
    public void sort( double[] a )
    {
        addSteps(1); //initialization of for loop
        
        for ( int n = a.length; n > 1; n-- )
        {
            // Find the index iMax of the largest element
            // among a[0], ..., a[n-1]:

            int iMax = 0;
           
            addSteps(1); //1. initialization of the for loop
                         //2. decrement n
                         //3. check boundary of n
                         //4. initialize for loop
                         //5. var iMax assignment
            
            for ( int i = 1; i < n; i++ )
            {
                addSteps(3); //1. increment i
                            // 2. check boundary of loop
                            // 3. if comparison 
                
                if ( a[i] > a[iMax] )
                {
                    iMax = i;
                }
            }
            
            addSteps(2); //swap method

            // Swap a[iMax] with a[n-1]:
            swap (a, iMax, n-1);

            // Decrement n (accomplished by n-- in the for loop).
        }
    }
}
