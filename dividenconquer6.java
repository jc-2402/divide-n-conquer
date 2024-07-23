// //Question 3 :Given an array of integers. Find theInversion Countin the array. (HARD)
// Inversion Count:For an array, inversion count indicate show far(orclose)the array is from being 
// sorted.If the array is already sorted then the inversion count is 0.If an array is sorted in 
// the reverse order then the inversion count is the maximum.Formally, two elements a[i] and a[j] 
// form an inversion if a[i] > a[j] and i < j.Sample Input 1: N = 5, arr[ ] = {2, 4, 1, 3, 5}
// Sample Output 1: 3, because it has 3 inversions -(2, 1), (4, 1), (4, 3).
public class dividenconquer6{
//brute force

    // public static int getinvcount(int arr[]){
    //     int n = arr.length;
    //     int invcount = 0;
    //     for(int i=0; i<n-1; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(arr[i] > arr[j]){
    //                 invcount++;
    //             }
    //         }
    //     }
    //     return invcount;
    // }

    //or by modified merge sort
    public static int merge(int arr[], int left, int mid, int right){
        int i=left, j=mid , k =0;
        int invcount=0;
        int temp[] = new int[(right - left + 1)];

        while((i < mid) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp [k] = arr[i];
                k++;
                i++;
            }
            else{
                temp[k] = arr[j];
                invcount += (mid -i);
                k++;
                j++;
            }
        }
        while(i< mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= right){
            temp[k] = arr[j];
            k++;
            j++;
        }
        for(i = left , k=0; i<= right; i++, k++){
            arr[i] = temp[k];
        }
        return invcount;
    }
    private static int mergesort(int arr[], int left, int right){
        int invcount =0;
        if(right > left){
            int mid = (right + left)/2;

            invcount = mergesort(arr, left, mid);
            invcount += mergesort(arr, mid+1, right);
            invcount += merge(arr, left, mid+1, right);
        }
        return invcount;
    
    }
    public static int getinvcount(int arr[]){
        int n= arr.length;
        return  mergesort(arr, 0, n-1);
    }
    public static void main(String[] args) {
        int arr[] = {1,20,6,4,5};
        System.out.println("inversion count = "+getinvcount(arr));
    }
}