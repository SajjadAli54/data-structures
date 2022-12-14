import java.util.Arrays;

public class RecursiveMergeSort {
    public static void sort(Integer arr[]){
        if(arr.length < 2)return;
        Integer left[] = Arrays.copyOfRange(arr,0,arr.length/2);
        Integer right[] = Arrays.copyOfRange(arr,arr.length/2,arr.length);
        sort(left);
        sort(right);
        merge(left,right,arr);
    }

    private static void merge(Integer left[],Integer right[],Integer dest[]){
        int i = 0, j = 0, k = 0;
        while (i< left.length && j < right.length){
            if(left[i] <= right[j])
                dest[k++] = left[i++];
            else
                dest[k++] = right[j++];
        }
        while (i < left.length)
            dest[k++] = left[i++];
        while (j < right.length)
            dest[k++] = right[j++];
    }
}
