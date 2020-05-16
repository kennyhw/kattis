class Workstation {
    public int normalEnd;
    public int extEnd;
    public int check;

    public Workstation(int normalEnd, int ext, int check) {
        this.normalEnd = normalEnd;
        this.extEnd = normalEnd + ext;
        this.check = check;
    }
}
