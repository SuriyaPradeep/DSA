import java.util.Arrays;
import java.util.Random;

public class Shuffling {
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
    public static void shuffle(Comparable[] arr){
        Random random = new Random();
        for(int i=0;i<arr.length;i++){
            int r= random.nextInt(0,i+1);
            swap(arr,i,r);
        }
    }

    public static void main(String[] args) {
        Integer[] arr={1, 2, 3, 4, 5, 10};
        shuffle(arr);
        System.out.println(isSorted(arr));
        System.out.println(Arrays.toString(arr));
        String[] stringArr = {"apple","banana","grape","kiwi","orange"};
        shuffle(stringArr);
        System.out.println(isSorted(stringArr));
        System.out.println(Arrays.toString(stringArr));
    }
}
