//Question1:Apply Merge sort to sort an array of Strings.(Assume that all the characters in 
//all the Strings are in lowercase). (EASY)
//Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}
//Sample Output 1: arr = { "earth", "mars", "mercury","sun"}
public class dividenconquer4{
    public static String[] mergesort(String arr[], int si, int ei){
        if( si == ei){
            String[] a = { arr[si]};
            return a;
        }
        int mid = si+ (ei - si)/2;
        String[] arr1 = mergesort(arr, si, mid);
        String[] arr2 = mergesort(arr, mid+1, ei);
        String[] arr3 = merge(arr1, arr2);
        return arr3;
    }
    public static String[] merge(String arr1[], String arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m+n];
        int i = 0;
        int j = 0;
        int index =0;

        
        //compare
        while( i< m && j< n){
            if( isAlphabeticallysmaleer(arr1[i], arr2[j])){
                arr3[index] = arr1[i];
                i++;
                index++;
            }else{
                arr3[index] = arr2[j];
                j++;
                index++;
            }
        }
        //left part ki bache hue elements
        while(i< m){
                arr3[index] = arr1[i];
                i++;
                index++;
        }
        //right part ki bache hue elements
        while(j< n){
            
                arr3[index] = arr2[j];
                j++;
                index++;
        }
        return arr3;
    }
    static boolean isAlphabeticallysmaleer(String str1, String str2){
        if(str1.compareTo(str2) < 0){
            return  true;
        }
        return false;
    }
    public static void main(String[] args) {
        String arr[] = {"sun", "earth", "mars", "mercury"};
        String a[] = mergesort(arr, 0, arr.length-1);
        for(int i=0; i< a.length; i++ ){
            System.out.print(a[i]+" ");
        }
    }
}