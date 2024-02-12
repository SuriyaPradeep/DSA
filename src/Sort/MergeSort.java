package Sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
    //To compare 2 elements
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
    //Sort function to enter beg and end
    public void sort(T[] arr){
        if(arr==null || arr.length<=1){
            return;
        }
        mergerSort(arr,0,arr.length-1);
    }
    //To merge two sub-array in sorted manner
   public void merge(T[] arr,int beg,int mid,int end){
        //Size of 2 arrays
       int n1=mid-beg+1;
       int n2=end-mid;
       //Creating and copying elements to aux arrays
       T[] left=Arrays.copyOfRange(arr,beg,mid+1);
       T[] right=Arrays.copyOfRange(arr,mid+1,end+1);
       // Merging the array
       int i=0,j=0,k=beg;
       //i left array pointer, j right array pointer, k main array pointer
       while(i<n1 && j<n2){
           if(isLess(right[j],left[i])){
               arr[k++]=right[j++];
           }else{
               arr[k++]=left[i++];
           }
       }
       //Copy remaining elements
       while(i<n1){
           arr[k++]=left[i++];
       }
       while(j<n2){
           arr[k++]=right[j++];
       }
   }
   public void mergerSort(T[] arr,int beg,int end){
        //Checks for base condition
        if(beg<end){
            int mid=(beg+end)/2;
            mergerSort(arr,beg,mid);
            mergerSort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }
   }
    
    // Main method to test the MergeSort class
    public static void main(String[] args) {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        MergeSort<Integer> ms1 = new MergeSort<>();
        System.out.println(ms1.isSorted(arr));
        ms1.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ms1.isSorted(arr));
        MergeSort<String> ms2 = new MergeSort<>();
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println(ms2.isSorted(stringArr));
        ms2.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));
        System.out.println(ms2.isSorted(stringArr));
    }
}
