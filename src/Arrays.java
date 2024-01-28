public class Arrays {
    static int[] arr;
    public static void main(String[] args) {
        arr=new int[10];
        for(int i=0;i<5;i++){
            arr[i]=i*10;
        }
        traverse();
        System.out.println(Search(0));
        insert(35,4,5);
        insert(25,3,6);
        insert(50,7,7);
        insert(60,8,8);
        insert(70,9,9);
        traverse();
        delete(35);
        delete(25);
        traverse();

    }
    public static void traverse(){
        //Visit every element's in the array
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int Search(int num){
        //Find index position for the searched element
        int beg=0;
        int end=arr.length-1;
        int mid;
        while(beg<=end){
            mid=(end+beg)/2;
            if(arr[mid]==num){
                return mid;
            } else if(arr[mid]<num){
                beg=mid+1;
            } else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void insert(int num,int pos,int len){
        //Insert certain Element in given position
        //Here n is number of filled spaces
        for(int i=len;i>pos;i--){
            arr[i]=arr[i-1];
        }
        arr[pos]=num;
    }
    public static void delete(int num){
        //Delete certain element
        int pos=Search(num);
        if(pos==-1){
            System.out.println("Element not in the array");
            return;
        }
        for (int i = pos; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
        }
        arr[arr.length-1]=0;
    }
}
