package Search;

import java.util.Scanner;

public class BinarySearch {
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
        int beg=0;
        int end=arr.length-1;
        int mid;
        while(beg<=end) {
            mid = (beg+end) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }
}
