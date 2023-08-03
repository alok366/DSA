import java.util.Scanner;

public class JumpSearch {
    static void search(int ar[],int val)
    {
        int pos=-1;
        int start=0;
        int end=ar.length-1;
        int step=(int)Math.sqrt(ar.length);
        int i=0;
        while(i<step)
        {
            if(val<ar[step])
            end=step-1;
            else
            start=step+1;
            i++;
        }
        i=start;
        while(i<=end)
        {
            if(ar[i]==val)
            {
                pos=i+1;
                break;
            }
            i++;
        }
        if(pos==-1)
        System.out.println(val+" not found in array");
        else
        System.out.println(val+" found at position: "+pos);
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
