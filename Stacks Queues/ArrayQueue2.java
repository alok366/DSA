import java.util.*;
class ArrayQueue2<E> implements queue<E>
{
    E[] data;
    static int CAP=10;//static bcoz constructor is called first 
    ArrayQueue2()
    {
        this(CAP);
    }
    ArrayQueue2(int capacity)
    {
        data=(E[])new Object[capacity];
    }
    int front=-1;
    int rear=-1;
    int size=0;
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void enqueue(E element)
    {
        if(size==data.length)
        System.out.println("Queue is full");
        else
        {
            if(front==-1&&rear==-1)
            {
                front=rear=0;
                data[rear]=element;
            }
            else
            {
                data[++rear]=element;
            }
            size++;
        }
    }
    public E first()
    {
        if(isEmpty())return null;
        return data[front];
    }
    public E dequeue()
    {
        if(isEmpty())return null;
        E deleted=data[front];
        data[front]=null;
        front++;
        size--;
        return deleted;
    }
    void display()
    {
        int temp=front;
        while(temp<=rear)
        {
            System.out.println(data[temp++]);
        }
    }
    public static void main(String args[])
    {
        ArrayQueue2<Integer> AQ=new ArrayQueue2<>();
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