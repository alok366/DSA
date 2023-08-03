import java.util.*;
class DoublyLinkedListSentinel<E>
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
            return element;
        }
        void setElement(E element)
        {
            this.element=element;
        }
        Node<E> getPrev()
        {
            return prev;
        }
        Node<E> getNext()
        {
            return next;
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
    Node<E> header;
    Node<E> trailer;
    int size=0;
    DoublyLinkedListSentinel()
    {
        header=new Node<E>(null,null,null);
        trailer=new Node<E>(null,header,null);
        header.setNext(trailer);
    }
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
        return header.getNext().getElement();
    }
    E last()
    {
        return trailer.getPrev().getElement();
    }
    void addBetween(E element,Node<E> predecessor,Node<E> successor)
    {
        Node<E> newest=new Node<>(element,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    void addFirst(E element)
    {
        addBetween(element,header,header.getNext());
    }
    void addLast(E element)
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
    E removeFirst()
    {
        if(isEmpty())return null;
        return remove(header.getNext());
    }
    E removeLast()
    {
        if(isEmpty())return null;
        return remove(trailer.getPrev());
    }
    void display()
    {
        if(isEmpty())
        System.out.println("List is Empty");
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
    void reverse()
    {
        if(isEmpty())
        System.out.println("List is Empty");
        else
        {
            Node<E> low=header.getNext();
            Node<E> high=trailer.getPrev();
            while(low.getElement()!=high.getElement())
            {
                System.out.println("working");
                E temp=low.getElement();
                low.setElement(high.getElement());
                high.setElement(temp);
                low=low.getNext();
                high=high.getPrev();
            }
        }
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Integer element;
        DoublyLinkedListSentinel<Integer> list=new DoublyLinkedListSentinel<>();
        do
        {
            System.out.println("Press 1 to get size of List");
            System.out.println("Press 2 to get first node of List");
            System.out.println("Press 3 to get last node of List");
            System.out.println("Press 4 to add node at start of List");
            System.out.println("Press 5 to add node at last of List");
            System.out.println("Press 6 to delete first node");
            System.out.println("Press 7 to delete last node");
            System.out.println("Press 8 to display List");
            System.out.println("Press 9 to reverse List");
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
                case 9:list.reverse();
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