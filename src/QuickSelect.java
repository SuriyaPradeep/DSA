import java.util.Random;

//It is an algorithm to find nth smallest element in an array without complete sorting
public class QuickSelect <T extends Comparable<T>>{
    public boolean less(T a,T b){
        return a.compareTo(b)<0;
    }
    public void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void shuffle(T[] arr){
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            int r= random.nextInt(0,i+1);
            swap(arr,i,r);
        }
    }
    //Basic Partition from quick sort
    public int partition(T[] arr,int low,int high){
        int i=low;
        int j=high+1;
        T pivot=arr[low];
        while (true){
            while (less(arr[++i],pivot)){
                if(i==high){
                    break;
                }
            }
            while (less(pivot,arr[--j])){
                if(j==low){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public T quickSelect(T[] arr,int k){
        shuffle(arr);
        int low=0;
        int high=arr.length-1;
        while (low<high){
            int j=partition(arr,low,high);
            if(j<k){
                low=j+1;
            } else if(j>k){
                high=j-1;
            } else {
                break;
            }
        }
        return arr[k-1];
    }
    public static void main(String[] args) {
        QuickSelect<Integer> qs1=new QuickSelect<>();
        Integer[] arr={12,11,13,5,6,7};
        System.out.println(qs1.quickSelect(arr,2));//Should return 2nd smallest element ie 6
    }

}
