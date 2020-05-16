class TequeMain {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        Teque teque = new Teque();

        for (int a = 0; a < n; a++) {
            String command = fio.next();
            int x = fio.nextInt();

            switch (command) {
                case "push_front":
                    teque.pushFront(x);
                    break;
                case "push_middle":
                    teque.pushMiddle(x);
                    break;
                case "push_back":
                    teque.pushBack(x);
                    break;
                case "get":
                    fio.println(teque.get(x));
                    break;
                default:
            }
        }

        fio.close();
    } 
}
