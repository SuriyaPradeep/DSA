package Sort;

import java.util.Arrays;

public class ShellSort {
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
    public static  <T extends Comparable<T>> void sort(T[] arr){
       int n=arr.length;
       int h=1;
       while(h<n/3){
           h=3*h+1;
       }
       while (h>=1){
           for(int i=h;i<n;i++){
               for(int j=i;j>=h && less(arr[j],arr[j-h]);j-=h){
                   swap(arr,j,j-h);
               }
           }
           h=h/3;
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
