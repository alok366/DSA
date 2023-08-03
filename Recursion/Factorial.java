class Factorial
{
    static int fact(int n)throws IllegalArgumentException
    {
        if(n<0)throw new IllegalArgumentException("n cannot be less than 0");
        else if(n==0)return 1;
        else
        return fact(n-1)*n;
    }
    public static void main(String args[])
    {
        System.out.println("factorial of 6 is: "+fact(6));
    }
}