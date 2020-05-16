import java.util.ArrayList;
import java.util.PriorityQueue;

class LostMap {
    public static ArrayList<ArrayList<Edge>> al;
    public static PriorityQueue<Edge> queue;
    public static PriorityQueue<Edge> result;
    public static boolean[] checked;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        
        al = new ArrayList<ArrayList<Edge>>();
        queue = new PriorityQueue<Edge>((e1, e2) -> {
            if (e1.w != e2.w) {
                return e1.w - e2.w;
            } else if (e1.i != e2.i) {
                return e1.i - e2.i;
            } else {
                return e1.j - e2.j;
            }
        });
        result = new PriorityQueue<Edge>((e1, e2) -> {
            if (e1.i != e2.i) {
                return e1.i - e2.i;
            } else {
                return e1.j - e2.j;
            }
        });

        int n = fio.nextInt();

        checked = new boolean[n];

        for (int a = 0; a < n; a++) {
            al.add(new ArrayList<Edge>());
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                int w = fio.nextInt();

                al.get(a).add(new Edge(a, b, w));
            }
        }
        
        check(0);

        while (!queue.isEmpty()) {
            Edge currEdge = queue.poll();

            if (!checked[currEdge.j]) {
                result.offer(new Edge(Math.min(currEdge.i, currEdge.j), Math.max(currEdge.i, currEdge.j), currEdge.w));
                check(currEdge.j);
            }
        }

        while (!result.isEmpty()) {
            Edge currEdge = result.poll();
            fio.println(currEdge.i + 1 + " " + (currEdge.j + 1));
        }
        
        fio.close();
    }

    public static void check(int v) {
        checked[v] = true;
        int size = al.get(v).size();

        for (int a = 0; a < size; a++) {
            if (!checked[al.get(v).get(a).j]) {
                queue.offer(al.get(v).get(a));
            }
        }
    }
}
