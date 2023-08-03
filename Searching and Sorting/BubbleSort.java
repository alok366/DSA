import java.util.Arrays;

public class BubbleSort {
    static void sort(int ar[])
    {
        int i;
        for(i=1;i<ar.length;i++)
        {
            for(int j=0;j<ar.length-i;j++)
            {
                if(ar[j]>ar[j+1])
                {
                    ar[j]=ar[j]+ar[j+1];
                    ar[j+1]=ar[j]-ar[j+1];
                    ar[j]=ar[j]-ar[j+1];
                }
            }
        }
        System.out.println("\nSorting done in "+i+" passes\n");
    }
    static void optimizedSort(int ar[])
    {
        for(int i=1;i<ar.length;i++)
        {
            int flag=0;
            for(int j=0;j<ar.length-i;j++)
            {
                if(ar[j]>ar[j+1])
                {
                    flag=1;
                    ar[j]=ar[j]+ar[j+1];
                    ar[j+1]=ar[j]-ar[j+1];
                    ar[j]=ar[j]-ar[j+1];
                }
            }
            if(flag==0)
            {
                System.out.println("\nSorting done in "+i+" passes\n");
                return;
            }
        }
    }
    public static void main(String[] args) {
        int ar[]={1,2,8,7,6,5,4,3,9,10};
        System.out.println("Before sorting: "+Arrays.toString(ar));
        sort(ar);
        System.out.println("After sorting: "+Arrays.toString(ar));
        int ar2[]={1,2,8,7,6,5,4,3,9,10};
        System.out.println("Before sorting: "+Arrays.toString(ar2));
        optimizedSort(ar2);
        System.out.println("After sorting: "+Arrays.toString(ar2));
    }
}
