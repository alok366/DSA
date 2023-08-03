class BinarySum
{
    static int sum(int data[],int low,int high)
    {
        if(low==high)return data[low];
        int mid=(low+high)/2;
        return sum(data,low,mid)+sum(data,mid+1,high);
    }
    public static void main(String args[])
    {
        int ar[]={1,2,3,4,5,6};
        System.out.println("sum of array: "+sum(ar,0,ar.length-1));
    }
}