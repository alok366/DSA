import java.util.*;
class SinglyLinkedList<E>
{
    private static class Node<E>
    {
        E element;
        private Node<E> next;
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
    private Node<E> head=null;
    private Node<E> tail=null;
    int size=0;
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
        if(isEmpty())return null;
        return head.getElement();
    }
    E last()
    {
        if(isEmpty())return null;
        return tail.getElement();
    }
    void addFirst(E element)
    {
        head=new Node<>(element,head);
        if(size==0)
        tail=head;
        size++;
    }
    void addLast(E element)
    {
        Node<E> newest=new Node<E>(element,null);
        if(isEmpty())
        head=newest;
        else
        tail.setNext(newest);
        tail=newest;
        size++;
    }
    E removeFirst()
    {
        if(isEmpty())
        return null;
        E deleted=head.getElement();
        head=head.getNext();
        size--;
        if(size==0)
        tail=null;
        return deleted;
    }
    void display()
    {
        if(isEmpty())
        System.out.println("List is Empty");
        else
        {
            Node<E> temp=head;
            while(temp!=null)
            {
                System.out.println(temp.getElement());
                temp=temp.getNext();
            }
        }
    }
    public boolean equals(Object o)
    {
        if(o==null)return false;
        if(getClass()!=o.getClass())return false;
        SinglyLinkedList other=(SinglyLinkedList)o;
        if(other.size!=size)return false;
        Node walkA=head;
        Node walkB=other.head;
        while(walkA!=null)
        {
            if(!walkA.getElement().equals(walkB.getElement()))return false;
            walkA=walkA.getNext();
            walkB=walkB.getNext();
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Integer element;
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();
        do
        {
            System.out.println("Press 1 to get size of List");
            System.out.println("Press 2 to get first node of List");
            System.out.println("Press 3 to get last node of List");
            System.out.println("Press 4 to add node at start of List");
            System.out.println("Press 5 to add node at last of List");
            System.out.println("Press 6 to delete first node");
            System.out.println("Press 7 to display List");
            System.out.println("Press 8 for equivalence check");
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
                case 8:SinglyLinkedList<Integer> list2=list;
                System.out.println("List equals List 2: "+list2.equals(list));
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