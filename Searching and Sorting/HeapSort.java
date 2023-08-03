import java.util.Arrays;

public class HeapSort {
    static void heapUp(int heap[],int index)
    {
        int val=heap[index];
        while(index>1&&heap[index/2]<val)
        {
            heap[index]=heap[index/2];
            index/=2;
        }
        heap[index]=val;
    }
    static void heapDown(int heap[],int n)
    {
        int val=heap[1];
        int j=2;
        while(j<=n)
        {
            if((j<n)&&(heap[j]<heap[j+1]))
            j++;
            if(heap[j]<heap[j/2])
            break;
            heap[j/2]=heap[j];
            j*=2;
        }
        heap[j/2]=val;
    }
    public static void main(String[] args) {
        int ar[] = { 10, 92, 872, 17, 316, 25, 49, 30, 12, 1 };
        int heap[]=new int[ar.length+1];
        System.out.println("Before sorting: " + Arrays.toString(ar));
        for(int i=1;i<=ar.length;i++)
        {
            heap[i]=ar[i-1];
            heapUp(heap, i);
        }
        System.out.println(Arrays.toString(heap));
        for(int i=1;i<heap.length;i++)
        {
            int temp=heap[1];
            heap[1]=heap[heap.length-1];
            heap[heap.length-1]=temp;
            System.out.println(Arrays.toString(heap));
            heapDown(heap, heap.length-1-i);
        }
        System.out.println("After sorting: "+Arrays.toString(heap));
    }
}
