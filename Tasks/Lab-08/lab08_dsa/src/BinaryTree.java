import java.util.Arrays;

public class BinaryTree {
    int arr[];
    int size = 0;

    public BinaryTree(int size){    arr = new int[size];}

    public void insert(int e){ if(size != arr.length){ arr[size]=e;shiftUp(size++);} }

    public int getMax(){ int max = -1;if(size != 0)max = arr[0];return max;}

    public int extractMax(){int max = -1;if(size != 0){max = arr[0];size--;arr[0] = 0;shiftDown(0);}return max; }

    public void remove(int i){if(i>=0 && i <size){arr[i]=getMax()+1;shiftUp(i);extractMax();} }

    public void changePriority(int i,int newPriority){int old = arr[i];arr[i] = newPriority;if(old < newPriority)shiftUp(i);else shiftDown(i);}

    private void shiftUp(int i){
        int parIndex = getParentIndex(i);
        while (i>0 && arr[parIndex] < arr[i]){
            swap(i,parIndex);
            i = getParentIndex(i);
            parIndex = getParentIndex(i);
        }
    }

    private void shiftDown(int i){
        int maxIndex = i;
        int left = getLeft(i);
        if(left <= size && arr[left] > arr[maxIndex])   maxIndex = left;
        int right = getRight(i);
        if(right <= size && arr[right] > arr[maxIndex]) maxIndex = right;

        if(i != maxIndex){
            swap(i,maxIndex);
            shiftDown(maxIndex);
        }
    }

    private int getParentIndex(int i){if(i%2==0)i = i/2 - 1;else i = i/2;return i;}

    private int getLeft(int i){ return (2 * i + 1);}

    private int getRight(int i){return (2 * i + 2); }

    private void swap(int i, int j){int temp = arr[i];arr[i] = arr[j];arr[j] = temp;}

    public void print(){ System.out.println(Arrays.toString(arr)); }
}
