import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Traversal {
    static class Graph
    {
        int numNodes;
        List<List<Integer>> adjList;
        boolean visted[];
        Graph(int numNodes)
        {
            this.numNodes=numNodes;
            adjList=new ArrayList<>(numNodes);
            for(int i=0;i<numNodes;i++)
            adjList.add(new ArrayList<>());
            visted=new boolean[numNodes];
        }
        void AddEdge(int u,int v)
        {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        void bfs(int source)
        {
            Queue<Integer> q=new LinkedList<>();
            q.add(source);
            System.out.print(source+" ");
            visted[source]=true;
            while(!q.isEmpty())
            {
                source=q.peek();
                q.remove();
                for(Integer i:adjList.get(source))
                {
                    if(!visted[i])
                    {
                        q.add(i);
                        System.out.print(i+" ");
                        visted[i]=true;
                    }
                }
            }
            Arrays.fill(visted,false);
        }
        void dfsRecursive(int src)
        {
            System.out.print(src+" ");
            visted[src]=true;
            for(Integer i:adjList.get(src))
            {
                if(!visted[i])
                dfsRecursive(i);
            }
        }
        void MarkUnvisited () {
            Arrays.fill(visted, false);
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.AddEdge(0,1);
        g.AddEdge(0,2);
        g.AddEdge(1,3);
        g.AddEdge(1,4);
        g.AddEdge(2,3);
        g.AddEdge(3,5);
        g.AddEdge(4,6);
        g.AddEdge(5,6);

        System.out.println("\nBFS Graph Traversal ");
        System.out.print("\nSource Node (0): "); g.bfs(0);
        System.out.print("\nSource Node (3): "); g.bfs(3);

        System.out.println("\n\nDfs recursive ");
        System.out.print("\nSource Node (0): "); g.dfsRecursive(0);
        g.MarkUnvisited();
        System.out.print("\nSource Node (3): "); g.dfsRecursive(3);

        g.MarkUnvisited();

        
    }
}
