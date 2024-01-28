package Union_Find;

import java.util.Arrays;

public class QuickUnionWeighted {
    public static void main(String[] args) {
        int[] arr=new int[10];
        int[] size=new int[10];
        initialize(arr,size);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(size));
        System.out.println(isConnected(arr,5,6));
        union(arr,size,5,6);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(size));
        System.out.println(isConnected(arr,5,6));
        union(arr,size,2,4);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(size));
        union(arr,size,2,3);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(size));
        union(arr,size,5,3);
        System.out.println(isConnected(arr,4,6));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(size));
    }
    public static void initialize(int[] arr,int[] size){
        for(int i=0;i< arr.length;i++){
            arr[i]=i;
            size[i]=1;

        }
    }
    public static int findRoot(int [] arr,int i){
        while(arr[i]!=i){
            i=arr[i];
        }
        return i;
    }
    public static boolean isConnected(int[] arr,int p,int q){
        return findRoot(arr,p)==findRoot(arr,q);
    }
    public static void union(int[] arr,int[] size,int p,int q){
        int i=findRoot(arr,p);
        int j=findRoot(arr,q);
        if(i==j){
            return;
        }
        // make smaller root point to larger one
        if(size[i]<=size[j]){
            arr[i]=j;
            size[j]+=size[i];
        } else{
            arr[j]=i;
            size[i]+=size[j];
        }

    }
}
