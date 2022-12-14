import java.util.Arrays;

public class PriorityQueueUsingArray {
    int arr[];
    int k = -1;

    public PriorityQueueUsingArray(int size){
        arr = new int[size];
    }

    public void insert(int e){
        if(arr.length != k+1){
            arr[++k] = e;
        }
    }

    public int getMax(){
        int max = -1;
        if(k != -1) {
            max = arr[0];
            for (int i = 1; i <= k; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
        }
        return max;
    }

    public int extractMax(){
        int max = -1;
        if(k != -1){
            max = arr[0];
            int index = 0;
            for(int i=1;i<=k;i++){
                if(max < arr[i]){
                    max = arr[i];
                    index = i;
                }
            }
            for(int i = index;i<k;i++){
                arr[i] = arr[i+1];
            }
            arr[k] = 0;
            k--;
        }
        return max;
    }

    public void setPriority(int e, int priority){
        if(k != -1) {
            for (int i = 0; i <= k; i++) {
                if (e == arr[i]) {
                    arr[i] = priority;
                    break;
                }
            }
        }
    }

    public void remove(int num){
        if(k != -1){
            int index = 0;
            for(int i=1;i<=k;i++){
                if(num == arr[i]){
                    index = i;
                    break;
                }
            }
            for(int i = index;i<k;i++){
                arr[i] = arr[i+1];
            }
            arr[k] = 0;
            k--;
        }
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}
