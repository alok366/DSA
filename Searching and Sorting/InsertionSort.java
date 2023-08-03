import java.util.Arrays;

public class InsertionSort {
    static void sort(int ar[])
    {
        for(int k=1;k<ar.length;k++)
        {
            int cur=ar[k];
            int j=k;
            for(;j>0&&cur<ar[j-1];j--)
            {
                ar[j]=ar[j-1];
            }
            ar[j]=cur;
        }
    }
    public static void main(String[] args) {
        int ar[]={10,9,8,7,6,5,4,3,2,1};
        System.out.println("Before sorting: "+Arrays.toString(ar));
        sort(ar);
        System.out.println("After sorting: "+Arrays.toString(ar));
    }
}
