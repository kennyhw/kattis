import java.util.*;

class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        
        boolean firstLoop = true;

        while(true) {
            int n = fio.nextInt();
            if (n == 0) {
                break;
            }

            String[] names = new String[n];

            for(int a = 0; a < n; a++) {
                names[a] = fio.next();
            }

            Arrays.sort(names, new SortByFirstTwoLetters());
            
            if (!firstLoop) {
                fio.println();
            }

            for(int a = 0; a < n; a++) {
                fio.println(names[a]);
            }

            firstLoop = false;
        }

        fio.close();
    }
}
