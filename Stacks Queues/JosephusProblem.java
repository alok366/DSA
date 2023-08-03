class JosephusProblem
{
    static <E> LinkedQueue2<E> buildQueue(E[] elements)
    {
        LinkedQueue2<E> queue=new LinkedQueue2<>();
        for(int i=0;i<elements.length;i++)
        queue.enqueue(elements[i]);
        return queue;
    }
    static <E> E Josephus(LinkedQueue2<E> queue,int k)
    {
        if(queue.isEmpty())return null;
        while(queue.size>1)
        {
            for(int i=0;i<k-1;i++)
            {
                queue.enqueue(queue.dequeue());
            }
            E e=queue.dequeue();
            System.out.println(e+" is out");
        }
        return queue.dequeue();
    }
    public static void main(String args[])
    {
        String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[ ] a3 = {"Mike", "Roberto"};
        System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
        System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
        System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
    }
}