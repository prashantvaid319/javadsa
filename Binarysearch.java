public class Binarysearch{
    public static void main(String[] args){
        int [] arr ={2,3,4,5,6,7,8,9,10,11,13};
        int ans = binarysearch(arr, 1);
        System.out.println(ans);

    }
    static int binarysearch(int [] arr,int target){
        int start=0;
        int end =arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            } 
            else if (arr[mid]<target){
               start= mid+1;
            }else {
                end=mid-1;
            } 
        }
        return start;
    } 
}