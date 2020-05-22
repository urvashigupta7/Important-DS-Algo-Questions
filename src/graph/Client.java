package graph;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');

        g.addEdge('A', 'B', 5);
        g.addEdge('A', 'D', 6);
        g.addEdge('B', 'C', 3);
        g.addEdge('C', 'D', 2);
        g.addEdge('D', 'E', 9);
        g.addEdge('E', 'F', 1);
        g.addEdge('E', 'G', 4);
        g.addEdge('F', 'G', 7);
        g.display();
//        System.out.println(g.hasPathdfi('A','G'));
//        System.out.println(g.haspathbfi('A','G'));
        g.dft();
        System.out.println(g.isCyclic());
        System.out.println(g.isBipartite());
        Graph mst=g.mst();
        mst.display();
        g.dijkstra('A');
        Graph kruskal=g.kruskal();
        kruskal.display();
    }
}
