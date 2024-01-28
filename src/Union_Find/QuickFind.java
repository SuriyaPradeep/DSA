package Union_Find;

import java.util.Arrays;

public class QuickFind {
    public static void main(String[] args) {
        int[] arr=new int[10];
        initialize(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isConnected(arr,5,6));
        union(arr,5,6);
        System.out.println(isConnected(arr,5,6));
        union(arr,5,4);
        System.out.println(isConnected(arr,4,6));
        System.out.println(Arrays.toString(arr));
    }
    public static void initialize(int[] arr){
        for(int i=0;i< arr.length;i++){
            arr[i]=i;
        }
    }
    public static void union(int[] arr,int p,int q){
        int pid=arr[p];
        int qid=arr[q];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==pid){
                arr[i]=qid;
            }
        }
    }
    public static boolean isConnected(int[] arr,int p,int q){
        return arr[p]==arr[q];
    }
}
