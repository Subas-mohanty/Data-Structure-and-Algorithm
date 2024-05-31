package Graph_by_Striver;

import java.util.ArrayList;
import java.util.Stack;

public class _06_DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] visit = new boolean[V+1];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visit[0] = true;

        while(!stack.isEmpty()){
            int removed = stack.pop();
            ans.add(removed);

            // adj.get(removed) is a list which contains all the edges connected to the removed node, so we can iterate then with an int as the elements of the list is integers
            // we have to reverse the list or we have to do something that the list elements pushed into the stack in reverse order
            for(int num : adj.get(removed)){
                if(!visit[num]){
                    visit[num] = true;
                    stack.push(num);
                }
            }
        }
        return ans;
    }

    // SC : O(3N) , ans list, visit array and the recursion stack space
    // TC : O(n+2E) , same as BFS
    public ArrayList<Integer> dfsOfGraph2(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] visit = new boolean[V+1];

        return helper(adj, 0, ans, visit);
    }
    public ArrayList<Integer> helper(ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> list, boolean [] visit) {
        visit[node] = true;
        list.add(node);

        for(int x : adj.get(node)){
            if(!visit[x]){
                helper(adj, x, list, visit);
            }
        }
        return list;
    }
}
