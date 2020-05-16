class Restaurant {
    private String name;
    private String[] menu;
    
    public Restaurant(String name, int numOfItems) {
        this.name = name;
        this.menu = new String[numOfItems];
    }

    public void setItem(int index, String itemName) {
        menu[index] = itemName;
    }

    public String getName() {
        return this.name;
    }

    public String[] getMenu() {
        return this.menu;
    }
}
