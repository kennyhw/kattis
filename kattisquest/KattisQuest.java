import java.util.TreeMap;

class KattisQuest {
    public static TreeMap<QuestKey, QuestValue> quests = new TreeMap<QuestKey, QuestValue>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();

        for (int a = 0; a < n; a++) {
            String input = fio.nextLine();

            String[] inputArr = input.split(" ");

            if (inputArr[0].equals("add")) {
                add(Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
            } else {
                fio.println(query(Integer.parseInt(inputArr[1])));
            }
        }

        fio.close();
    }

    public static void add(int e, int g) {
        QuestKey currQuestKey = new QuestKey(e, g);

        if (!quests.containsKey(currQuestKey)) {
            quests.put(currQuestKey, new QuestValue());
        } else {
            QuestValue currQuestVal = quests.get(currQuestKey);
            currQuestVal.count++;
        }
    }

    public static long query(int x) {
        boolean foundQuest = true;
        long result = 0;

        while (x != 0 && foundQuest) {
            foundQuest = false;

            QuestKey currQuestKey = quests.floorKey(new QuestKey(x, 100000));

            if (currQuestKey != null) {
                QuestValue currQuestVal = quests.get(currQuestKey);

                foundQuest = true;
                x -= currQuestKey.en;
                result += currQuestKey.gd;

                currQuestVal.count--;

                if (currQuestVal.count == 0) {
                    quests.remove(currQuestKey);
                }
            }
        }

        return result;
    }
}
