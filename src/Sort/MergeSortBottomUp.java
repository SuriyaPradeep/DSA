package Sort;

import java.util.Arrays;

public class MergeSortBottomUp<T extends Comparable <T>> {
    private boolean isLess(T a, T b){
        return a.compareTo(b)<0;
    }
    //To check is array is sorted
    private  boolean isSorted(T[] arr){
        boolean sorted=true;
        for(int i=1;i< arr.length;i++){
            if(isLess(arr[i],arr[i-1])){
                sorted=false;
                break;
            }
        }
        return sorted;
    }
    public void merge(T[] arr,int beg,int mid,int end){
        int n1=mid-beg+1;
        int n2=end-mid;
        T[] left= Arrays.copyOfRange(arr,beg,mid+1);
        T[] right=Arrays.copyOfRange(arr,mid+1,end+1);
        int i=0,j=0,k=beg;
        while(i<n1 && j<n2){
            if(isLess(right[j],left[i])){
                arr[k++]=right[j++];
            }else{
                arr[k++]=left[i++];
            }
        }
        while (i<n1){
            arr[k++]=left[i++];
        }
        while (j<n2){
            arr[k++]=right[j++];
        }
    }
    //Merging in bottom up manner
    //Starting with size as 1 then go 2,4 like that
    public void sort(T[] arr){
        if(arr==null || arr.length<=1){
            return;
        }
        int n=arr.length;
        for(int size=1;size<n;size*=2){
            for (int beg=0;beg<n-1;beg+=2*size){
                int mid=beg+size-1;
                int end=Math.min(beg+2*size-1,n-1);
                merge(arr,beg,mid,end);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        MergeSortBottomUp<Integer> ms1 = new MergeSortBottomUp<>();
        System.out.println(ms1.isSorted(arr));
        ms1.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ms1.isSorted(arr));
        MergeSortBottomUp<String> ms2 = new MergeSortBottomUp<>();
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println(ms2.isSorted(stringArr));
        ms2.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));
        System.out.println(ms2.isSorted(stringArr));
    }
}
