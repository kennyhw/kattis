import java.util.LinkedList;

class Islands {
    public static char[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int r = fio.nextInt();
        int c = fio.nextInt();

        map = new char[r][c];
        visited = new boolean[r][c];
        int count = 0;

        for (int a = 0; a < r; a++) {
            String input = fio.next();

            for (int b = 0; b < c; b++) {
                map[a][b] = input.charAt(b);
            }
        }

        for (int a = 0; a < r; a++) {
            for (int b = 0; b < c; b++) {
                if (map[a][b] == 'L' && !visited[a][b]) {
                    search(a, b);
                    visited[a][b] = true;
                    count++;
                }
            }
        }

        fio.println(count);

        fio.close();
    }

    public static void search(int a, int b) {
        LinkedList<IntPair> queue = new LinkedList<>();

        IntPair currPair = new IntPair(a, b);

        queue.offer(currPair);

        while (!queue.isEmpty()) {
            currPair = queue.poll();
            
            if (currPair.a != 0 && (visited[currPair.a - 1][currPair.b] == false && (map[currPair.a - 1][currPair.b] == 'L' || map[currPair.a - 1][currPair.b] == 'C'))) {
                queue.offer(new IntPair(currPair.a - 1, currPair.b));
                visited[currPair.a - 1][currPair.b] = true;
            }

            if (currPair.b != map[0].length - 1 && (visited[currPair.a][currPair.b + 1] == false && (map[currPair.a][currPair.b + 1] == 'L' || map[currPair.a][currPair.b + 1] == 'C'))) {
                queue.offer(new IntPair(currPair.a, currPair.b + 1));
                visited[currPair.a][currPair.b + 1] = true;
            }

            if (currPair.a != map.length - 1 && (visited[currPair.a + 1][currPair.b] == false && (map[currPair.a + 1][currPair.b] == 'L' || map[currPair.a + 1][currPair.b] == 'C'))) {
                queue.offer(new IntPair(currPair.a + 1, currPair.b));
                visited[currPair.a + 1][currPair.b] = true;
            }

            if (currPair.b != 0 && (visited[currPair.a][currPair.b - 1] == false && (map[currPair.a][currPair.b - 1] == 'L' || map[currPair.a][currPair.b - 1] == 'C'))) {
                queue.offer(new IntPair(currPair.a, currPair.b - 1));
                visited[currPair.a][currPair.b - 1] = true;
            }
        }
    }
}
