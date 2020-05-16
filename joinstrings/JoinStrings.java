class JoinStrings {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();

        String[] str = new String[n + 1];
        int[] idx = new int[n + 1];
        int[] endIdx = new int[n + 1];

        for (int a = 1; a <= n; a++) {
            str[a] = fio.next();
        }

        int idx1 = 1;
        int idx2 = 0;

        for (int a = 1; a <= n - 1; a++) {
            idx1 = fio.nextInt();
            idx2 = fio.nextInt();

            int lastIdx = endIdx[idx1];

            if (lastIdx == 0) {
                lastIdx = idx1;

                while (idx[lastIdx] != 0) {
                    lastIdx = idx[idx1];
                }
            }

            idx[lastIdx] = idx2;
            endIdx[idx1] = endIdx[idx2];

            if (endIdx[idx1] == 0) {
                endIdx[idx1] = idx2;
            }
        }

        while (idx[idx1] != 0) {
            fio.print(str[idx1]);
            idx1 = idx[idx1];
        }

        fio.print(str[idx1]);

        fio.close();
    }
}
