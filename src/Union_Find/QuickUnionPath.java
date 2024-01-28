package Union_Find;

import java.util.Arrays;

public class QuickUnionPath {
    public static void main(String[] args) {
        int[] arr=new int[10];
        initialize(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isConnected(arr,5,6));
        union(arr,5,6);
        System.out.println(Arrays.toString(arr));
        System.out.println(isConnected(arr,5,6));
        union(arr,2,4);
        System.out.println(Arrays.toString(arr));
        union(arr,2,3);
        System.out.println(Arrays.toString(arr));
        union(arr,5,3);
        System.out.println(isConnected(arr,4,6));
        System.out.println(Arrays.toString(arr));
    }
    public static void initialize(int[] arr){
        for(int i=0;i< arr.length;i++){
            arr[i]=i;
        }
    }
    public static int findRoot(int [] arr,int i){
        while(arr[i]!=i){
            arr[i] = arr[arr[i]];
            i=arr[i];
        }
        return i;
    }
    public static boolean isConnected(int[] arr,int p,int q){
        return findRoot(arr,p)==findRoot(arr,q);
    }
    public static void union(int[] arr,int p,int q){
        int i=findRoot(arr,p);
        int j=findRoot(arr,q);
        arr[i]=j;

    }
}
