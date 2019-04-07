public class InsertionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Insertion Sort.
    public void sort( double[] a )
    {
        addSteps(1); //initialization of for loop
        
        for ( int n = 1; n < a.length; n++ )
        {
            // Save the next element to be inserted:
            double aTemp = a[n];

            // Going backward from a[n-1], shift elements to the
            // right until you find an element a[i] <= aTemp:
            int i = n;
            
            addSteps(4); // 1. incrementing n
                        //  2. checking boundary of n
                        //  3. Saving the next element to be inserted
                        // 4. storing n into the variable i
            while ( i > 0 && aTemp < a[i - 1] )
            {
                a[i] = a[i - 1];
                i--;
                addSteps(4); // 1. decrementing i
                             // 2. variable assignment
                             // 3. checking boundary of i 2 times
            }

            addSteps(1); //insert element
            
            // Insert the saved element after a[i]:
            a[i] = aTemp;
        }
    }
}

