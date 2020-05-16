import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;

class MillionaireMadness {
    public static int INF = 1000000000;
    public static ArrayList<ArrayList<Edge>> al;
    public static PriorityQueue<Edge> pq;
    public static int[][] map;
    public static boolean[] v;
    public static int[] res;
    
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int m = fio.nextInt();
        int n = fio.nextInt();

        al = new ArrayList<ArrayList<Edge>>();
        
        pq = new PriorityQueue<Edge>((e1, e2) -> {
            if (e1.w != e2.w) {
                return e1.w - e2.w;
            } else if (e1.u != e2.u) {
                return e1.u - e2.u;
            } else {
                return e1.v - e2.v;
            }
        });

        map = new int[m][n];
        v = new boolean[m * n];
        res = new int[m * n];

        Arrays.fill(res, INF);

        for (int a = 0; a < m * n; a++) {
            al.add(new ArrayList<Edge>());
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                map[a][b] = fio.nextInt();
            }
        }
        
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                ArrayList<Edge> currArrList = al.get(a * n + b);
                
                if (a != 0) {
                    currArrList.add(new Edge(w(a, b, a - 1, b), a * n + b, (a - 1) * n + b));
                }

                if (b != 0) {
                    currArrList.add(new Edge(w(a, b, a, b - 1), a * n + b, a * n + b - 1));
                }

                if (a != m - 1) {
                    currArrList.add(new Edge(w(a, b, a + 1, b), a * n + b, (a + 1) * n + b));
                }

                if (b != n - 1) {
                    currArrList.add(new Edge(w(a, b, a, b + 1), a * n + b, a * n + b + 1));
                }
            }
        }
        
        ArrayList<Edge> firstArrList = al.get(0);
        v[0] = true;
        res[0] = 0;

        for (Edge e : firstArrList) {
            pq.offer(e);
        }
        
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            
            if (!v[curr.v] || res[curr.v] > Math.max(res[curr.u], curr.w)) {
                v[curr.v] = true;
                res[curr.v] = Math.max(res[curr.u], curr.w);
                int size = al.get(curr.v).size();

                for (int a = 0; a < size; a++) {
                    if(!v[al.get(curr.v).get(a).v]) {
                        pq.offer(al.get(curr.v).get(a));
                    }
                }
            }
        }

        fio.println(res[m * n - 1]);

        fio.close();
    }

    public static int w(int r1, int c1, int r2, int c2) {
        int h1 = map[r1][c1];
        int h2 = map[r2][c2];
        
        return Math.max(0, h2 - h1);
    }
}
