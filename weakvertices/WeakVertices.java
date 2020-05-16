class WeakVertices {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        while (true) {
            int n = fio.nextInt();
            if (n == -1) {
                break;
            }
            
            boolean firstInLine = true;

            int[][] am = new int[n][n];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    am[a][b] = fio.nextInt();
                }
            }

            for (int a = 0; a < n; a++) {
                boolean quit = false;

                for (int b = 0; b < n; b++) {
                    if (am[a][b] == 1) {
                        for (int c = b; c < n; c++) {
                            if (am[a][c] == 1 && am[b][c] == 1) {
                                quit = true;
                                break;
                            }
                        }
                    }

                    if (quit) {
                        break;
                    }
                }

                if (!quit) {
                    if (firstInLine) {
                        fio.print(a);
                        firstInLine = false;
                    } else {
                        fio.print(" " + a);
                    }
                }
            }

            fio.println();
        }

        fio.close();
    }
}
