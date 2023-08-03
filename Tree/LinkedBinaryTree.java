import java.util.*;

public class LinkedBinaryTree<E extends Comparable<E>> {
    LinkedBinaryTree()
    {}
    Node<E> insert(Node<E> root,E element)
    {
        if(root==null)
        {
            root=new Node<E>(element, null, null);
            System.out.println(element+" inserted successfully");
            return root;
        }
        else
        {
            if(element.compareTo(root.getElement())<0)
            root.setLeft(insert(root.getLeft(), element));
            else if(element.compareTo(root.getElement())>0)
            root.setRight(insert(root.getRight(), element));
            else
            System.out.println("Duplicate not allowed");
        }
        return root;
    }
    void search(Node<E> root,E element)
    {
        if(root==null)
        System.out.println(element+" not found in tree");
        else if(root.getElement()==element)
        System.out.println(root.getElement()+" found in tree");
        else
        {
            if(element.compareTo(root.getElement())<0)
            search(root.getLeft(), element);
            else 
            search(root.getRight(), element);
        }
    }
    Node<E> findLargest(Node<E> root)
    {
        if(root.getRight()==null||root==null)
        return root;
        else
        return findLargest(root.getRight());
    }
    Node<E> findSmallest(Node<E> root)
    {
        if(root.getLeft()==null||root==null)
        return root;
        else 
        return findSmallest(root.getLeft());
    }
    Node<E> deleteNode(Node<E> root,E element)
    {
        if(root==null)
        return null;
        if(element.compareTo(root.getElement())<0)
        root.left=deleteNode(root.getLeft(), element);
        else if(element.compareTo(root.getElement())>0)
        root.right=deleteNode(root.getRight(), element);
        else
        {
            if(root.getLeft()==null)return root.getRight();
            else if(root.getRight()==null)return root.getLeft();
            root.element=findLargest(root.getLeft()).getElement();
            root.left=deleteNode(root.getLeft(), root.element);
        }
    return root;
    }
    int height(Node<E> root)
    {
        if(root==null)
        return 0;
        else
        {
            int lheight=height(root.getLeft());
            int rheight=height(root.getRight());
            if(lheight<rheight)
            return lheight+1;
            else
            return rheight+1;
        }
    }
    int numNodes(Node<E> root)
    {
        if(root==null)
        return 0;
        else
        return numNodes(root.getLeft())+numNodes(root.getRight())+1;
    }
    int numInternal(Node<E> root)
    {
        if(root==null)
        return 0;
        else if(root.getLeft()==null&&root.getRight()==null)
        return 0;
        else
        return numInternal(root.getLeft())+numInternal(root.getRight())+1;
    }
    int numExternal(Node<E> root)
    {
        if(root==null)
        return 0;
        else if(root.getLeft()==null&&root.getRight()==null)
        return 1;
        else
        return numExternal(root.getLeft())+numExternal(root.getRight())+1;
    }
    void mirror(Node<E> root)
    {
        if(root!=null)
        {
            mirror(root.getLeft());
            mirror(root.getRight());
            Node<E> temp=root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
    }
    void deleteTree(Node<E> root)
    {
        if(root!=null)
        {
            deleteTree(root.getLeft());
            deleteTree(root.getRight());
            root=null;
        }
    }
    void preorder(Node<E> root)
    {
        if(root!=null)
        {
            System.out.println(root.getElement());
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }
    void postorder(Node<E> root)
    {
        if(root!=null)
        {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.println(root.getElement());
        }
    }
    void inorder(Node<E> root)
    {
        if(root!=null)
        {
            inorder(root.getLeft());
            System.out.println(root.getElement());
            inorder(root.getRight());
        }
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Integer element;
        Node<Integer> root=null;
        Node<Integer> temp;
        LinkedBinaryTree<Integer> tree=new LinkedBinaryTree<>();
        do
        {
            System.out.println("Press 1 to insert a node ");
            System.out.println("Press 2 to search a node ");
            System.out.println("Press 3 to find largest node ");
            System.out.println("Press 4 to find smallest node");
            System.out.println("Press 5 to delete a node");
            System.out.println("Press 6 to determine height of tree");
            System.out.println("Press 7 to determine number of nodes");
            System.out.println("Press 8 to determine total internal nodes");
            System.out.println("Press 9 to determine total external nodes");
            System.out.println("Press 10 to create mirror image of tree");
            System.out.println("Press 11 to delete the tree");
            System.out.println("Press 12 for pre order traversal");
            System.out.println("Press 13 for in order traversal");
            System.out.println("Press 14 for post order traversal");
            int choice=in.nextInt();
            switch(choice)
            {
                case 1:System.out.println("Enter the element to insert");
                element=in.nextInt();
                root=tree.insert(root,element);
                break;
                case 2:System.out.println("Enter value to search");
                element=in.nextInt();
                tree.search(root, element);
                break;
                case 3:temp=tree.findLargest(root);
                if(temp!=null)
                System.out.println(temp.getElement());
                break;
                case 4:temp=tree.findSmallest(root);
                if(temp!=null)
                System.out.println(temp.getElement());
                break;
                case 5:System.out.println("Enter the element to be deleted");
                element=in.nextInt();
                temp=tree.deleteNode(root,element);
                if(temp==null)
                System.out.println(element+" not found in tree");
                else
                System.out.println(element+" deleted from tree");
                break;
                case 6:
                System.out.println("height of tree is: "+tree.height(root));
                break;
                case 7:System.out.println("Number of nodes in tree: "+tree.numNodes(root));
                break;
                case 8:System.out.println("Number of internal nodes in tree: "+tree.numInternal(root));
                break;
                case 9:System.out.println("Number of external nodes: "+tree.numExternal(root));
                break;
                case 10:tree.mirror(root);
                break;
                case 11:tree.deleteTree(root);;
                break;
                case 12:tree.preorder(root);
                break;
                case 13:tree.inorder(root);
                break;
                case 14:tree.postorder(root);
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
