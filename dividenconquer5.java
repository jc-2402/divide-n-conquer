// Question 2 :Given an array nums of size n, returnthe majority element. (MEDIUM)
// The majority element is the element that appears more than⌊n/2⌋times.
// You may assume that the majority element always exists in the array.Sample Input 1: nums = [3,2,3]
// Sample Output 1: 3Sample Input 2: nums = [2,2,1,1,1,2,2]Sample Output 2: 2
// Constraints(extra Conditions):●n == nums.length●1 <= n <= 5 * 104●-109 <= nums[i] <= 109
import java.util.*;
public class dividenconquer5{
    // //by brute force
    // public static int majorityelement(int arr[]){
    //     int me = 0;
    //     for(int i=0; i<arr.length; i++){
    //        for(int j=i+1; j<arr.length ; j++){
    //         if(arr[i] == arr[j]){
    //             me = arr[i];
    //         }
    //        }
    //     }
    //     return me;
    // }
    public static void main(String args[]){
        int arr[] = {2,2,1,1,1,2,2};
        //System.out.println(majorityelement(arr));
        System.out.print( majorityElementRec(arr,0, arr.length-1));
    }



    //or by divide n conquer
    private static int countInRange(int[] nums,int num,int lo,int hi) 
    { int count=0;
      for(int i =lo;i<=hi; i++) {
        if(nums[i] ==num) {
            count++;
            }
        }
        return count;
    }
    public static int majorityElementRec(int[]nums,int lo,int hi) 
    {// base case; the only element in an arrayof size 1 is the majority
    // element.
    if(lo==hi) {
        return nums[lo];
    }
    // recurse on left and right halves of this slice.
    int mid= (hi-lo)/2+lo;
    int left = majorityElementRec(nums,lo,mid);
    int right = majorityElementRec(nums,mid+1,hi);
    // if the two halves agree on the majorityelement, return it.
    if(left==right) {
        return left;
    }
    // otherwise, count each element and returnthe "winner".
    int leftCount = countInRange(nums,left,lo,hi);
    int rightCount=countInRange(nums,right,lo,hi);
    return leftCount > rightCount ? left : right;
    }
}