import java.util.*;

class ComparatorB implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        double diff = a.timeB - b.timeB;
        
        if (diff > 0) {
            return 1;
        }

        if (diff < 0) {
            return -1;
        }

        return 0;
    }
}
