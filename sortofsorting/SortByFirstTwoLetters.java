import java.util.*;

class SortByFirstTwoLetters implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        str1 = str1.substring(0, 2);
        str2 = str2.substring(0, 2);

        return str1.compareTo(str2);
    }
}
