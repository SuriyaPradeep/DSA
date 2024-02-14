package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> {
    public  boolean less(T a,T b){
        if (a == b) {
            return false;
        }
        return a.compareTo(b)<0;
    }
    public  void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public boolean isSorted(T[] arr){
        boolean sorted=true;
        for(int i=1;i<arr.length;i++){
            if(less(arr[i],arr[i-1])){
                sorted=false;
                break;
            }
        }
        return sorted;
    }
    public void shuffle(T[] arr){
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            int r= random.nextInt(0,i+1);
            swap(arr,i,r);
        }
    }

    public  int partition(T[] arr,int low,int high){
        T pivot=arr[low];//First element as pivot
        int i=low;
        int j=high+1;
        while (true) {
            // find item on lo to swap
            while (less(arr[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            // find item on hi to swap
            while (less(pivot, arr[--j])) {
                if (j == low){
                    break;
                }
            }
            // check if pointers cross
            if (i >= j){
                break;
            }

            swap(arr, i, j);
        }
        // put partitioning item pivot at a[j]
        swap(arr, low, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    public void sort(T[] arr){
        shuffle(arr);
        sort(arr,0,arr.length-1);
        System.out.println(isSorted(arr));
    }
    public void sort(T[] arr,int low,int high){
        if(high<=low){
            return;
        }
        int pivot=partition(arr,low,high);
        sort(arr,low,pivot-1);
        sort(arr,pivot+1,high);
    }
    public static void main(String[] args) {
        QuickSort<Integer> qs1=new QuickSort<>();
        Integer[] arr={12, 11, 13, 5, 6, 7};
        qs1.sort(arr);
        System.out.println(Arrays.toString(arr));
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        QuickSort<String> qs2=new QuickSort<>();
        qs2.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));
    }
}