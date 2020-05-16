import java.util.Arrays;
import java.util.ArrayDeque;

class OneZeroKindsOfPeople {
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int r = fio.nextInt();
        int c = fio.nextInt();

        map = new int[r][c];
        visited = new int[r][c];
        
        for (int[] currRow : visited) {
            Arrays.fill(currRow, -1);
        }

        for (int a = 0; a < r; a++) {
            String input = fio.next();

            for (int b = 0; b < c; b++) {
                map[a][b] = Integer.parseInt(String.valueOf(input.charAt(b)));
            }
        }

        int n = fio.nextInt();

        for (int a = 0; a < n; a++) {
            boolean answered = false;
            int r1 = fio.nextInt() - 1;
            int c1 = fio.nextInt() - 1;
            int r2 = fio.nextInt() - 1;
            int c2 = fio.nextInt() - 1;
            
            if (visited[r1][c1] != -1) {
                answered = true;

                if (visited[r1][c1] == visited[r2][c2]) {
                    if (map[r1][c1] == 1) {
                        fio.println("decimal");
                    } else {
                        fio.println("binary");
                    }
                } else {
                    fio.println("neither");    
                }
            }

            if (!answered) {
                bfs(a, r1, c1);

                if (map[r1][c1] == 1 && visited[r2][c2] == a) {
                    fio.println("decimal");
                } else if (map[r1][c1] == 0 && visited[r2][c2] == a) {
                    fio.println("binary");
                } else {
                    fio.println("neither");
                }
            }
        }

        fio.close();
    }

    public static void bfs(int query, int r, int c) {
        ArrayDeque<IntPair> pq = new ArrayDeque<IntPair>();

        visited[r][c] = query;
        pq.offer(new IntPair(r, c));

        while (!pq.isEmpty()) {
            IntPair curr = pq.poll();

            if (curr.a != 0 && (map[curr.a - 1][curr.b] == map[curr.a][curr.b] && visited[curr.a - 1][curr.b] == -1)) {
                visited[curr.a - 1][curr.b] = query;
                pq.offer(new IntPair(curr.a - 1, curr.b));
            }

            if (curr.b != 0 && (map[curr.a][curr.b - 1] == map[curr.a][curr.b] && visited[curr.a][curr.b - 1] == -1)) {
                visited[curr.a][curr.b - 1] = query;
                pq.offer(new IntPair(curr.a, curr.b - 1));
            }

            if (curr.a != map.length - 1 && (map[curr.a + 1][curr.b] == map[curr.a][curr.b] && visited[curr.a + 1][curr.b] == -1)) {
                visited[curr.a + 1][curr.b] = query;
                pq.offer(new IntPair(curr.a + 1, curr.b));
            }

            if (curr.b != map[0].length - 1 && (map[curr.a][curr.b + 1] == map[curr.a][curr.b] && visited[curr.a][curr.b + 1] == -1)) {
                visited[curr.a][curr.b + 1] = query;
                pq.offer(new IntPair(curr.a, curr.b + 1));
            }
        }
    }
}
