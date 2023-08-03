import java.util.*;
class LinkedStack<E> implements stack<E>
{
    SinglyLinkedList<E> list=new SinglyLinkedList<>();
    public LinkedStack(){}
    public int size()
    {
        return list.size();
    }
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    public void push(E element)
    {
        list.addFirst(element);
    }
    public E top()
    {
        return list.first();
    }
    public E pop()
    {
        if(isEmpty())return null;
        E deleted=list.removeFirst();
        return deleted;
    }
    public static void main(String args[])
    {
        LinkedStack<Integer> LS=new LinkedStack<>();
        Integer element;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to retrieve size of stack");
            System.out.println("Press 2 to push element on stack");
            System.out.println("Press 3 to peek top of stack");
            System.out.println("Press 4 to pop");
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
                default:System.out.println("Wrong choice");
                break;
            }
            System.out.println("To continue press 1");
            element=in.nextInt();
        }
        while(element==1);
    }
}