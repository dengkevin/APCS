public class Quicksort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Quicksort algorithm.
    public void sort( double[] a )
    {
        recursiveSort( a, 0, a.length - 1 );
    }

    // Recursive helper method: sorts a[from], ..., a[to]
    private void recursiveSort( double[] a, int from, int to )
    {
        addSteps(1); //if condition
        if ( from >= to )
        {
            return;
        }

        addSteps(3); //3 variable declarations
        // Choose pivot a[p]:
        int p = ( from + to ) / 2;
        // The choice of the pivot location may vary:
        // you can also use p = from or p = to or use
        // a fancier method, say, the median of the above three.

        // Partition:

        int i = from;
        int j = to;
        
        addSteps(1);
        while ( i <= j )
        {
            addSteps(2); //check boundary of while loop, if condition
            if ( a[i] <= a[p] )
            {
                addSteps(1); //variable increment
                i++;
            }
            else if ( a[j] >= a[p] )
            {
                addSteps(1); //variable decrement
                j--;
            }
            else
            {
                addSteps(6); //swap (3), 2 variable decrement, condition
                swap( a, i, j );
                i++;
                j--;
            }
        }

        // Finish partitioning:

        addSteps(1); //if condition
        if ( p < j ) // place the pivot in its correct position
        {
            addSteps(4); //swap 2, 1 variable assignment
            swap( a, j, p );
            p = j;
        }
        else if ( p > i )
        {
            addSteps(4); //swap 2, 1 variable assignment, else if
            swap( a, i, p );
            p = i;
        }

        // Sort recursively:
        
        recursiveSort( a, from, p - 1 );
        recursiveSort( a, p + 1, to );
    }
}
