package Graph_by_Striver;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    class Pair{
        int from;
        int weight;
        Pair(int from, int weight){
           this.from = from;
           this.weight = weight;
        }

        @Override
        public String toString() {
           return "(" + from + ", " + weight + ")";
        }
    }
    int [][] adjMatrix;
    List<List<Integer>> adjList;
    List<List<Pair>> adjWeightedList;
    Graph(int nodes){
        this.adjMatrix = new int[nodes][nodes];
        this.adjList = new ArrayList<>();
        this.adjWeightedList = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            this.adjList.add(new ArrayList<>());
            this.adjWeightedList.add(new ArrayList<>());
        }
    }
    public void addEdgesInList(int [][] edges, boolean isDirected){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (isDirected){
                adjList.get(u).add(v);
            }
            else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    public void addEdgesWithWeightInList(int [][] edges, boolean isDirected){
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            Pair pair1 = new Pair(to, w);
            Pair pair2 = new Pair(from, w);
            if (isDirected){
                adjWeightedList.get(from).add(pair1);
            }
            else{
                adjWeightedList.get(from).add(pair1);
                adjWeightedList.get(to).add(pair2);
            }
        }
    }
    public void addEdgesInMatrix(int [][] edges, boolean isDirected){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (isDirected){
               adjMatrix[u][v] = 1;
            }
            else{
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void addEdgesWithWeightInMatrix(int [][] edges, boolean isDirected){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (isDirected){
                adjMatrix[u][v] = w;
            }
            else{
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public void findDegreeInUndirected(int [][] edges, int nodes){
        int [] degree = new int[nodes];
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            degree[from]++;
            degree[to]++;
        }

        // printing the degree
        for(int i = 0; i < nodes; i++){
            System.out.println("Node -> " + i + " degree : " + degree[i]);
        }
    }

    public void findDegreeIndirected(int [][] edges, int nodes){
        int [] inDegree = new int[nodes];
        int [] outDegree = new int[nodes];
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            outDegree[from]++;
        }

        // printing the degree
        for(int i = 0; i < nodes; i++){
            System.out.print("Node -> " + i + " in-degree : " + inDegree[i] + "  :  ");
            System.out.print("Node -> " + i + " out-degree : " + outDegree[i]);
            System.out.println();
        }
    }
    public void printAdjMatrix(){
        for(int i = 0; i < adjMatrix.length; i++){
            System.out.print("Row " + i + "-> ");
            for(int j = 0; j < adjMatrix[0].length; j++){
                System.out.print(adjMatrix[i][j]);
                if(j != adjMatrix[0].length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printAdjList(){
        for(int i = 0; i < adjList.size(); i++){
            System.out.print("Row " + i + "-> ");
            System.out.print("[");
            for(int j = 0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j));
                if(j != adjList.get(i).size()-1){
                    System.out.print(" ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printWeightedAdjList() {
        for (int i = 0; i < adjWeightedList.size(); i++) {
            System.out.print("Row " + i + "-> ");
            System.out.print("[");
            for (int j = 0; j < adjWeightedList.get(i).size(); j++) {
                System.out.print(adjWeightedList.get(i).get(j));
                if (j != adjWeightedList.get(i).size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

        public static void main(String[] args) {
        int [][] edges = {{1,2}, {1,3}, {1,4}, {3,4}};
        int [][] edgeswithWeight = {{1,2,5}, {1,3,7}, {1,4,10}, {3,4,18}};
        int nodes = 5;
        Graph graph = new Graph(nodes);
//        graph.addEdgesInMatrix(edges, false);
//        graph.printAdjMatrix();

//        graph.addEdgesInList(edges, true);
//        graph.printAdjList();

//        graph.addEdgesWithWeightInMatrix(edgeswithWeight, false);
//        graph.printAdjMatrix();

        graph.addEdgesWithWeightInList(edgeswithWeight, false);
//        graph.printWeightedAdjList();
//        graph.findDegreeInUndirected(edges, nodes);
        graph.findDegreeIndirected(edges, nodes);
    }
}
