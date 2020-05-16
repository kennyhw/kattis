import java.util.ArrayList;
import java.util.PriorityQueue;

class WorkstationsMain {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int count = 0;
        int n = fio.nextInt();
        int m = fio.nextInt();

        ArrayList<Researcher> ar = new ArrayList<Researcher>();
        PriorityQueue<Workstation> pqw = new PriorityQueue<Workstation>((works1, works2)
                -> works1.check - works2.check);

        for (int a = 0; a < n; a++) {
            int start = fio.nextInt();
            int duration = fio.nextInt();
            ar.add(new Researcher(start, duration));
        }

        ar.sort((res1, res2) -> res1.start - res2.start);

        for (int a = 0; a < n; a++) {
            Researcher currRes = ar.get(a);

            if (pqw.isEmpty()) {
                pqw.offer(new Workstation(currRes.finish, m, 0));
            } else {
                int numTry = 0;
                int maxSize = pqw.size();
                
                while (true) {
                    Workstation currWorks = pqw.poll();
                    numTry++;

                    if (currRes.start == currWorks.normalEnd) {
                        count++;
                        pqw.offer(new Workstation(currRes.finish, m, currWorks.check + 1));
                        break;
                    } else if (currRes.start <= currWorks.extEnd && currRes.start > currWorks.normalEnd) {
                        count++;
                        pqw.offer(new Workstation(currRes.finish, m, currWorks.check + 1));
                        break;
                    } else if (numTry == maxSize) {
                        pqw.offer(new Workstation(currWorks.normalEnd, m, currWorks.check + 1));
                        pqw.offer(new Workstation(currRes.finish, m, 0));
                        break;
                    }

                    pqw.offer(new Workstation(currWorks.normalEnd, m, currWorks.check + 1));
                }
            }
        }

        fio.println(count);

        fio.close();
    }
}
