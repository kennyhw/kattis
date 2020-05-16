class TrainPassengers {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int c = fio.nextInt();
        int n = fio.nextInt();

        boolean isPossible = true;
        int currentLoad = 0;

        for(int a = 0; a < n; a++) {
            int out = fio.nextInt();
            int in = fio.nextInt();
            int wait = fio.nextInt();
            currentLoad = currentLoad - out + in;

            if (isPossible) {
                if (out < 0 || (in < 0 || wait < 0)) {
                    isPossible = false;
                } else if (currentLoad > c || currentLoad < 0) {
                    isPossible = false;
                } else if (wait > 0 && currentLoad != c) {
                    isPossible = false;
                } else if(a == 0 && out != 0) {
                    isPossible = false;
                } else if(a == n - 1 && currentLoad != 0) {
                    isPossible = false;
                }
            }
        }

        fio.println(isPossible ? "possible" : "impossible");

        fio.close();
    }
}
