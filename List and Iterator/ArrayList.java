import java.util.*;
class ArrayList<E> implements List<E>
{
    E[] data;
    static int CAP=10;
    ArrayList()
    {
        this(CAP);
    }
    ArrayList(int capacity)
    {
        data=(E[])new Object[capacity];
    }
    int size=0;
    private class ArrayIterator implements Iterator<E>
    {
        private int j=0;
        boolean removable=false;
        public boolean hasNext()
        {
            return j<size;
        }
        public E next()throws NoSuchElementException
        {
            if(j==size)throw new NoSuchElementException("No next element");
            removable=true;
            return data[j++];
        }
        public void remove()throws IllegalStateException
        {
            if(!removable)throw new IllegalStateException("Nothing to remove");
            ArrayList.this.remove(j-1);
            j--;
            removable=false;
        }
        public Iterator<E> iterator()
        {
            return new ArrayIterator();
        }
    }
    void resize(int capacity)
    {
        E[] temp=(E[])new Object[capacity];
        for(int i=0;i<data.length;i++)
        temp[i]=data[i];
        data=temp;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    void checkIndex(int i,int n)throws IndexOutOfBoundsException
    {
        if(i<0||i>=n)throw new IndexOutOfBoundsException("Invalid index");
    }
    public E get(int i)
    {
        checkIndex(i,size);
        return data[i];
    }
    public E set(int i,E element)
    {
        checkIndex(i,size);
        E temp=data[i];
        data[i]=element;
        return temp;
    }
    public void add(int i,E element)
    {
        checkIndex(i,size+1);
        if(i==data.length)
        resize(2*data.length);
        else
        {
            for(int k=i;k<size-1;k++)
            {
                data[k+1]=data[k];
            }
            data[i]=element;
            size++;
        }
    }
    public E remove(int i)
    {
        checkIndex(i,size);
        E temp=data[i];
        for(int k=i;k<size-1;k++)
        {
            data[k]=data[k+1];
        }
        data[size-1]=null;
        size--;
        return temp;
    }
    void display()
    {
        ArrayIterator ai=new ArrayIterator();
        Iterator<E> iter=ai.iterator();
        while(iter.hasNext())
        System.out.println(iter.next());
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Integer element;
        Integer index;
        ArrayList<Integer> list=new ArrayList<>();
        do
        {
            System.out.println("Press 1 to get size of List");
            System.out.println("Press 2 to get element at a index");
            System.out.println("Press 3 to set element at a index");
            System.out.println("Press 4 to add element at a index");
            System.out.println("Press 5 to remove element at a index");
            System.out.println("Press 6 to display List");
            int choice=in.nextInt();
            switch(choice)
            {
                case 1:element=list.size();
                System.out.println("Size of list "+element);
                break;
                case 2:System.out.println("Enter index ");
                index=in.nextInt();
                System.out.println("Element at index "+index+": "+list.get(index));
                break;
                case 3:System.out.println("Enter index");
                index=in.nextInt();
                System.out.println("Enter element");
                element=in.nextInt();
                System.out.println("Element replaced "+list.set(index,element));
                break;
                case 4:System.out.println("Enter the element");
                element=in.nextInt();
                System.out.println("Enter index");
                index=in.nextInt();
                list.add(index,element);
                break;
                case 5:System.out.println("Enter index ");
                index=in.nextInt();
                System.out.println(list.remove(index)+" is removed from list");
                break;
                case 6:list.display();
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