package Leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/build-a-matrix-with-conditions/?envType=daily-question&envId=2024-07-21
//https://www.youtube.com/watch?v=kiEytJvaz8w
public class _2392_build_a_matrix_with_given_conditions {
    // TC : O(V + E + k^2) --> for bfs + building the matrix
    // SC : O(k + k * E) --> queue + indegree + matrix
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int [] rowTopoSort = helper(rowConditions, k);
        if(rowTopoSort.length == 0) return new int[0][0];
        int [] colTopoSort = helper(colConditions, k);
        if(colTopoSort.length == 0) return new int[0][0];
        int [][] ansMatrix = new int[k][k];

        for(int i = 0; i < k ; i++){
            for(int j = 0; j < k; j++){
                if(rowTopoSort[i] == colTopoSort[j]){
                    ansMatrix[i][j] = colTopoSort[j];
                }
            }
        }
        return ansMatrix;
    }

    public int[] helper(int [][] edges, int k){
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <= k; i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        int [] inDegree = new int[k+1];
        for(int i = 1; i < adjList.size(); i++){
            for(int node : adjList.get(i)) inDegree[node]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            if(inDegree[i] == 0 ) q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int neighbours : adjList.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0) q.offer(neighbours);
            }
        }
        if(res.size() != k) return new int[0];

        int [] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = res.get(i);
        }

        return ans;
    }






    // using list, it is giving wrong answer for a larger test case

    public int [][] buildMatrix2 (int k, int[][] rowConditions, int[][] colConditions){
        List<Integer> rowTopoSort = helper2(rowConditions, k);
        if(rowTopoSort.size() == 0) return new int[0][0];
        List<Integer> colTopoSort = helper2(colConditions, k);
        if(colTopoSort.size() == 0) return new int[0][0];
        int [][] ansMatrix = new int[k][k];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(rowTopoSort.get(i) == colTopoSort.get(j)){
                    ansMatrix[i][j] = colTopoSort.get(j);
                }
            }
        }
        return ansMatrix;
    }
    public List<Integer> helper2(int [][] edges, int k){
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <= k; i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        int [] inDegree = new int[k+1];
        for(int i = 1; i < adjList.size(); i++){
            for(int node : adjList.get(i)) inDegree[node]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            if(inDegree[i] == 0 ) q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int neighbours : adjList.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0) q.offer(neighbours);
            }
        }
        if(res.size() != k) new ArrayList<>();
        return res;
    }
}
