import java.io.*;
import java.util.*;

public class cf1749E {

    static class Graph {
        Set<Node> nodes = new HashSet<>();
        Node startNode;
        Node sinkNode;

        int m;

        public Graph(int m) {
            this.m = m;
            this.startNode = new Node(-1, 0, (byte)0);
            this.sinkNode = new Node(m, 0, (byte)0);
            addNode(startNode);
            addNode(sinkNode);
        }

        void addNode(Node node) {
            nodes.add(node);
        }
    }

    static class Node {
        int x, y;
        byte weight;
        Set<Node> adjacentNodes = new HashSet<>();

        int distance = Integer.MAX_VALUE;
        Node prev;

        Node(int x, int y, byte weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        void addAdjacentNode(Node node) {
            adjacentNodes.add(node);
        }
    }

    byte [][] readField(int n, int m) {
        byte[][] result = new byte[n][m];
        for (int j = 0; j < n; j++) {
            String row = sc.nextLine();
            for (int k = 0; k < m; k++) {
                switch (row.charAt(k)) {
                    case '#': result[j][k] = 0; break;
                    case '.': result[j][k] = 1;
                }
            }
        }
        return result;
    }

    void markInaccessibleCells(byte[][] field, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 0) {
                    if (i-1 >= 0) field[i-1][j] = -1;
                    if (i+1 < n)  field[i+1][j] = -1;
                    if (j-1 >= 0) field[i][j-1] = -1;
                    if (j+1 < m)  field[i][j+1] = -1;
                }
            }
        }
    }

    Graph buildGraph(byte[][] field, int n, int m) {
       Graph result = new Graph(m);
       Node[][] fieldNodes = new Node[n][m];
       for (int x = m - 1; x >= 0; x--) {
           for (int y = 0; y < n; y++) {
               if (field[y][x] == -1) continue;
               Node node = new Node(x, y, field[y][x]);
               if (x == m - 1) {
                   node.addAdjacentNode(result.sinkNode);
               }
               if (x == 0) {
                   result.startNode.addAdjacentNode(node);
               }
               if (x < m-1) {
                   if (y > 0 && field[y-1][x+1] >= 0) {
                       node.adjacentNodes.add(fieldNodes[y-1][x+1]);
                       fieldNodes[y - 1][x + 1].adjacentNodes.add(node);
                   }
                   if (y < n-1  && field[y+1][x+1] >= 0) {
                       node.adjacentNodes.add(fieldNodes[y+1][x+1]);
                       fieldNodes[y+1][x+1].adjacentNodes.add(node);
                   }
               }
               fieldNodes[y][x] = node;
               result.addNode(node);
           }
       }
       return result;
    }

    void dijkstra(Graph graph) {
        graph.startNode.distance = 0;
        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.distance * 100000 + graph.m - node.x)
        );
        unsettledNodes.offer(graph.startNode);

        while (!unsettledNodes.isEmpty()) {
            //Node currentNode = getLowestDistanceNode(unsettledNodes);
            Node currentNode = unsettledNodes.poll();
            unsettledNodes.remove(currentNode);
            for (Node adjacentNode : currentNode.adjacentNodes) {
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, currentNode);
                    unsettledNodes.offer(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
            //if (currentNode == graph.sinkNode)
                //return;
        }
    }

    Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.distance;
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    void calculateMinimumDistance(Node targetNode, Node sourceNode) {
        int sourceDistance = sourceNode.distance;
        if (sourceDistance + targetNode.weight < targetNode.distance) {
            targetNode.distance = sourceDistance + targetNode.weight;
            targetNode.prev = sourceNode;
        }
    }

    private void updateFieldWithPath(byte[][] field, List<Node> shortestPath) {
        for (Node node : shortestPath)
            if (node.x >= 0)
              field[node.y][node.x] = 0;
    }

    private void printField(byte[][] field, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (field[i][j] == 0)
                    out.print('#');
                else
                    out.print('.');
            out.println();
        }
    }

    private List<Node> getShortestPath(Graph graph) {
        List<Node> result = new LinkedList<>();
        Node currentNode = graph.sinkNode;
        while (currentNode != graph.startNode) {
            result.add(currentNode.prev);
            currentNode = currentNode.prev;
        }
        return result;
    }

    public void solve() {
        int caseAmount = sc.nextInt();
        for (int i = 1; i <= caseAmount; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            byte[][] field = readField(n, m);
            markInaccessibleCells(field, n, m);
            Graph graph = buildGraph(field, n, m);
            dijkstra(graph);
            if (graph.sinkNode.prev == null)
                out.println("NO");
            else {
                List<Node> shortestPath = getShortestPath(graph);
                updateFieldWithPath(field, shortestPath);
                out.println("YES");
                printField(field, n, m);
            }
        }
    }



    public static void main(String[] args) {

      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      out.println(result);                    // print via PrintWriter
      */

        new cf1749E().solve();
        out.close();
    }

    static MyScanner sc = new MyScanner();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));;

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}
