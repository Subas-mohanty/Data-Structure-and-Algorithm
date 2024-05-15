package Graph_by_Striver;

import java.util.ArrayList;

public class _03_IntroT0Graph {
  public static void main(String[] args) {
    // matrix method
    int n = 5; // no of vertices
    int e = 6; // no of edges
    /*
    1--3--|
    |  |  5
    2--4--|
    edges
    [1,2], [1,3], [2,1], [2,4], [3,1], [3,4], [3,5], [4,2], [4,3], [4,5], [5,3], [5,4]
    */
    int [][] matrix = new int[n+1][n+1];
    // this is for unweighted undirected graph
    matrix[1][2] = 1;
    matrix[1][3] = 1;
    matrix[2][1] = 1;
    matrix[2][4] = 1;
    matrix[3][1] = 1;
    matrix[3][4] = 1;
    matrix[3][5] = 1;
    matrix[4][2] = 1;
    matrix[4][3] = 1;
    matrix[4][5] = 1;
    matrix[5][3] = 1;
    // matrix[5][4] = 1;

    // for weighted graph, instead of storing 1 we will store the weight. for eg-
    matrix[5][4] = 5;
    
    for(int i = 0; i <matrix.length; i++){
      for(int j=0; j< matrix[0].length; j++){
        if(matrix[i][j] != 0){
          System.out.print("[" + i + "," + j + "], ");
        }
      }
    }
    System.out.println();

    // ArrayList method
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // created or initializes n+1 number of arraylist i.e, equal to number of nodes of vertices
    for(int i=0; i<=n; i++){
      graph.add(new ArrayList<>());
    }
    
    // making the graph
    // [1,2], [1,3], [2,1], [2,4], [3,1], [3,4], [3,5], [4,2], [4,3], [4,5], [5,3], [5,4]
    // getting the first node and adding 2 in that arrayList , i,e 1 and 2 are connected
    graph.get(1).add(2);
    graph.get(1).add(3);
    graph.get(2).add(1);
    graph.get(2).add(4);
    graph.get(3).add(1);
    graph.get(3).add(4);
    graph.get(3).add(5);
    graph.get(4).add(2);
    graph.get(4).add(3);
    graph.get(4).add(5);
    graph.get(5).add(3);
    graph.get(5).add(4);
    // do for the rest

    for(int i=0; i<=n; i++){
      for(int j=0; j<graph.get(i).size(); j++){
        // if(graph.get(i) != null) // no need of this check as we have all nodes and for 0th node the j one is making sure that it doesn't run for i=0
        System.out.print("[" + i + ",");
        System.out.print(graph.get(i).get(j) + "], ");
      }
      System.out.println();
    }
  }
}
