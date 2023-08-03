public class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node(E element,Node<E> left,Node<E> right)
        {
            this.element=element;
            this.left=left;
            this.right=right;
        }
        E getElement()
        {
            return this.element;
        }
        Node<E> getLeft()
        {
            return left;
        }
        Node<E> getRight()
        {
            return right;
        }
        void setElement(E element)
        {
            this.element=element;
        }
        void setLeft(Node<E> left)
        {
            this.left=left;
        }
        void setRight(Node<E> right)
        {
            this.right=right;
        }
}
