package Graph_by_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://bit.ly/3C9N6ZU
public class _26_alien_dictionary {
    // TC : O(n^2 + V + E)


    // in this problem we are converting a string graph, but how are you doing it ?
    // we are doing that by assigning the character to numbers, i.e, a = 0, b = 1, c = 2 and so on
    // then again when are retrieving the values we are converting these integer values to character again
    public String findOrder(String [] dict, int N, int K){
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int [] arr = compareString(s1, s2); // this function is O(n)
            if(arr != null){
                int first = arr[0];
                int second = arr[1];
                adjList.get(first).add(second);
            }
        }
        int [] ans = topoSort(K, adjList);
        StringBuilder sb = new StringBuilder();
        for(int a : ans){
            sb.append((char) (a + 'a'));
        }
        return sb.toString();
    }

    // comparing both string and checking which character will come before whom
    public int [] compareString(String s1, String s2){
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            // if we reach at two different character then return them as an int array
            if(s1.charAt(i) != s2.charAt(j)){
                return new int[]{s1.charAt(i) - 'a', s2.charAt(j) - 'a'};
            }
            i++;
            j++;
        }
        return null;
    }


    // simple toposort function
    // TC : O(V+E)
    public static int[] topoSort(int V, List<List<Integer>> adj) {
        // find incoming edges for every node
        int [] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int node : adj.get(i)) inDegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // adding nodes to queue which indegree is 0
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();

        // kahn's algorithm
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            // visit all neighbours
            for(int neighbours : adj.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0) q.offer(neighbours);
            }
        }

        // converting list to array
        int [] ans = new int[V];
        for(int i = 0; i < V; i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}
