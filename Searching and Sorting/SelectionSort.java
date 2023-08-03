import java.util.Arrays;

public class SelectionSort {
    static void sort(int ar[]) {
        for (int i = 1; i < ar.length; i++) {
            int small = i-1;
            for (int j = i ; j < ar.length; j++) {
                if (ar[small] > ar[j])
                    small = j;
            }
            if (small != i-1) {
                ar[i-1] = ar[i-1] + ar[small];
                ar[small] = ar[i-1] - ar[small];
                ar[i-1] = ar[i-1] - ar[small];
            }
        }
    }

    public static void main(String[] args) {
        int ar[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Before sorting: " + Arrays.toString(ar));
        sort(ar);
        System.out.println("After sorting: " + Arrays.toString(ar));
    }
}
