import java.util.*;
class Fibonacci
{
    static long[] fibo(int n)
    {
        if(n<=1)
        {
            long[] answer={n,0};
            return answer;
        }
        long[] temp=fibo(n-1);
        long[] answer={temp[0]+temp[1],temp[0]};
        return answer;
    }
    public static void main(String args[])
    {
        System.out.println("10th fibonacci number: "+Arrays.toString(fibo(10)));
    }
}