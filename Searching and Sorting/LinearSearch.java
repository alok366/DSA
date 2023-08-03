import java.util.Scanner;
class LinearSearch
{
    static void search(int ar[],int val)
    {
        int pos=-1;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]==val)
            {
                pos=i+1;
                break;
            }
        }
        if(pos!=-1)
        {
            System.out.println(val+" found in array at position: "+pos);
        }
        else
        System.out.println(val+" not found in array");
    }
    public static void main(String[] args) {
        int ar[]={10,4,9,49,91,71,23,4,-2};
        Scanner in=new Scanner(System.in);
        System.out.println("Enter element to search in array");
        int val=in.nextInt();
        search(ar, val);
        in.close();
    }
}