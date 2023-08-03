import java.util.*;
class LinkedQueue2<E> implements queue<E>
{
    static private class Node<E>
    {
        E element;
        Node<E> next;
        Node(E element,Node<E> next)
        {
            this.element=element;
            this.next=next;
        }
        E getElement()
        {
            return this.element;
        }
        Node<E> getNext()
        {
            return this.next;
        }
        void setNext(Node<E> next)
        {
            this.next=next;
        }
    }
    int size=0;
    Node<E> front=null;
    Node<E> rear=null;
    public int size()
    {
        return this.size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void enqueue(E element)
    {
        Node<E> newest=new Node<E>(element,null);
        if(isEmpty())
        front=newest;
        else
        rear.setNext(newest);
        rear=newest;
        size++;
    }
    public E first()
    {
        if(isEmpty())return null;
        return front.getElement();
    }
    public E dequeue()
    {
        
        if(isEmpty())return null;
        Node<E> temp=front;
        E deleted=temp.getElement();
        temp=null;
        front=front.getNext();
        size--;
        return deleted;
    }
    void display()
    {
        Node<E> temp=front;
        while(temp!=null)
        {
            System.out.println(temp.getElement());
            temp=temp.getNext();
        }
    }
    public static void main(String args[])
    {
        LinkedQueue2<Integer> LQ=new LinkedQueue2<>();
        Integer element;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to retrieve size of queue");
            System.out.println("Press 2 to enqueue element on queue");
            System.out.println("Press 3 to peek front of queue");
            System.out.println("Press 4 to dequeue");
            System.out.println("Press 5 to display");
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
                case 5:LQ.display();
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