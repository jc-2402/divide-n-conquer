//sorted , rotated array with distinct no.s ( in asc order) . it is rotated at a pivot point. find the
//index of a given element
public class dividenconquer3{
    public static int search(int arr[], int target , int si, int ei){
        //base case
        if(si > ei){
            return -1;
        }
        //kaam
        int mid = si + (ei - si)/2;
        //case found
        if ( arr[mid] == target){
            return  mid;
        }
        //case 1 : on line 1
        if( arr[si] <= arr[mid]){
            //case a : left
            if(arr[si] <= target && target <= arr[mid]){
                return search(arr, target, si, mid-1);
            }
            //case b : right
            else{
                return search(arr, target, mid+1, ei);
            }
        }
        else{
            //case c : right
            if(arr[mid] <= target && target <= arr[ei]){
                return search(arr,target,mid+1, ei);
            }
            else{
                //case d : left
                return search(arr, target , si, mid -1);
            }

        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;// o/p -> 4
        int tarindex = search(arr,target,0,arr.length-1);
        System.out.print(tarindex);
    }
} 