package Graph_by_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Lecture_practice_problems_kunal_kushwaha._41_OOPS_05_Interface_Annotations.A;
import Lecture_practice_problems_kunal_kushwaha._49_BinaryTree_01.BinaryTree.Node;

public class _05_BFS {
    // bfs of tree
    // TC : O(v + e)
    public static boolean search(Node node, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
           int size = q.size();
            for (int i = 0; i < size; i++) {
               Node removed = q.poll();
               if(removed.value == target) return true;
               if(removed.left != null) q.offer(node.left);
               if(removed.right != null) q.offer(node.right);
            }
        }
        return false;
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list, int v){
       boolean [] visit = new boolean[v+1];
       ArrayList<Integer> ans = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       q.offer(0);
       visit[0] = true;
       while(!q.isEmpty()){
           int removed = q.poll();
           ans.add(removed);

           for(int x : list.get(removed)){
               if(!visit[x]){
                   visit[x] = true;
                   q.add(x);
               }
           }
       }
       return ans;
    }
}
