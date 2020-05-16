import java.util.ArrayList;
import java.util.HashMap;

class GrandpaBernie {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        HashMap<String, ArrayList<Integer>> trips = new HashMap<>();
        HashMap<String, Boolean> isSorted = new HashMap<>();

        int n = fio.nextInt();

        for (int a = 0; a < n; a++) {
            String s = fio.next();
            int y = fio.nextInt();

            ArrayList<Integer> currArr = new ArrayList<>();

            if (trips.containsKey(s)) {
                currArr = trips.get(s);
            }

            currArr.add(y);
            trips.put(s, currArr);
            isSorted.put(s, false);
        }

        int q = fio.nextInt();

        for (int a = 0; a < q; a++) {
            String s = fio.next();
            int k = fio.nextInt();

            if (!isSorted.get(s)) {
                trips.get(s).sort((val1, val2) -> val1 - val2);
                isSorted.put(s, true);
            }
    
            fio.println(trips.get(s).get(k - 1));
        }

        fio.close();
    }
}
