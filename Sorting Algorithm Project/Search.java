/******************************************************************
 * A Project of Sorts
 * 
 * Implements Search Algorithms on integer arrays
 * Includes Linear and Binary searches
 * Binary Search requires a sorted list
 * All Search methods are static
 * All Search helper methods are private
 * 
 * @author 
 *
 *******************************************************************/
public class Search 
{
	/**
	 * Implements a Linear Search
	 *    <Include Algorithm Steps here>
	 * @param list - integer list to search in
	 * @param num - integer to search for
	 * @return index of found item, -1 if not found
	 */
	public static int linearSearch(int[] numbers, int target)
	{
        for (int index = 0; index < numbers.length; index++){
            if (target == numbers[index]){
                return index;
            }
        }
        return -1;
	}
	
	/**
	 * Implements a Binary Search
	 *    <Include Algorithm Steps here>
	 * Pre: list must be sorted
	 * 
	 * @param list - integer list to search in
	 * @param num - integer to search for
	 * @return index of found item, -1 if not found
	 */
	public static int binarySearch(int[] numbers, int target)
	{
        int low = 0, high = numbers.length-1, middle = (low+high)/2;
        while(numbers[middle]!=target && low<=high){
            if (target<numbers[middle]){
                high = middle-1;
            }
            else{
                low = middle + 1;
            }
            middle = (low+high)/2;
        }
        if (numbers[middle] == target){
            return middle;
        }
        else{
            return -1;
        }
	}
}