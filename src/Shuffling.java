import java.util.Arrays;
import java.util.Random;

public class Shuffling {
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
    public static <T extends Comparable<T>>void shuffle(T[] arr){
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
