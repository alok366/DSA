class BinarySearch
{
    static boolean search(int data[],int target,int low,int high)
    {
        if(low>high)return false;
        else 
        {
            int mid=(low+high)/2;
            if(data[mid]==target)return true;
            else if(target<data[mid])
            return search(data,target,low,mid-1);
            else
            return search(data,target,mid+1,high);
        }
    }
    public static void main(String args[])
    {
        int intArr[]={2,4,5,6,7,12,18,19,22,25,27,31,34,37};
        System.out.println("22 is present in sequence "+search(intArr,22,0,intArr.length-1));
    }
}