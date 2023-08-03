class power
{
    static double pow1(double x,int n)
    {
        if(n==0)return 1;
        return x*pow1(x,n-1);
    }
    static double pow2(double x,int n)
    {
        if(n==0)return 1;
        double partial=pow2(x,n/2);
        double result=partial*partial;
        if(n%2==1)
        result*=x;
        return result;
    }
    public static void main(String args[])
    {
        long start,end;
        start=System.nanoTime();
        System.out.println("using pow1 2^13: "+pow1(2,13));
        end=System.nanoTime();
        System.out.println("total time: "+(end-start));
        start=System.nanoTime();
        System.out.println("using pow2 2^13: "+pow2(2,13));
        end=System.nanoTime();
        System.out.println("total time: "+(end-start));
    }
}