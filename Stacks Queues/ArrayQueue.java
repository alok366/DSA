import java.util.*;
class ArrayQueue<E> implements queue<E>
{
    E[] data;
    int size=0;
    int f=0;
    static final int CAPACITY=10;
    ArrayQueue()
    {
        this(CAPACITY);
    }
    ArrayQueue(int capacity)
    {
        data=(E[])new Object[capacity];
    }
    public int size()
    {
        return this.size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void enqueue(E e)throws IllegalStateException
    {
        if(data.length==size)throw new IllegalStateException("Queue is full");
        int avail=(f+size)%data.length;
        data[avail]=e;
        size++;
    }
    public E first()
    {
        if(isEmpty())return null;
        return data[f];
    }
    public E dequeue()
    {
        if(isEmpty())return null;
        E deleted=data[f];
        data[f]=null;
        f=(f+1)%data.length;
        size--;
        return deleted;
    }
    void display()
    {
        System.out.println(Arrays.toString(data));
    }
    public static void main(String args[])
    {
        ArrayQueue<Integer> AQ=new ArrayQueue<>();
        for(int i=0;i<10;i++)
        AQ.enqueue(i);
        Integer element;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to retrieve size of queue");
            System.out.println("Press 2 to enqueue element on queue");
            System.out.println("Press 3 to peek front of queue");
            System.out.println("Press 4 to dequeue");
            System.out.println("Press 5 to display queue");
            choice=in.nextInt();
            switch(choice)
            {
                case 1:System.out.println(AQ.size());
                break;
                case 2:System.out.println("Enter element to be enqueue onto the queue");
                element=in.nextInt();
                AQ.enqueue(element);
                break;
                case 3:System.out.println(AQ.first());
                break;
                case 4:System.out.println(AQ.dequeue()+" removed from the queue");
                break;
                case 5:AQ.display();
                break;
                default:System.out.println("Wrong choice");
                break;
            }
            System.out.println("To continue press 1");
            element=in.nextInt();
        }
        while(element==1);
    }
}