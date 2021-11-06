public class Client {
	/**
	 * Fills array with random integers from 1 to num
	 * @param arr array of integers
	 * @param num largest random number to be generated
	 */
	public static void randomArray(int[] arr, int num) {
		for (int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*num);
		}
	}
    
    /**
	 * Fills array with random integers from -20 to 20.
     * Math.random is multiplied by 41 because if output  of Math.random is 0.99*41-20, the int cast will set it to 20.
	 * @param arr list to be filled with integers
	 */
	public static void randomTwenty(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*41)-20;
		}
	}

    /**
	 * Goes through a 2D array and sorts them using everything but bubble sort. Timed and then printed
	 * @param arr 2D array which is filled with random integers
	 */
	public static void sortButBubble(int[][] arr) {
		StopWatch1 insertionTime = new StopWatch1();
		insertionTime.start();
		Sort.insertionSort(arr[0]);
		insertionTime.stop();

		StopWatch1 selectionTime = new StopWatch1();
		selectionTime.start();
		Sort.selectionSort(arr[1]);
		selectionTime.stop();

		StopWatch1 mergeTime = new StopWatch1();
		mergeTime.start();
		Sort.mergeSort(arr[2]);
		mergeTime.stop();

		StopWatch1 quickTime = new StopWatch1();
		quickTime.start();
		Sort.quickSort(arr[3]);
		quickTime.stop();

		System.out.println();
		System.out.println("Sort Type | Array Size | Time (ms) | Time (sec) \n");

		System.out.println("Insertion Sort | " + arr[0].length+ "| " + insertionTime.getElapsedTime() + " ms | " + insertionTime.getElapsedTimeSecs() + " seconds \n");

		System.out.println("Selection Sort | " + arr[1].length + "| " + selectionTime.getElapsedTime() +" ms | " + selectionTime.getElapsedTimeSecs()+ "seconds \n");

		System.out.println("Merge Sort | " + arr[2].length + "| " + mergeTime.getElapsedTime() + "ms | " + mergeTime.getElapsedTimeSecs()+ "seconds \n");

		System.out.println("Quick Sort | " + arr[3].length + "| " + quickTime.getElapsedTime() + " ms | " + quickTime.getElapsedTimeSecs() + "seconds \n");
	}
	
	/**
	 * 
	 * @param arr 2D array which is filled with random ints
	 */
	public static void allSorts(int[][] arr) {
		StopWatch1 bubbleTime = new StopWatch1();
		bubbleTime.start();
		Sort.bubbleSort(arr[0]);
		bubbleTime.stop();

		StopWatch1 insertionTime = new StopWatch1();
		insertionTime.start();
		Sort.insertionSort(arr[1]);
		insertionTime.stop();

		StopWatch1 selectionTime = new StopWatch1();
		selectionTime.start();
		Sort.selectionSort(arr[2]);
		selectionTime.stop();

		StopWatch1 mergeTime = new StopWatch1();
		mergeTime.start();
		Sort.mergeSort(arr[3]);
		mergeTime.stop();

		StopWatch1 quickTime = new StopWatch1();
		quickTime.start();
		Sort.quickSort(arr[4]);
		quickTime.stop();

		System.out.println();

		System.out.println("Sort Type | Array Size | Time (ms) | Time (sec)\n");

		System.out.println("Bubble Sort | " + arr[0].length + "| " + bubbleTime.getElapsedTime() + "ms | " + bubbleTime.getElapsedTimeSecs() + "seconds\n");

		System.out.println("Insertion Sort | " + arr[1].length + "| " + insertionTime.getElapsedTime() + "ms | " + insertionTime.getElapsedTimeSecs() + "seconds\n");

		System.out.println("Selection Sort | " + arr[2].length + "| " + selectionTime.getElapsedTime() + "ms | " + selectionTime.getElapsedTimeSecs() + "seconds\n");

		System.out.println("Merge Sort | " + arr[3].length + "| " + mergeTime.getElapsedTime() + "ms | " + mergeTime.getElapsedTimeSecs() + "seconds\n");

		System.out.println("Quick Sort | " + arr[4].length + "| " + quickTime.getElapsedTime() + "ms | " + quickTime.getElapsedTimeSecs() + "seconds\n");
	}
	
	/**
	 * Goes through a 2D array and sorts them using quick sort and merge sort, timed and printed.
	 * @param arr 2D array which is filled with random integers.
	 */
	public static void quickMerge(int[][] arr) {
		
        StopWatch1 mergeTime = new StopWatch1();
		mergeTime.start();
		Sort.mergeSort(arr[0]);
		mergeTime.stop();

		StopWatch1 quickTime = new StopWatch1();
		quickTime.start();
		Sort.quickSort(arr[1]);
		quickTime.stop();

		System.out.println();
        
		System.out.println("Sort Type | Array Size | Time (ms) | Time (sec)\n");

		System.out.println("Merge Sort | " + arr[0].length + "| " + mergeTime.getElapsedTime() + "ms | " + mergeTime.getElapsedTimeSecs() + "seconds\n");

		System.out.println("Quick Sort | " + arr[1].length + "| " + quickTime.getElapsedTime() + "ms | " + quickTime.getElapsedTimeSecs() + "seconds\n");
	}
	


    /**
	 * Returns the copy of an array
	 * @param arr Array of integers to be copied
	 * @return Copy of parameter
	 */
	public static int[] copy(int[] arr) {
		int[] arrTwo = new int[arr.length];
		for (int i=0;i<arr.length;i++) {
			arrTwo[i] = arr[i];
		}
		return arrTwo;
	}
    
    
    
    /**
	 * Reverses the array, resulting in a descending order array
	 * @param arr A sorted array filled with integers
	 */
	public static void reverse(int[] arr) {
		for (int i=0;i<arr.length/2;i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
	}


	/**
	 * This searches an array of integers for a number using binary search.
	 * @param arr Array filled with integers to search in
	 * @param num Number to search for
	 */
	public static void binaryTime(int[] arr, int num) {
		StopWatch1 s = new StopWatch1();
		System.out.println("Looking for the number "+num);
		s.start();
		int spot = Search.binarySearch(arr, num);
		s.stop();
		if (spot==-1){
            System.out.println("Number was not found.");
        } 
		else{
            System.out.println(num+" was found at "+spot);
        } 
		System.out.println();

		System.out.println("Search Type | Array Size | Time (ms) | Time (sec)\n");

		System.out.println("Binary Search | " + arr.length + "| " + s.getElapsedTime() + "ms | " + s.getElapsedTimeSecs() + "seconds\n");
	}


    /**
	 * This searches a given array for a given number. Times and prints info after the search is completed.
	 * @param arr Array filled with integers to search in
	 * @param num Number to search for
	 */
	public static void linearTime(int[] arr, int num) {
		StopWatch1 s = new StopWatch1();
		System.out.println("Looking for the number "+num);
		s.start();
		int spot = Search.linearSearch(arr, num);
		s.stop();
		if (spot==-1){
            System.out.println("Number not found.");
        } 
		else{
            System.out.println(num+" was found at " + spot);
        } 

		System.out.println();

		System.out.println("Search Type| Array Size | Time (ms) | Time (sec)\n");
		System.out.println("Linear Search | " + arr.length + "| " + s.getElapsedTime() + "ms | " + s.getElapsedTimeSecs() + "seconds\n");
	}
}