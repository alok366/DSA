import java.util.Arrays;
import java.util.Random;
class ArraysAndRandom
{
    public static void main(String args[])
    {
        int ar[]=new int[10];
        Random rand=new Random();
        rand.setSeed(System.currentTimeMillis());
        for(int i=0;i<ar.length;i++)
        ar[i]=rand.nextInt(100);
        int copy[]=Arrays.copyOf(ar,ar.length);
        System.out.println("Original array: "+Arrays.toString(copy));
        Arrays.sort(ar);
        System.out.println("Sorted array: "+Arrays.toString(ar));
    }
}