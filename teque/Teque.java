import java.util.HashMap;

class Teque {
    public HashMap<Integer, Integer> front;
    public HashMap<Integer, Integer> back;
    public int frontFirst;
    public int frontLast;
    public int backFirst;
    public int backLast;

    public Teque() {
        front = new HashMap<Integer, Integer>();
        back = new HashMap<Integer, Integer>();
        frontFirst = 0;
        frontLast = 0;
        backFirst = 0;
        backLast = 0;
    }

    public void pushFront(int x) {
        front.put(frontFirst, x);
        frontFirst--;
        shift();
    }

    public void pushMiddle(int x) {
        frontLast++;
        front.put(frontLast, x);
        shift();
    }

    public void pushBack(int x) {
        back.put(backLast, x);
        backLast++;
        shift();
    }

    public int get(int x) {
        int frontLength = frontLast - frontFirst;

        if (x < frontLength) {
            return front.get(frontFirst + 1 + x);    
        }

        x -= frontLength;

        return back.get(backFirst + x);
    }

    public void shift() {
        if (front.size() < back.size()) {
            frontLast++;
            front.put(frontLast, back.get(backFirst));
            back.remove(backFirst);
            backFirst++;
        }

        if (front.size() > back.size() + 1) {
            backFirst--;
            back.put(backFirst, front.get(frontLast));
            front.remove(frontLast);
            frontLast--;
        }
    }
}
