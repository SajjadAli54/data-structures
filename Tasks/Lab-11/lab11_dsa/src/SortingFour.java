import java.util.Arrays;

public class SortingFour {
    public static void sortFour(int arr[]){
        int left[] = Arrays.copyOfRange(arr,0,2);
        int right[] = Arrays.copyOfRange(arr,2,4);
        if(left[0] > left[1])
            swap(left,0,1);
        if(right[0] > right[1])
            swap(right,0,1);
        int i = 0, j = 0;
        if(left[i] <= right[j])
            arr[0] = left[i++];
        else
            arr[0] = right[j++];

        if(left[i] <= right[j])
            arr[1] = left[i++];
        else
            arr[1] = right[j++];

        if(i > 1){
            arr[2] = right[0];
            arr[3] = right[1];
        }
        else if(j > 1){
            arr[2] = left[0];
            arr[3] = left[1];
        }
        else if(left[i] <= right[j]){
            arr[2] = left[i];
            arr[3] = right[j];
        }
        else {
            arr[2] = right[j];
            arr[3] = left[i];
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int arr[],int i,int j){
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,3,1};
        sortFour(arr);
        System.out.println(Arrays.toString(arr));
    }
}
