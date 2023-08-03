import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdjacencyList3 {
    static class Node {
        String city;

        Node(String city) {
            this.city = city;
        }

        public String toString() {
            return city;
        }
    }

    Map<Node, List<Node>> adjList = new HashMap<>();

    void addAdjacentNode(Node vertex, List<Node> adjNodes) {
        adjList.put(vertex, adjNodes);
    }

    void print() {
        for (Map.Entry<Node, List<Node>> m : adjList.entrySet()) {
            Node key = m.getKey();
            System.out.print(key);
            List<Node> adjNodes = m.getValue();
            for (Node n : adjNodes)
                System.out.print(" -> " + n);
            System.out.println();
        }
    }

    void delete(Node vertex) {
        for (List<Node> adjNodes : adjList.values()) {
            Iterator<Node> iterator = adjNodes.iterator();
            while (iterator.hasNext()) {
                Node adjNode = iterator.next();
                if (adjNode.equals(vertex)) {
                    iterator.remove();
                }
            }
        }
        adjList.remove(vertex);
        System.out.println(vertex + " removed");
    }

    public static void main(String[] args) {
        Node n1 = new Node("city1");
        Node n2 = new Node("city2");
        Node n3 = new Node("city3");
        Node n4 = new Node("city4");
        Node n5 = new Node("city5");

        List<Node> n1List = new ArrayList<>(Arrays.asList(n2, n4));
        List<Node> n2List = new ArrayList<>(Arrays.asList(n1, n3, n4));
        List<Node> n3List = new ArrayList<>(Arrays.asList(n2, n5));
        List<Node> n4List = new ArrayList<>(Arrays.asList(n1, n2, n5));
        List<Node> n5List = new ArrayList<>(Arrays.asList(n3, n4));

        AdjacencyList3 g = new AdjacencyList3();
        g.addAdjacentNode(n1, n1List);
        g.addAdjacentNode(n2, n2List);
        g.addAdjacentNode(n3, n3List);
        g.addAdjacentNode(n4, n4List);
        g.addAdjacentNode(n5, n5List);

        g.print();
        g.delete(n1);
        g.print();
    }
}
