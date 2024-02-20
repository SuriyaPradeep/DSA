package Sort;

import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> {
    private boolean less(T a,T b){
        return a.compareTo(b)<0;
    }
    private boolean isSorted(T[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(!less(arr[i],arr[i+1])){
                return false;
            }
        }
        return true;
    }
    private void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private void sink(T[] arr,int k,int n){
        while (2*k+1<n){
            int j=2*k+1;
            if(j<n-1 && less(arr[j],arr[j+1])){
                j++;
            }
            if (!less(arr[k], arr[j])) {
                break;
            }
            swap(arr,k,j);
            k=j;
        }
    }
    private void sort(T[] arr){
        int n = arr.length;
        //heapify
        //Change the array into heap
        for (int k = n/2-1; k >= 0; k--)
            sink(arr, k, n);

        //sort-down phase
        for (int k = n - 1; k > 0; k--) {
            swap(arr, 0, k);
            sink(arr, 0, k);
        }
    }

    public static void main(String[] args) {
        HeapSort<Integer> hs1=new HeapSort<>();
        Integer[] arr={12, 11, 13, 5, 6, 7};
        hs1.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(hs1.isSorted(arr));
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        HeapSort<String> hs2=new HeapSort<>();
        hs2.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));
        System.out.println(hs2.isSorted(stringArr));
    }
}
