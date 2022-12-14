import java.util.Arrays;

public class TwoSum {
    public static boolean twoSum(Integer arr[], int k){
        RecursiveMergeSort.sort(arr);
        int start = 0, end = arr.length - 1;
        while (start < end){
            if(arr[start] + arr[end] < k)
                start++;
            else if(arr[start] + arr[end] > k)
                end--;
            else
                return true;
        }
        return false;
    }
}
