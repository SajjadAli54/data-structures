import java.util.Arrays;

public class PriorityQueueUsingSortedArray {
    int arr[];
    int top = 0;

    public PriorityQueueUsingSortedArray(int size){
        arr = new int[size];
    }

    public void insert(int e){
        if(arr.length != top ){
            arr[top++] = e;
            Arrays.sort(arr,0,top);
        }
    }

    public void setPriority(int e, int priority){
        if(top != 0) {
            for (int i = 0; i < top; i++) {
                if (e == arr[i]) {
                    arr[i] = priority;
                    break;
                }
            }
            Arrays.sort(arr,0,top);
        }
    }

    public int getMax(){
        if(top != 0) return arr[top-1];
        return -1;
    }

    public int extractMax(){
        int max = -1;
        if(top != 0){
            max = arr[--top];
            arr[top] = 0;
        }
        return max;
    }

    public void remove(int num) {
        if (top != -1) {
            int index = 0;
            for (int i = 1; i < top; i++) {
                if (num == arr[i]) {
                    index = i;
                    break;
                }
            }
            for (int i = index; i < top - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[--top] = 0;
        }
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}
