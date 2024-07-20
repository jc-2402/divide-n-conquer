//quick sort
public class dividenconquer2{
    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void quicksort(int arr[], int si, int ei){
        if( si >= ei){
            return;
        }
        //last element
        int pivotindex = partition(arr, si, ei);
        quicksort(arr, si, pivotindex-1);//left
        quicksort(arr, pivotindex+1, ei);//right
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; // i =-1 .. to make place for elemenst smaller than pivot
        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int t =arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        } 
        //for pivot
        i++;
        int t = pivot;
        arr[ei] = arr[i]; // i is pointing towards pivot rn
        arr[i] =t;
        return i;
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5, -5};
        quicksort(arr, 0, arr.length-1);
        printarr(arr);
    }
}