package Search;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr={11,23,32,41,52,65,72,83,97};
        System.out.println("Element to be searched in the array:");
        int num=scanner.nextInt();
        int result=Search(arr,num);
        if(result==-1){
            System.out.println("Element not Found");
        } else{
            System.out.println("Element "+num+" found at index "+result);
        }
    }
    public static int Search(int[] arr,int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }
}
