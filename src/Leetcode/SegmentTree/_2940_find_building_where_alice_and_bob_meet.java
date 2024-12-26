package Leetcode.SegmentTree;

import java.util.Arrays;

public class _2940_find_building_where_alice_and_bob_meet {
    public static void main(String[] args) {
        int[] heights = {2,1,3,4,5};
        int[][] array = {
                {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4},
                {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
                {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4},
                {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}
        };

        System.out.println(Arrays.toString(leftmostBuildingQueries(heights, array)));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        SegmentTree tree = new SegmentTree(heights);

        for (int i = 0; i < n; i++) {
            // sorting the ith query so that x will always be <= y
            Arrays.sort(queries[i]);
            int x = queries[i][0];
            int y = queries[i][1];

            // if both alice and bob are at same building then that is the answer
            // or if height of y is bigger than height of x, alice(x) can jump from x to y and that will be our answer
            if (x == y || heights[x] < heights[y]) {
                ans[i] = y;
            }
            // otherwise we have to find the left most index which has value greater than max(height[x], height[y])
            else {
                int max = Math.max(heights[x], heights[y]);
                int queryResult = tree.query(y + 1, heights.length - 1, max);
                // if no index is found then add -1
                ans[i] = queryResult == (int)1e9 ? -1 : queryResult;
            }
        }
        return ans;
    }
}

// this is segment tree code, which gives the left most index of an element which is lesser than a given value, inside a range
class SegmentTree {
    private final int[] arr;

    public class Node {
        int value; // index of the maximum height in this interval
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public Node root;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.value = start;
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // Assign the index with the greater height
        if (arr[node.left.value] >= arr[node.right.value]) {
            node.value = node.left.value;
        } else {
            node.value = node.right.value;
        }
        return node;
    }

    public int query(int qsi, int qei, int element) {
        return query(this.root, qsi, qei, element);
    }

    private int query(Node node, int qsi, int qei, int element) {
        // Node is completely inside query range
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            int ans = (int)1e9;
            if (arr[node.value] > element) {
                ans = node.value;
                // take node.value as a potential answer and again check in the left and right, if a better answer is found
                if(node.left != null ) ans = Math.min(ans, query(node.left, qsi, qei, element));
                if(node.right != null) ans = Math.min(ans, query(node.right, qsi, qei, element));
            }
            return ans;
        }

        // Node is completely outside query range
        if (node.startInterval > qei || node.endInterval < qsi) {
            return (int)1e9;
        }

        // Node is partially inside query range
        int leftResult = query(node.left, qsi, qei, element);
        int rightResult = query(node.right, qsi, qei, element);

        if (leftResult == (int)1e9) return rightResult;
        if (rightResult == (int)1e9) return leftResult;

        // take the min index
        return Math.min(leftResult, rightResult);
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.value + " => ";
        } else{
            System.out.print("No left child exist => ");
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.value + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.value;
        } else {
            str = str + "No right child";
        }
        System.out.println(str + '\n');

        // call recursion
        if (node.left != null) {
            display(node.left);
        }
        if(node.right != null) {
            display(node.right);
        }
    }
}
