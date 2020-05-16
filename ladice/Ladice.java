class Ladice {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int l = fio.nextInt();

        int[] p = new int[l + 1];
        int[] rank = new int[l + 1];
        int[] size = new int[l + 1];
        int[] items = new int[l + 1];

        for (int a = 0; a < n; a++) {
            int d1 = fio.nextInt();
            int d2 = fio.nextInt();
            boolean success = false;

            if (p[d1] == 0) {
                p[d1] = d1;
                rank[d1] = 0;
                size[d1] = 1;
                items[d1] = 1;
                success = true;
            }

            if (p[d2] == 0) {
                p[d2] = d2;
                rank[d2] = 0;
                size[d2] = 1;
                if (!success) {
                    items[d2] = 1;
                    success = true;
                }
            }

            int r1 = rec(d1, p);
            int r2 = rec(d2, p);

            int tr = r1;

            if (r1 != r2) {
                if (rank[r1] >= rank[r2]) {
                    p[r2] = r1;
                    if (rank[r1] == rank[r2]) {
                        rank[r1] = rank[r1] + 1;
                    }

                    items[r1] = items[r1] + items[r2];
                    size[r1] = size[r1] + size[r2];
                } else {
                    p[r1] = r2;
                    items[r2] = items[r2] + items[r1];
                    size[r2] = size[r2] + size[r1];
                    tr = r2;
                }
            }

            if (!success && items[tr] < size[tr]) {
                success = true;
                items[tr]++;
            }

            if (success) {
                fio.println("LADICA");
            } else {
                fio.println("SMECE");
            }
        }

        fio.close();
    }

    public static int rec(int idx, int[] p) {
        if (p[idx] == idx) {
            return idx;
        }

        p[idx] = rec(p[idx], p);
        return p[idx];
    }
}
