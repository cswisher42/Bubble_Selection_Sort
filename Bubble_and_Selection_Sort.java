import java.util.*;
import java.time.*;		// Needed for Instant Class

public class Bubble_and_Selection_Sort
{
  public static void main(String[] args) 
  {
		
	Scanner s = new Scanner(System.in);

// Declare a constant ARRAY_SIZE for the array size
	final int ARRAY_SIZE = 10000;
// Declare an array to hold ARRAY_SIZE integers
	int [] array1 = new int[ARRAY_SIZE];
// call a method that generates ARRAY_SIZE numbers between 1-99
// and stores in the array
	populateArray(array1, ARRAY_SIZE);
// Copy the array to another array of the same size
	int [] array2 = new int[ARRAY_SIZE];
	for(int i = 0; i < array1.length; i++)
		array2[i] = array1[i];
// pass one of the unsorted array to a method call bubbleSort
	long time1 = bubbleSort(array1, ARRAY_SIZE);
// Display the amount of time it took to sort the array
	for(int j = 0; j < array1.length; j++)
		System.out.print(array1[j] + " ");
	
	System.out.println();
	System.out.println("Difference: " + time1 + " nanoseconds");
	System.out.println("(or " + time1/1000000000.0 + " seconds)");
// Display the contents of the sorted array

// pass the other unsorted array to a method call selectionSort
	long time2 = selectionSort(array2, ARRAY_SIZE);
// Display the amount of time it took to sort the array
	for(int l = 0; l < ARRAY_SIZE; l++)
		System.out.print(array2[l] + " ");
// Display the contents of the sorted array
	System.out.println();
	System.out.println("Difference: " + time2 + " nanoseconds");
	System.out.println("(or " + time2/1000000000.0 + " seconds)");
 } // end main
 
// Create method to populate the array
public static void populateArray(int [] array, int size)
{
	Random r = new Random();
	
	for(int i = 0; i < size; i++)
	{
		array[i] = r.nextInt(98)+1;
	}
}

// Create bubbleSort method 
public static long bubbleSort(int [] array, int size)
{
	Instant t1, t2;
	
	t1 = Instant.now();
	for(int i = 0; i < size; i++)
	{
		for(int k = 0; k < size-1; k++)
		{
			if(array[k] < array[k+1])
			{
				int temp = array[k];
				array[k] = array[k+1];
				array[k+1] = temp;
			}
		}
	}
	t2 = Instant.now();
	
	long ns = Duration.between(t1,t2).toNanos();
	return ns;
}

// Create selectionSort method 
public static long selectionSort(int [] array, int size)
{
	Instant t1, t2;
	int small = 100;
	int index = 0;
	t1 = Instant.now();
	for(int i = 0; i < size-1; i++)
	{
		for(int k = i; k < size; k++)
		{
			if(array[k] < small)
			{
				small = array[k];
				index = k;
			}
		}
		int temp = array[i];
		array[i] = small;
		array[index] = temp;
		
		small = 100;
	}
	t2 = Instant.now();
	
	long ns = Duration.between(t1,t2).toNanos();
	return ns;
}
 
} // end class
