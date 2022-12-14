import java.util.Arrays;

public class IterativeMergeSort {
    public static void iterativeMergeSort(Integer arr[]){
        Integer[] left = null, right = null;
        for(var i = 1;i< arr.length;i = 2 * i){
            for(var j = 0;j< arr.length;j += 2 * i){
                var end = 2 * i - 1 +j;
                var mid = Math.min((j + 1 + end)/2, arr.length);
                end = Math.min(end, arr.length-1);
                left = Arrays.copyOfRange(arr,j,mid);
                right = Arrays.copyOfRange(arr,mid,end + 1);
                int x = 0, y = 0, k = j;
                while (x < left.length && y < right.length){
                    if(left[x] < right[y])
                        arr[k++] = left[x++];
                    else
                        arr[k++] = right[y++];
                }
                while (x < left.length)
                    arr[k++] = left[x++];
                while (y < right.length)
                    arr[k++] = right[y++];
            }
        }
    }
}
