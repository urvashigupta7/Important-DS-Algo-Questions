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

}
