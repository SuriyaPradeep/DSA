package Sort;

import java.util.Arrays;

public class BubbleSort {
    private static void swap(Comparable[] arr, int i, int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    private static boolean isSorted(Comparable[] arr){
        for(int i=1;i< arr.length;i++){
            if(less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void sort(Comparable[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(less(arr[j],arr[i])){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr={10,5,1,4,3,2};
        sort(arr);
        System.out.println(isSorted(arr));
        System.out.println(Arrays.toString(arr));
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        sort(stringArr);
        System.out.println(isSorted(stringArr));
        System.out.println(Arrays.toString(stringArr));
    }
}
