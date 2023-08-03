interface SomeFunc<T>
{
    void sort(T[] arr);
}
class InsertionSort
{
    public static void main(String args[])
    {
        Integer[] ar={9,8,7,6,5,4,3,2,1};
        SomeFunc<Integer> sf=(arr)->
        {
            for(int i=1;i<arr.length;i++)
            {
                int cur=arr[i];
                int j=i;
                for(;j>0 && cur<arr[j-1];j--)
                {
                    arr[j]=arr[j-1];
                }
                arr[j]=cur;
            }
            for(int el:arr)
            System.out.print(el+"\t");
        };
        sf.sort(ar);
        System.out.println();
        Character[] c={'b','c','a','d','g','e','f'};
        SomeFunc<Character> sf2=(cr)->
        {
            for(int i=1;i<cr.length;i++)
            {
                char cur=cr[i];
                int j=i;
                while(j>0 && cur<cr[j-1])
                {
                    cr[j]=cr[j-1];
                    j--;
                }
                cr[j]=cur;
            }
            for(char el:cr)
            System.out.print(el+"\t");
        };
        sf2.sort(c);
    }
}