class Main
{
    public static void main(String[] args) {
//		Testing sorts 
		int[] insertion = new int[20];
        int[] bubble = new int[20];
        int[] merge = new int[20];
        int[] quick = new int[20];
		int[] selection = new int[20];
		
		Client.randomTwenty(insertion);
        Client.randomTwenty(bubble);
		Client.randomTwenty(merge);
		Client.randomTwenty(quick);
        Client.randomTwenty(selection);

		
		Sort.insertionSort(insertion);
		System.out.println("Insertion sort: ");
		for (int i:insertion) {
			System.out.print(i+" ");
		}
		System.out.println();

        Sort.bubbleSort(bubble);
		System.out.println("Bubble sort: ");
		for (int i:bubble) {
			System.out.print(i+ " ");
		}
		System.out.println();
        
		Sort.mergeSort(merge);
		System.out.println("Merge sort: ");
		for (int i:merge) {
			System.out.print(i+" ");
		}
		System.out.println();
		Sort.quickSort(quick);
		System.out.println("Quick sort: ");
		for (int i:quick) {
			System.out.print(i+" ");
		}
        Sort.selectionSort(selection);
		System.out.println("Selection sort: ");
		for (int i:selection) {
			System.out.print(i+" ");
		}
		System.out.println();

        //Testing the searches now
		System.out.println();
        //linear
		int[] linNumber = new int[5];
		Client.randomTwenty(linNumber);
		for (int i:linNumber) {
			System.out.println("\nSearching for "+i+" in Bubble Sort array.");
			int position = Search.linearSearch(bubble, i);
			if (position == -1) {
                System.out.println(i+" was not found.");
            }
			else {
                System.out.println("Found "+i+" at "+position);
            }
		}
        //binary
		int[] binNumber = new int[5];
		Client.randomTwenty(binNumber);
		for (int i:binNumber) {
			System.out.println("\nSearching for "+i+" in the bubble sort array.");
			int position = Search.binarySearch(bubble, i);
			if (position == -1){ 
                System.out.println(i+" could not be located.");
            }
			else{ 
                System.out.println("Located "+i+" at "+position);
            }
		}
		
        //making arrays for the next tests, randomizing them and making 5 copies of them so that I can test each sort with them
		int[][] thousand = new int[5][1000];
		Client.randomArray(thousand[0], thousand[0].length);
		for (int i=0;i<thousand.length;i++){
			thousand[i] = Client.copy(thousand[0]);
		}
		int[][] fivethousand = new int[5][5000];
		Client.randomArray(fivethousand[0], fivethousand[0].length);
		for (int i=0;i<fivethousand.length;i++) {
			fivethousand[i] = Client.copy(fivethousand[0]);
		}
		int[][] tenthousand = new int[5][10000];
		Client.randomArray(tenthousand[0], tenthousand[0].length);
		for (int i=0;i<tenthousand.length;i++) {
			tenthousand[i] = Client.copy(tenthousand[0]);
		}
		
		int[][] fiftythousand = new int[5][50000];
		Client.randomArray(fiftythousand[0], fiftythousand[0].length);
		for (int i=0;i<fiftythousand.length;i++) {
			fiftythousand[i] = Client.copy(fiftythousand[0]);
		}
//		Sorting the arrays with all 5 sorts.
		Client.allSorts(thousand);
		Client.allSorts(fivethousand);
		Client.allSorts(tenthousand);
		Client.allSorts(fiftythousand);
		
		int[][] hundredthousand = new int[4][100000];
		Client.randomArray(hundredthousand[0], hundredthousand[0].length);
		for (int i=0;i<hundredthousand.length;i++) {
			hundredthousand[i] = Client.copy(hundredthousand[0]);
		}
		
		int[][] fiveHundredThousand = new int[4][500000];
		Client.randomArray(fiveHundredThousand[0], fiveHundredThousand[0].length);
		for (int i=0;i<fiveHundredThousand.length;i++) {
			fiveHundredThousand[i] = Client.copy(fiveHundredThousand[0]);
		}
//		Sorts the arrays with everything but bubble sort.
		Client.sortButBubble(hundredthousand);
		Client.sortButBubble(fiveHundredThousand);
		
		int[][] oneMilli = new int[2][1000000];
		Client.randomArray(oneMilli[0], oneMilli[0].length);
		for (int i=0;i<oneMilli.length;i++) {
			oneMilli[i] = Client.copy(oneMilli[0]);
		}
		
		int[][] fiveMilli = new int[2][5000000];
		Client.randomArray(fiveMilli[0], fiveMilli[0].length);
		for (int i=0;i<fiveMilli.length;i++) {
			fiveMilli[i] = Client.copy(fiveMilli[0]);
		}
//		Sorts the arrays using quick and merge sort
		Client.quickMerge(oneMilli);
		Client.quickMerge(fiveMilli);
		
//		Special cases
		System.out.println("\nSpecial cases.");
		int[][] twoHundredThousand = new int[4][200000];
		Client.randomArray(twoHundredThousand[0], twoHundredThousand[0].length);
		for (int i=0;i<twoHundredThousand.length;i++) {
			twoHundredThousand[i] = Client.copy(twoHundredThousand[0]);
		}
		Client.sortButBubble(twoHundredThousand);
		System.out.println("\nSorting a list that;s already sorted.");
		Client.sortButBubble(twoHundredThousand);
//		Array sized 1-20
		System.out.println("\nArray sized 1-20");
		int [][] oneToTwenty = new int[4][200000];
		for (int[] i: oneToTwenty) {
			Client.randomArray(i, 20);
		}
//		reverse
		System.out.println("\nReverse list");
		int[][] reverseSort = new int[4][200000];
		for (int[] i: reverseSort) {
			Client.randomArray(i, i.length);
			Sort.quickSort(i);
		}
		for (int[] i: reverseSort) {
			Client.reverse(i);
		}
		Client.sortButBubble(reverseSort);

		Client.sortButBubble(oneToTwenty);
		System.out.println("\nSearches");
//		Searches
		System.out.println("\nUnsorted");
		int [] fiveMSearch = new int[5000000];
		Client.randomArray(fiveMSearch, fiveMSearch.length);
		int[] nums = new int[5];
		for (int i=0;i<nums.length;i++) {
			nums[i] = (int)(Math.random()*5000000);
		}
		for (int num:nums) {
			Client.linearTime(fiveMSearch, num);	
		}
//		Sorted Linear
		int [] fiveMSearchSorted = new int[5000000];
		Client.randomArray(fiveMSearchSorted, fiveMSearchSorted.length);
		Sort.quickSort(fiveMSearchSorted);
		for (int i=0;i<nums.length;i++) {
			nums[i] = (int)(Math.random()*5000000);
		}
		for (int num:nums) {
			Client.linearTime(fiveMSearchSorted, num);	
		}
//		Binary Search
		int [] fiveMBinary = new int[5000000];
		Client.randomArray(fiveMBinary, fiveMBinary.length);
		Sort.quickSort(fiveMBinary);
		for (int i=0;i<nums.length;i++) {
			nums[i] = (int)(Math.random()*5000000);
		}
		for (int num:nums) {
			Client.binaryTime(fiveMBinary, num);	
		}
		
	}
}