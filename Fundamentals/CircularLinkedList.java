import java.util.*;
class CircularLinkedList<E>
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
        Node<E> getNext()
        {
            return next;
        }
        E getElement()
        {
            return element;
        }
        void setNext(Node<E> next)
        {
            this.next=next;
        }
    }
        Node<E> tail=null;
        private int size=0;
        int size()
        {
            return size;
        }
        boolean isEmpty()
        {
            return size==0;
        }
        E first()
        {
            if(tail==null)return null;
            return tail.getNext().getElement();
        }
        E last()
        {
            if(tail==null)return null;
            return tail.getElement();
        }
        void addFirst(E element)
        {
            if(size==0)
            {
                tail=new Node<E>(element,null);
                tail.setNext(tail);
            }
            else
            {
                Node<E> newest=new Node<>(element,tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }
        void addLast(E element)
        {
            addFirst(element);
            tail=tail.getNext();
        }
        E removeFirst()
        {
            if(isEmpty())return null;
            Node<E> head=tail.getNext();
            if(tail==head)
            tail=null;
            else
            {
                tail.setNext(head.getNext());
            }
            size--;
            return head.getElement();
        }
        void rotate()
        {
            if(tail!=null)
            tail=tail.getNext();
        }
        void display()
        {
            if(isEmpty())
            System.out.println("List is empty");
            else
            {
                Node<E> temp=tail;
                while(true)
                {
                    System.out.println(temp.getElement());
                    temp=temp.getNext();
                    if(temp==tail)
                    break;
                }
            }
        }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Integer element;
        CircularLinkedList<Integer> list=new CircularLinkedList<>();
        do
        {
            System.out.println("Press 1 to get size of List");
            System.out.println("Press 2 to get first node of List");
            System.out.println("Press 3 to get last node of List");
            System.out.println("Press 4 to add node at start of List");
            System.out.println("Press 5 to add node at last of List");
            System.out.println("Press 6 to delete first node");
            System.out.println("Press 7 to display List");
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
                case 7:list.display();
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