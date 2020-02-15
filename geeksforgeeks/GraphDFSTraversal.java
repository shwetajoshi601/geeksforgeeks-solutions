// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            Traversal.bfs(0, list, vis, nov);
            System.out.println();
        }
    }
}




// } Driver Code Ends
//User function Template for Java

/*
*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex 
*/
class Traversal
{
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov)
    {
       // add your code here
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(s);
       
       while(!queue.isEmpty()) {
           s = queue.poll();
           System.out.print(s + " ");
           vis[s] = true;
           Iterator<Integer> it = list.get(s).iterator();

           while(it.hasNext()) {
               int v = it.next();

               if(!vis[v]) {
                   vis[v] = true;
                   queue.add(v);
               }
           }
       }
    }
}