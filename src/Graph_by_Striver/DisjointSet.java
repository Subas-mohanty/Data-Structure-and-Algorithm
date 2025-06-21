package Graph_by_Striver;
//https://www.youtube.com/watch?v=7wgUuv0U5zs


// TC : O(4 alpha(n)) --> near to constant
public class DisjointSet {
    int [] rank;
    int [] parent;
    int [] size;
    int components;
    
    public DisjointSet(int n){
        this.rank = new int[n];
        this.parent = new int[n];
        this.size = new int[n];
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

    // find root of node1
    // find root of node2
    // if rank is same increase the rank and update the parent
    // if rank is not same only update the parent
    public void unionByRank(int node1, int node2){
        int parent1 = findRootParent(node1);
        int parent2 = findRootParent(node2);

        // if both the nodes are belong to same component than no need to do union
        if(parent1 == parent2) return;

        components--;

        if(rank[parent1] == rank[parent2]){
            rank[parent1]++;
            parent[parent2] = parent1;
        }
        else if(rank[parent1] > rank[parent2]){
            parent[parent2] = parent1;
        }
        else{
            parent[parent1] = parent2;
        }
    }

    // here size is the number of node in the component
    public void unionBySize(int node1, int node2){
        int parent1 = findRootParent(node1);
        int parent2 = findRootParent(node2);

        // if both the nodes are belong to same component than no need to do union
        if(parent1 == parent2) return;

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
    }


    public static void main(String[] args) {
        DisjointSet dsu = new DisjointSet(4);
        System.out.println("Number of components -> " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(1));
        dsu.unionByRank(0,1); // doing union of 0 and 1
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(1));
        System.out.println("Number of components -> " + dsu.components);

        dsu.unionBySize(2, 3);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(1));
        System.out.println("Number of components -> " + dsu.components);
    }
}
