
public class SortingData {
	
	public static Integer[] example = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	
	
	public static Integer[] mergeSortBest(){
		IterativeMergeSort.iterativeMergeSort(example);
		return example;
	}
	
	
	public static Integer[] mergeSortWorst(){
		RecursiveMergeSort.sort(example);
		return example;
	}
	
	public static Integer[] quickSortBest; // = {...}
	
	
	public static Integer[] quickSortWorst; // = {...}

}
