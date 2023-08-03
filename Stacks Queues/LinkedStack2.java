import java.util.*;
class LinkedStack2<E> implements stack<E>
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
        void setNext(Node<E> next)
        {
            this.next=next;
        }
        Node<E> getNext()
        {
            return this.next;
        }
    }
    Node<E> top=null;
    int size=0;
    public int size()
    {
        return this.size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void push(E element)
    {
        top=new Node<E>(element,top);
        size++;
    }
    public E top()
    {
        return top.getElement();
    }
    public E pop()
    {
        if(isEmpty())
        return null;
        else
        {
            E deleted=top.getElement();
            top=top.getNext();
            size--;
            return deleted;
        }
    }
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else
        {
            Node<E> temp=top;
            while(temp!=null)
            {
                System.out.println(temp.getElement());
                temp=temp.getNext();
            }
        }
    }
    static <E> void reverse(E[] arr)
    {
        LinkedStack<E> buffer=new LinkedStack<E>();
        for(int i=0;i<arr.length;i++)
        buffer.push(arr[i]);
        for(int i=0;i<arr.length;i++)
        arr[i]=buffer.pop();
    }
    
    public static void main(String args[])
    {
        LinkedStack2<Integer> LS=new LinkedStack2<>();
        Integer element;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to retrieve size of stack");
            System.out.println("Press 2 to push element on stack");
            System.out.println("Press 3 to peek top of stack");
            System.out.println("Press 4 to pop");
            System.out.println("Press 5 to display");
            System.out.println("Press 6 to reverse an array");
            choice=in.nextInt();
            switch(choice)
            {
                case 1:System.out.println(LS.size());
                break;
                case 2:System.out.println("Enter element to be pushed onto the stack");
                element=in.nextInt();
                LS.push(element);
                break;
                case 3:System.out.println(LS.top());
                break;
                case 4:System.out.println(LS.pop()+" removed from the stack");
                break;
                case 5:LS.display();
                break;
                case 6:Integer[] intArr={1,2,3,4,5};
                System.out.println("Original array: "+Arrays.toString(intArr));
                reverse(intArr);
                System.out.println("Reversed array: "+Arrays.toString(intArr));
                String[] strArr={"alok","manish","dev","kartik"};
                System.out.println("Original array: "+Arrays.toString(strArr));
                reverse(strArr);
                System.out.println("Reversed array: "+Arrays.toString(strArr));
                default:System.out.println("Wrong choice");
                break;
            }
            System.out.println("To continue press 1");
            element=in.nextInt();
        }
        while(element==1);
    }
}