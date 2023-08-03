import java.util.*;
class ArrayStack<E> implements stack<E>
{
    static final int CAPACITY=100;
    private int t=-1;
    E[] data;
    ArrayStack()
    {
        this(CAPACITY);
    }
    ArrayStack(int capacity)
    {
        data=(E[])new Object[capacity];
    }
    public int size()
    {
        return t+1;
    }
    public void push(E e)throws IllegalStateException
    {
        if(size()==data.length)throw new IllegalStateException("Stack is Full");
        data[++t]=e;
    }
    public boolean isEmpty()
    {
        return t==-1;
    }
    public E top()
    {
        if(isEmpty())return null;
        return data[t];
    }
    public E pop()
    {
        if(isEmpty())return null;
        E answer=data[t];
        data[t]=null;//dereference to help garbage collection
        t--;
        return answer;
    }
    public void display()
    {
        E[] disp=Arrays.copyOf(data,t);
        System.out.println(Arrays.toString(disp));
    }
    static <E> void reverse(E[] arr)
    {
        ArrayStack<E> buffer=new ArrayStack<>();
        for(int i=0;i<arr.length;i++)
        buffer.push(arr[i]);
        for(int i=0;i<arr.length;i++)
        arr[i]=buffer.pop();
    }
    public static void main(String args[])
    {
        ArrayStack<Integer> AS=new ArrayStack<>();
        Integer element;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to retrieve size of stack");
            System.out.println("Press 2 to push element on stack");
            System.out.println("Press 3 to peek top of stack");
            System.out.println("Press 4 to pop");
            System.out.println("Press 5 to display stack");
            System.out.println("Press 6 to reverse array");
            choice=in.nextInt();
            switch(choice)
            {
                case 1:System.out.println(AS.size());
                break;
                case 2:System.out.println("Enter element to be pushed onto the stack");
                element=in.nextInt();
                AS.push(element);
                break;
                case 3:System.out.println(AS.top());
                break;
                case 4:System.out.println(AS.pop()+" removed from the stack");
                break;
                case 5:AS.display();
                break;
                case 6:Integer[] intArr={1,2,3,4,5};
                System.out.println("Original array: "+Arrays.toString(intArr));
                reverse(intArr);
                System.out.println("Reversed array: "+Arrays.toString(intArr));
                String[] strArr={"alok","manish","dev","kartik"};
                System.out.println("Original array: "+Arrays.toString(strArr));
                reverse(strArr);
                System.out.println("Reversed array: "+Arrays.toString(strArr));
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