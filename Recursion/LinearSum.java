class LinearSum
{
    static int sum(int data[],int n)
    {
        if(n==0)return 0;
        return sum(data,n-1)+data[n-1];
    }
    public static void main(String args[])
    {
        int data[]={1,2,3,4,5};
        System.out.println("sum of array is: "+sum(data,data.length));
    }
}