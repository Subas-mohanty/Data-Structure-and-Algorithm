package Leetcode;

public class _1579_remove_max_number_of_edges_in_graph {

    public class DisjointSet {
        int [] parent;
        int [] size;
        int components;

        public DisjointSet(int n){
            this.parent = new int[n+1];
            this.size = new int[n+1];
            this.components = n;
            for (int i = 0; i < n; i++) {
                // initially every node is the parent of itself
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }
        public int findRootParent(int node){
            if(node == parent[node]) return node;
            parent[node] = findRootParent(parent[node]); // updating the parent of every node with the root parent, this means the root parent is the parent of every node in the component
            return parent[node];
        }

        // here size is the number of node in the component
        public int unionBySize(int node1, int node2){
            int parent1 = findRootParent(node1);
            int parent2 = findRootParent(node2);

            // if both the nodes are belong to same component than no need to do union
            if(parent1 == parent2) return 0;

            components--;

            if(size[parent1] == size[parent2]){
                // updating size of parent1 , adding size of parent2 in size of parent1
                size[parent1] += size[parent2];
                parent[parent2] = parent1;
            }
            else if(size[parent1] > size[parent2]){
                size[parent1] += size[parent2];
                parent[parent2] = parent1;
            }
            else{
                size[parent2] += size[parent1];
                parent[parent1] = parent2;
            }
            return 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);

        int edgesReq = 0;

        for(int [] edge : edges){
            if(edge[0] == 3){
                edgesReq += alice.unionBySize(edge[1], edge[2]) | bob.unionBySize(edge[1], edge[2]);
            }
        }
        for(int [] edge : edges){
            if(edge[0] == 1){
                edgesReq += alice.unionBySize(edge[1], edge[2]);
            }
            if(edge[0] == 2){
                edgesReq += bob.unionBySize(edge[1], edge[2]);
            }
        }
        // edges.length is the number of edges present in the graph/component
        // if both have one component then only return the answer, which means both can travel the whole graph otherwise returning -1, means either of them can't travel the whole graph
        if(alice.components == 1 &&  bob.components == 1) return edges.length - edgesReq;
        return -1;
    }
}
