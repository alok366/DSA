import java.util.Arrays;

public class BucketSort {
    static void sort(int ar[])
    {
        int bucket[][]=new int[10][10];
        int buckcount[]=new int[10];
        int largest=ar[0];
        int pass=0,rem,div=1;
        for(int i=1;i<ar.length;i++)
        {
            if(ar[i]>largest)
            largest=ar[i];
        }
        while(largest!=0)
        {
            pass++;
            largest/=10;
        }
        for(int p=0;p<pass;p++)
        {
            for(int i=0;i<10;i++)
            buckcount[i]=0;
            for(int j=0;j<ar.length;j++)
            {
                rem=(ar[j]/div)%10;
                bucket[rem][buckcount[rem]]=ar[j];
                buckcount[rem]+=1;
            }
            int k=0;
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<buckcount[i];j++)
                ar[k++]=bucket[i][j];
            }
            div*=10;
        }
    }
    public static void main(String[] args) {
        int ar[] = { 10, 92, 872, 17, 316, 25, 49, 30, 12, 1 };
        System.out.println("Before sorting: " + Arrays.toString(ar));
        sort(ar);
        System.out.println("After sorting: " + Arrays.toString(ar));
    }
}
