import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;

class AdjacencyList2
{
    static class Node
    {
        String vertex;
        Node(String vertex)
        {
            this.vertex=vertex;
        }
        public String toString()
        {
            return vertex;
        }
    }
    Map<Node,List<Node>> adjList=new HashMap<>();
    void addAdjacentNode(Node node,List<Node> adjNodes)
    {
        adjList.put(node,adjNodes);
    }
    void print(Node node)
    {
        System.out.print(node);
        List<Node> adjNodes=adjList.get(node);
        for(Node n:adjNodes)
        System.out.print(" -> "+n);
        System.out.println();
    }
    public static void main(String[] args) {
        Node n1 = new Node("Alfa");
        Node n2 = new Node("Cod");
        Node n3 = new Node("Pi");
        Node n4 = new Node("Ram");
        Node n5 = new Node("Yo");
        List<Node> n1List=Arrays.asList(n2,n3,n4);
        List<Node> n2List = Arrays.asList(n1, n4);
        List<Node> n3List = Arrays.asList(n1, n4, n5);
        List<Node> n4List = Arrays.asList(n1, n2, n3, n5);
        List<Node> n5List = Arrays.asList(n3, n4);
        AdjacencyList2 g=new AdjacencyList2();
        g.addAdjacentNode(n1,n1List);
        g.addAdjacentNode(n2, n2List);
        g.addAdjacentNode(n3,n3List);
        g.addAdjacentNode(n4, n4List);
        g.addAdjacentNode(n5,n5List);
        g.print(n1);
        g.print(n2);
    }
}

