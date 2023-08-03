import java.util.Arrays;

public class QuickSort {
    static int partition(int ar[],int beg,int end)
    {
        int left=beg,pivot=beg,right=end;
        boolean flag=false;
        while(!flag)
        {
            while(ar[pivot]<ar[right]&&pivot!=right)
            right--;
            if(pivot==right)
            flag=true;
            if(ar[pivot]>ar[right])
            {
                ar[pivot]=ar[pivot]+ar[right];
                ar[right]=ar[pivot]-ar[right];
                ar[pivot]=ar[pivot]-ar[right];
                pivot=right;
            }
            if(!flag)
            {
                while(ar[pivot]>ar[left]&&left!=right)
                left++;
                if(pivot==left)
                flag=true;
                if(ar[pivot]<ar[left])
                {
                    ar[pivot]=ar[pivot]+ar[left];
                    ar[left]=ar[pivot]-ar[left];
                    ar[pivot]=ar[pivot]-ar[left];
                    pivot=left;
                }
            }
        }
        return pivot;
    }

    static void sort(int ar[], int beg, int end) {
        if (beg < end) {
            int pivot = partition(ar, beg, end);
            sort(ar, beg, pivot - 1);
            sort(ar, pivot + 1, end);
            // pivot-1 and pivot+1 bcoz pivot is already at its correct position
        }
    }
    public static void main(String[] args) {
        int ar[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Before sorting: " + Arrays.toString(ar));
        sort(ar, 0, ar.length - 1);
        System.out.println("After sorting: " + Arrays.toString(ar));
    }
}
