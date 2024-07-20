//merge sort algo
public class dividenconquer1{
    public static void printarr(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergesort(int arr[], int si, int ei){
        //base case
        if(si >= ei){
            return;
        }
        //mid
        int mid = si + (ei - si) / 2; //1st step
        mergesort(arr, si, mid); // 2nd step . .. leftpart sorted
        mergesort(arr, mid+1, ei); //right part sorted
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left
        int j = mid+1; //iterator for right
        int k =0; //iterator for temp arr

        //compare
        while( i<= mid && j<= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //left part ki bache hue elements
        while(i<= mid){
            temp[k++] = arr[i++];
        }
        //right part ki bache hue elements
        while(j<= ei){
            temp[k++] = arr[j++];
        }
        //copy temp to original arr
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] ={6,3,9,5,2,8, -2};
        mergesort(arr, 0, arr.length-1);
        printarr(arr);
    }
}