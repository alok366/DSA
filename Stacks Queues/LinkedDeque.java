import java.util.*;
class LinkedDeque<E> implements deque<E>
{
    private static class Node<E>
    {
        E element;
        Node<E> prev;
        Node<E> next;
        Node(E element,Node<E> prev,Node<E> next)
        {
            this.element=element;
            this.prev=prev;
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
        Node<E> getPrev()
        {
            return this.prev;
        }
        void setPrev(Node<E> prev)
        {
            this.prev=prev;
        }
        void setNext(Node<E> next)
        {
            this.next=next;
        }
    }
    Node<E> header=null;
    Node<E> trailer=null;
    int size=0;
    LinkedDeque()
    {
        header=new Node<E>(null,null,null);
        trailer=new Node<E>(null,header,null);
        header.setNext(trailer);
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public E first()
    {
        if(isEmpty())return null;
        return header.getNext().getElement();
    }
    public E last()
    {
        if(isEmpty())return null;
        return trailer.getPrev().getElement();
    }
    void addBetween(E element,Node<E> predecessor,Node<E> successor)
    {
        Node<E> newest=new Node<E>(element,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    public void addFirst(E element)
    {
        addBetween(element,header,header.getNext());
    }
    public void addLast(E element)
    {
        addBetween(element,trailer.getPrev(),trailer);
    }
    E remove(Node<E> node)
    {
        Node<E> predecessor=node.getPrev();
        Node<E> successor=node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public E removeFirst()
    {
        if(isEmpty())return null;
        return remove(header.getNext());
    }
    public E removeLast()
    {
        if(isEmpty())return null;
        return remove(trailer.getPrev());
    }
    void display()
    {
        if(isEmpty())
        System.out.println("Deque is empty");
        else
        {
            Node<E> temp=header.getNext();
            while(temp!=trailer)
            {
                System.out.println(temp.getElement());
                temp=temp.getNext();
            }
        }
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Integer element;
        LinkedDeque<Integer> list=new LinkedDeque<>();
        do
        {
            System.out.println("Press 1 to get size of deque");
            System.out.println("Press 2 to get first node of deque");
            System.out.println("Press 3 to get last node of deque");
            System.out.println("Press 4 to add node at start of deque");
            System.out.println("Press 5 to add node at last of deque");
            System.out.println("Press 6 to delete first deque");
            System.out.println("Press 7 to delete last deque");
            System.out.println("Press 8 to display deque");
            int choice=in.nextInt();
            switch(choice)
            {
                case 1:element=list.size();
                System.out.println("Size of list "+element);
                break;
                case 2:element=list.first();
                System.out.println("First element in list "+element);
                break;
                case 3:element=list.last();
                System.out.println("Last element in list "+element);
                break;
                case 4:System.out.println("Enter the data for node");
                element=in.nextInt();
                list.addFirst(element);
                break;
                case 5:System.out.println("Enter the data for last node");
                element=in.nextInt();
                list.addLast(element);
                break;
                case 6:element=list.removeFirst();
                System.out.println(element+" is deleted from list");
                break;
                case 7:element=list.removeLast();
                System.out.println(element+" is deleted from list");
                break;
                case 8:list.display();
                break;
                default:System.out.println("Invalid option selected");
                break;
            }
            System.out.println("to continue type 1");
            element=in.nextInt();
        }
        while(element==1);
    }
}