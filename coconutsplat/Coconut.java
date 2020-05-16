import java.util.*;

class Coconut {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int s = fio.nextInt();
        int n = fio.nextInt();

        LinkedList<Hand> hands = new LinkedList<Hand>();

        for(int a = 1; a <= n; a++) {
            Hand hand = new Hand(a, "folded");

            hands.add(hand);
        }

        while (n != 1) {
            int i = s - 1;

            while (i != 0) {
                hands.addLast(hands.getFirst());     
                hands.removeFirst();
                i--;
            }

            String currentState = hands.getFirst().state;
            int currentId = hands.getFirst().playerId;

            if (currentState.equals("folded")) {
                hands.removeFirst();
                hands.addFirst(new Hand(currentId, "fist"));
                hands.addFirst(new Hand(currentId, "fist"));
            } else if (currentState.equals("fist")) {
                hands.addLast(new Hand(currentId, "palmdown"));
                hands.removeFirst();
            } else if (currentState.equals("palmdown")) {
                hands.removeFirst();
                if (hands.getFirst().playerId != currentId && hands.getLast().playerId != currentId) {
                    n--;
                }
            }

        }

        fio.println(hands.getFirst().playerId);

        fio.close();
    }
}
