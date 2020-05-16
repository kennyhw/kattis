import java.util.Arrays;
import java.util.HashMap;

class Conformity {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();

        HashMap<String, Integer> ht = new HashMap<String, Integer>();
        int maxCount = 1;
        int award = 0;

        for (int a = 0; a < n; a++) {
            int[] input = new int[5];

            for (int b = 0; b < 5; b++) {
                input[b] = fio.nextInt();    
            }

            Arrays.sort(input);
            String str = Integer.toString(input[0]);

            for (int b = 1; b < 5; b++) {
                str += " " + Integer.toString(input[b]);    
            }

            int count = 1;

            if (ht.get(str) != null) {
                count = ht.get(str);
                count++;
            }

            ht.put(str, count);

            if (count > maxCount) {
                maxCount = count;
                award = count;
            } else if (count == maxCount) {
                award += count;
            }
        }

        fio.println(award);

        fio.close();
    }
}
