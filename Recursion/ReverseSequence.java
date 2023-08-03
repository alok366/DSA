import java.util.*;
class ReverseSequence
{
    static void reverse(int data[],int low,int high)
    {
        if(low<high)
        {
            data[low]=data[low]+data[high];
            data[high]=data[low]-data[high];
            data[low]=data[low]-data[high];
            reverse(data,low+1,high-1);
        }
    }
    public static void main(String args[])
    {
        int data[]={1,2,3,4,5};
        reverse(data,0,data.length-1);
        System.out.println("data in reverse is: "+Arrays.toString(data));
    }
}