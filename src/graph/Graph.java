package graph;

import java.util.*;

public class Graph {
    private HashMap<Character, HashMap<Character, Integer>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(Character v) {
        vertices.put(v, new HashMap<>());
    }

    public int numVertices() {
        return this.vertices.size();
    }

    public boolean containsVertex(char v) {
        return this.vertices.containsKey(v);
    }

    public void addEdge(char v1, char v2, int wt) {
        if (!vertices.containsKey(v1) || !vertices.containsKey(v2)) {
            return;
        }
        vertices.get(v1).put(v2, wt);
        vertices.get(v2).put(v1, wt);
    }

    public boolean containsEdge(char v1, char v2) {
        if (!vertices.containsKey(v1) || !vertices.containsKey(v2)) {
            return false;
        }
        return vertices.get(v1).containsKey(v2);
    }

    public int numEdges() {
        Set<Character> keys = vertices.keySet();
        int count = 0;
        for (Character key : keys) {
            count += vertices.get(key).size();
        }
        return count / 2;
    }

    public void removeVertex(Character v) {
        if (!vertices.containsKey(v)) {
            return;
        }
        Set<Character> nbrs = vertices.get(v).keySet();
        for (Character nbr : nbrs) {
            vertices.get(nbr).remove(v);
        }
        vertices.remove(v);
    }

    public void removeEdge(Character v1, Character v2) {
        if (!containsEdge(v1, v2)) {
            return;
        }
        vertices.get(v1).remove(v2);
        vertices.get(v2).remove(v1);
    }

    public void display() {
        Set<Character> keys = vertices.keySet();
        for (Character key : keys) {
            System.out.println(key + "=>" + vertices.get(key));
        }
    }

    public boolean haspath(Character v1, Character v2, HashMap<Character, Boolean> visited) {
        visited.put(v1, true);
        if (containsEdge(v1, v2)) {
            return true;
        }
        Set<Character> nbrs = vertices.get(v1).keySet();
        for (Character nbr : nbrs) {
            if (!visited.containsKey(nbr) && haspath(nbr, v2, visited)) {
                return true;
            }
        }
        return false;

    }

    public boolean hasPathdfi(Character v1, Character v2) {
        HashMap<Character, Boolean> visited = new HashMap<>();
        Stack<Character> st = new Stack<>();
        st.push(v1);
        visited.put(v1, true);
        while (!st.isEmpty()) {
            char cc = st.pop();
            System.out.println(cc);
            if (containsEdge(cc, v2)) {
                return true;
            }
            Set<Character> nbrs = vertices.get(cc).keySet();
            for (Character nbr : nbrs) {
                if (!visited.containsKey(nbr)) {
                    st.push(nbr);
                    visited.put(nbr, true);
                }
            }
        }
        return false;
    }

    public boolean haspathbfi(Character v1, Character v2) {
        HashMap<Character, Boolean> visited = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        q.offer(v1);
        visited.put(v1, true);
        while (!q.isEmpty()) {
            char cc = q.poll();
            System.out.println(cc);
            if (containsEdge(cc, v2)) {
                return true;
            }
            Set<Character> nbrs = vertices.get(cc).keySet();
            for (Character nbr : nbrs) {
                if (!visited.containsKey(nbr)) {
                    q.offer(nbr);
                    visited.put(nbr, true);
                }
            }
        }
        return false;
    }

    public void dft() {
        HashMap<Character, Boolean> visited = new HashMap<>();
        Set<Character> keys = vertices.keySet();
        Stack<Character> st = new Stack<>();
        for (Character key : keys) {
            if (!visited.containsKey(key)) {
                st.push(key);
                visited.put(key, true);
            }
            while (!st.isEmpty()) {
                Character cc = st.pop();
                System.out.println(cc);
                Set<Character> nbrs = vertices.get(cc).keySet();
                for (Character nbr : nbrs) {
                    if (!visited.containsKey(nbr)) {
                        st.push(nbr);
                        visited.put(nbr, true);
                    }
                }
            }
        }
    }

    public boolean isCyclic() {
        HashMap<Character, Character> visited = new HashMap<>();
        Stack<Character> st = new Stack<>();
        Set<Character> allVertices = vertices.keySet();
        for (Character v : allVertices) {
            if (!visited.containsKey(v)) {
                visited.put(v, null);
                st.push(v);
            }
            while (!st.isEmpty()) {
                char cc = st.pop();
                Set<Character> nbrs = vertices.get(cc).keySet();
                for (Character nbr : nbrs) {
                    if (!visited.containsKey(nbr)) {
                        st.push(nbr);
                        visited.put(nbr, cc);
                    } else {
                        Character reason = visited.get(cc);
                        if (reason != null && !reason.equals(nbr)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isBipartite() {
        HashMap<Character, Character> color = new HashMap<>();
        Stack<Character> st = new Stack<>();
        Set<Character> allVertices = vertices.keySet();
        for (Character v : allVertices) {
            if (!color.containsKey(v)) {
                color.put(v, 'R');
                st.push(v);
            }
            while (!st.isEmpty()) {
                char cc = st.pop();
                Set<Character> nbrs = vertices.get(cc).keySet();
                for (Character nbr : nbrs) {
                    if (!color.containsKey(nbr)) {
                        st.push(nbr);
                        if (color.get(cc) == 'R') {
                            color.put(nbr, 'G');
                        } else {
                            color.put(nbr, 'R');
                        }
                    }
                }
            }
        }
        System.out.println(color);
        HashMap<Character,Boolean>visited=new HashMap<>();
        for(Character v:allVertices){
            if(!visited.containsKey(v)){
                visited.put(v,true);
                st.push(v);
            }
            while (!st.isEmpty()){
                char cc=st.pop();
                Set<Character>nbrs=vertices.get(cc).keySet();
                for(Character nbr:nbrs){
                    if(!visited.containsKey(nbr)){
                        st.push(nbr);
                        visited.put(nbr,true);
                    }
                    if(color.get(nbr)==color.get(cc)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private class PrimHelper implements Comparable<PrimHelper>{
        int cost;
        Character acquirer;
        Character vertex;
        public PrimHelper(int c,Character a,Character v){
            this.cost=c;
            this.acquirer=a;
            this.vertex=v;
        }

        @Override
        public int compareTo(PrimHelper primHelper) {
            return this.cost-primHelper.cost;
        }
    }
    public Graph mst(){
        HashMap<Character,PrimHelper>map=new HashMap<>();
        PriorityQueue<PrimHelper>minheap=new PriorityQueue<>();
        Graph rv=new Graph();
        Set<Character>allvertices=vertices.keySet();
        for(Character v:allvertices){
            PrimHelper p=new PrimHelper(Integer.MAX_VALUE,null,v);
            map.put(v,p);
            minheap.offer(p);
        }
        while(!minheap.isEmpty()){
            PrimHelper curr=minheap.poll();
            rv.addVertex(curr.vertex);
            map.remove(curr.vertex);
            if(curr.acquirer!=null){
                rv.addEdge(curr.vertex,curr.acquirer,curr.cost);
            }
            Set<Character>nbrsofcurr=vertices.get(curr.vertex).keySet();
            for(Character nbr:nbrsofcurr){
                if(map.containsKey(nbr)){
                    PrimHelper nbrprimhelper=map.get(nbr);
                    int oldcost=nbrprimhelper.cost;
                    int newcost=vertices.get(curr.vertex).get(nbr);
                    if(oldcost>newcost){
                        minheap.remove(nbrprimhelper);
                        nbrprimhelper.acquirer=curr.vertex;
                        nbrprimhelper.cost=newcost;
                        minheap.offer(nbrprimhelper);
                    }
                }
            }
        }
        return rv;
    }
    public void dijkstra(Character source){
        HashMap<Character,PrimHelper>map=new HashMap<>();
        PriorityQueue<PrimHelper>minheap=new PriorityQueue<>();
        Set<Character>allvertices=vertices.keySet();
        for(Character v:allvertices){
            PrimHelper p;
            if(v==source){
                p=new PrimHelper(0,null,v);
            }else{
                p=new PrimHelper(Integer.MAX_VALUE,null,v);
            }
            minheap.offer(p);
            map.put(v,p);
        }
        while(!minheap.isEmpty()){
            PrimHelper curr=minheap.poll();
            map.remove(curr.vertex);
            System.out.println(curr.vertex+" "+curr.cost);
            Set<Character>nbrsofcurr=vertices.get(curr.vertex).keySet();
            for(Character nbr:nbrsofcurr){
                if(map.containsKey(nbr)){
                    PrimHelper nbrprimhelper=map.get(nbr);
                    int oldcost=nbrprimhelper.cost;
                    int newcost=vertices.get(curr.vertex).get(nbr)+curr.cost;
                    if(oldcost>newcost){
                        minheap.remove(nbrprimhelper);
                        nbrprimhelper.acquirer=curr.vertex;
                        nbrprimhelper.cost=newcost;
                        minheap.offer(nbrprimhelper);
                    }
                }
            }
        }
    }
    private class Edge implements Comparable<Edge>{
        Character start;
        Character end;
        int weight;
        public Edge(Character s,Character e,int w){
            start=s;
            end=e;
            weight=w;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight-edge.weight;
        }
    }
    public Graph kruskal(){
        ArrayList<Edge>al=new ArrayList<>();
        Set<Character>allvertices=vertices.keySet();
        for(Character v:allvertices){
            Set<Character>nbrs=vertices.get(v).keySet();
            for(Character nbr:nbrs){
                Edge e=new Edge(v,nbr,vertices.get(v).get(nbr));
                al.add(e);
            }
        }
        Collections.sort(al);
        HashMap<Character,Character>parents=generateParents();
        HashMap<Character,Boolean>visited=new HashMap<>();
        Graph rv=new Graph();
        for(int i=0;i<al.size();i+=2){
            Edge e = al.get(i);
            if(union(e.start,e.end,parents)){
                if(!visited.containsKey(e.start)){
                    visited.put(e.start,true);
                    rv.addVertex(e.start);
                }
                if(!visited.containsKey(e.end)){
                    visited.put(e.end,true);
                    rv.addVertex(e.end);
                }
                rv.addEdge(e.start,e.end,e.weight);
            }
        }
        return rv;
    }
    private HashMap<Character,Character>generateParents(){
        Set<Character>allvertices=vertices.keySet();
        HashMap<Character,Character>p=new HashMap<>();
        for(Character v:allvertices){
            p.put(v,null);
        }
        return p;
    }
    private Character find(Character vertex,HashMap<Character,Character>p){
        while(p.get(vertex)!=null){
            vertex=p.get(vertex);
        }
        return vertex;
    }
    private boolean union(Character v1,Character v2,HashMap<Character,Character>p){
        v1=find(v1,p);
        v2=find(v2,p);
        if(v1!=v2){
            p.put(v1,v2);
            return true;
        }else{
            return false;
        }
    }
}
