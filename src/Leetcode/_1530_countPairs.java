package Leetcode;

public class _1530_countPairs {
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }
    int res = 0;
    public int [] dfs(TreeNode root, int dist){
        int [] leafDist = new int[11];
        if(root == null) return leafDist;
        if(root.left == null && root.right == null){
            leafDist[1] = 1;
            return leafDist;
        }
        int [] left = dfs(root.left, dist);
        int [] right = dfs(root.right, dist);

        for(int i = 1; i < dist; i++){
            for(int j = 1; j < dist; j++){
                if(i + j <= dist) res += left[i] * right[j];
            }
        }
        for(int i = 1; i < 11; i++){
            leafDist[i] = left[i-1] + right[i-1];
        }
        return leafDist;
    }
}
