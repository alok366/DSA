import java.util.Scanner;

public class BinarySearch {
    static void search(int ar[],int val)
    {
        int start=0;
        int end=ar.length-1;
        int pos=-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(ar[mid]==val)
            {
                pos=mid+1;
                break;
            }
            else if(ar[mid]<val)
            start=mid+1;
            else
            end=mid-1;
        }
        if(pos!=-1)
        System.out.println(val+" found at position "+pos);
        else
        System.out.println(val+" not found in array");
    }
    public static void main(String[] args) {
        int ar[]={4,10,20,30,40,50,60,64,92};
        Scanner in=new Scanner(System.in);
        System.out.println("Enter element to search in array");
        int val=in.nextInt();
        search(ar, val);
        in.close();
    }
}
