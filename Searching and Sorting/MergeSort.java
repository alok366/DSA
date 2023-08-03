import java.util.Arrays;

public class MergeSort {
    static void merge(int ar[], int beg, int mid, int end) {
        int i = beg, j = mid + 1, index = beg;
        int temp[] = new int[end + 1];
        while ((i <= mid) && (j <= end)) {
            if (ar[i] < ar[j])
                temp[index++] = ar[i++];
            else
                temp[index++] = ar[j++];
        }
        while (i <= mid)//if smaller elements were mostly on j side i:9,10 and j:1,2
            temp[index++] = ar[i++];
        while (j <= end)//if smaller elements were mostly on i side i:1,2 and j:9,10
            temp[index++] = ar[j++];
        int k = beg;
        while (k < index) {
            ar[k] = temp[k];
            k++;
        }
    }

    static void mergeSort(int ar[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(ar, beg, mid);
            mergeSort(ar, mid + 1, end);
            merge(ar, beg, mid, end);
        }
    }

    public static void main(String[] args) {
        int ar[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Before sorting: " + Arrays.toString(ar));
        mergeSort(ar, 0, ar.length - 1);
        System.out.println("After sorting: " + Arrays.toString(ar));
    }
}
