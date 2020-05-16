import java.util.Arrays;
import java.util.ArrayList;

class HumanCannonball {
    public static double INF = 1000000000;
    public static double initX;
    public static double initY;
    public static double targetX;
    public static double targetY;
    public static double[][] am;
    public static ArrayList<Vertex> queue;
    public static ArrayList<Vertex> list;
    public static double[] d;
    public static int n;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        initX = fio.nextDouble();
        initY = fio.nextDouble();
        targetX = fio.nextDouble();
        targetY = fio.nextDouble();

        n = fio.nextInt();

        list = new ArrayList<Vertex>();
        queue = new ArrayList<Vertex>();
        am = new double[n + 2][n + 2];
        d = new double[n + 2];

        Arrays.fill(d, INF);

        list.add(new Vertex(0, 0, initX, initY));
        queue.add(new Vertex(0, 0, initX, initY));
        d[0] = 0;

        if (n > 0) {
            for (int a = 1; a < n + 1; a++) {
                double currX = fio.nextDouble();
                double currY = fio.nextDouble();

                list.add(new Vertex(a, INF, currX, currY));
                queue.add(new Vertex(a, INF, currX, currY));
            }

            Vertex targetVtx = new Vertex(n + 1, INF, targetX, targetY);

            list.add(targetVtx);
            queue.add(targetVtx);

            for (int a = 0; a < n + 2; a++) {
                for (int b = 0; b < n + 2; b++) {
                    if (a != b) {
                        am[a][b] = w(list.get(a), list.get(b));
                        am[b][a] = w(list.get(b), list.get(a));
                    }
                }
            }

            while (!queue.isEmpty()) {
                Vertex currVtx = queue.remove(0);

                if (currVtx.d == d[currVtx.idx]) {
                    for (int a = 0; a < n + 2; a++) {
                        if (a != currVtx.idx && d[a] > d[currVtx.idx] + am[currVtx.idx][a]) {
                            d[a] = d[currVtx.idx] + am[currVtx.idx][a];
                            queue.add(new Vertex(a, d[a], list.get(a).x, list.get(a).y));
                        }
                    }
                }
            }

        }

        double result = 0;

        if (n > 0) {
            result = d[n + 1];
        } else {
            result = w(new Vertex(0, 0, initX, initY), new Vertex(n + 1, INF, targetX, targetY));
        }

        fio.println(result);

        fio.close();
    }

    public static double w(Vertex a, Vertex b) {
        double result = 2;
        double distance = Math.sqrt((Math.pow(b.x - a.x, 2)) + (Math.pow(b.y - a.y, 2)));
        double walkResult = distance / 5;

        if (a.idx == 0 || a.idx == n + 1) {
            return walkResult;
        }

        result += (Math.abs(50 - distance)) / 5;

        return Math.min(result, walkResult);
    }
}
