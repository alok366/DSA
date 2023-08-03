public class SinglyLinkedList<E>
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
        void setNext(Node<E> next)
        {
            this.next=next;
        }
        Node<E> getNext()
        {
            return this.next;
        }
        E getElement()
        {
            return this.element;
        }
    }
    int size=0;
    Node<E> head=null;
    Node<E> tail=null;
    public int size()
    {
        return this.size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public E first()
    {
        if(isEmpty())return null;
        return head.getElement();
    }
    public E last()
    {
        if(isEmpty())return null;
        return tail.getElement();
    }
    public void addFirst(E element)
    {
        head=new Node<E>(element,head);
        if(size==0)
        tail=head;
        size++;
    }
    public void addLast(E element)
    {
        Node<E> newest=new Node<E>(element,null);
        if(size==0)
        head=newest;
        else
        tail.setNext(newest);
        tail=newest;
        size++;
    }
    E removeFirst()
    {
        if(isEmpty())return null;
        E deleted=head.getElement();
        head=head.getNext();
        size--;
        if(size==0)
        tail=null;
        return deleted;
    }
}