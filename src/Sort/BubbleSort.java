package Sort;

import java.util.Arrays;

public class BubbleSort {
    /*The <T extends Comparable<T>> syntax in the method signatures indicates that the generic type T must extend
    the Comparable<T> interface, ensuring type safety.*/
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static <T extends Comparable<T>> boolean less(T a,T b){
        return a.compareTo(b)<0;
    }
    private static <T extends Comparable<T>> boolean isSorted(T[] arr){
        for(int i=1;i< arr.length;i++){
            if(less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }
    public static <T extends Comparable<T>> void sort(T[] arr){
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
