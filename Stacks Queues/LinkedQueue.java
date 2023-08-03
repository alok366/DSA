import java.util.*;
class LinkedQueue<E> implements queue<E>
{
    SinglyLinkedList<E> list=new SinglyLinkedList<>();
    LinkedQueue()
    {

    }
    public int size()
    {
        return list.size;
    }
    public boolean isEmpty()
    {
        return list.size==0;
    }
    public void enqueue(E element)
    {
        list.addLast(element);
    }
    public E dequeue()
    {
        return list.removeFirst();
    }
    public E first()
    {
        return list.first();
    }
    public static void main(String args[])
    {
        LinkedQueue<Integer> LQ=new LinkedQueue<>();
        Integer element;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to retrieve size of queue");
            System.out.println("Press 2 to enqueue element on queue");
            System.out.println("Press 3 to peek front of queue");
            System.out.println("Press 4 to dequeue");
            choice=in.nextInt();
            switch(choice)
            {
                case 1:System.out.println(LQ.size());
                break;
                case 2:System.out.println("Enter element to be enqueue onto the queue");
                element=in.nextInt();
                LQ.enqueue(element);
                break;
                case 3:System.out.println(LQ.first());
                break;
                case 4:System.out.println(LQ.dequeue()+" removed from the queue");
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