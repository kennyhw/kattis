import java.util.*;

class BestRelayTeam {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();

        Runner[] pool = new Runner[n];

        for(int a = 0; a < pool.length; a++) {
            String name = fio.next();
            double timeA = fio.nextDouble();
            double timeB = fio.nextDouble();

            pool[a] = new Runner(name, timeA, timeB);
        }

        Arrays.sort(pool, new ComparatorB());

        Runner[] fastestTeam = new Runner[4];
        
        double fastestTime = 0;

        for(int a = 0; a < pool.length; a++) {
            Runner[] team = new Runner[4];
            team[0] = pool[a];
            int idx = 1;
            double currentTime = team[0].timeA;

            for(int b = 0; b < pool.length && idx < 4; b++) {
                if (a != b) {
                    team[idx] = pool[b];
                    currentTime += team[idx].timeB;
                    idx++;
                }
            }
            
            if (a == 0 || currentTime < fastestTime) {
                fastestTeam = team;
                fastestTime = currentTime;
            }
        }
        
        fio.println(fastestTime);

        for(Runner a : fastestTeam) {
            fio.println(a.name);
        }

        fio.close();
    }
}
