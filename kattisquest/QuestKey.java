class QuestKey implements Comparable<QuestKey> {
    public int en;
    public int gd;

    public QuestKey(int en, int gd) {
        this.en = en;
        this.gd = gd;
    }

    @Override
    public int compareTo(QuestKey another) {
        if (this.en != another.en) {
            return this.en - another.en;
        }

        return this.gd - another.gd;
    }

    public boolean equals(QuestKey another) {
        return this.en == another.en && this.gd == another.gd;
    }
}
