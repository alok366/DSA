import java.util.Arrays;
import java.util.Scanner;

public class Warshall {
    static void shortestPath(int adj[][],int n)
    {
        int path[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(adj[i][j]==0)
                path[i][j]=9999;
                else
                path[i][j]=adj[i][j];
            }
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(path[i][j]<=path[i][k]+path[k][j])
                    path[i][j]=path[i][j];
                    else
                    path[i][j]=path[i][k]+path[k][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(path));
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n;
        System.out.println("Enter size of matrix");
        n=in.nextInt();
        int adj[][]=new int[n][n];
        System.out.println("Enter data for matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j]=in.nextInt();
            }
        }
        System.out.println("Adjacency matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(adj[i][j]+"\t");
            System.out.println();
        }
        shortestPath(adj,n);
    }
}
