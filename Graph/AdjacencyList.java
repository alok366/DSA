import java.util.ArrayList;
import java.util.List;

class Graph
{
    int numNodes;
    List<List<Integer>> adjList;
    Graph(int numNodes)
    {
        this.numNodes=numNodes;
        adjList=new ArrayList<>(numNodes);
        for(int i=0;i<numNodes;i++)
        adjList.add(new ArrayList<>());
    }
    void addEdge(int u,int v)
    {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    void print(int vertex)
    {
        System.out.println("Node adjacent to vertex "+vertex+" are:");
        for(Integer i:adjList.get(vertex))
        System.out.print(i+" ");
        System.out.println();
    }
}
class AdjacencyList
{
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 6);
        g.addEdge(4, 5);
        for(int i=0;i<7;i++)
        g.print(i);
    }
}