package Sort;

import java.util.Arrays;

public class DijkstrasQuickSort<T extends Comparable<T>> {
    private void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void sort(T[] arr,int low,int high){
        if (high <= low) {
            return;
        }
        int lt = low, gt = high;//lt pivot pointer
        T v = arr[low];
        int i = low;
        while (i <= gt)
        {
            int cmp = arr[i].compareTo(v);//Compare pivot and ith variable
            if (cmp < 0) {
                swap(arr, lt++, i++);//If less swap i with pivot then increment position
            }
            else if (cmp > 0) {
                swap(arr, i, gt--);//If greater swap i with gt decrement gt
            }
            else {
                i++;//Equal means increment i
            }
        }
        sort(arr, low, lt - 1);
        sort(arr, gt + 1, high);
    }

    public static void main(String[] args) {
        DijkstrasQuickSort<Integer> dqs1=new DijkstrasQuickSort<>();
        Integer[] arr={12, 11, 13, 5, 6, 7};
        dqs1.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        DijkstrasQuickSort<String> dqs2=new DijkstrasQuickSort<>();
        dqs2.sort(stringArr,0,stringArr.length-1); // Corrected here
        System.out.println(Arrays.toString(stringArr));
    }
}