interface deque<E>
{
    int size();
    boolean isEmpty();
    E first();
    E last();
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();
}