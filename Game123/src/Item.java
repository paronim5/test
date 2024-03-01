public class Item {
    private String name;
    private int hpPlus;

    public Item(String name, int hpPlus) {
        this.name = name;
        this.hpPlus = hpPlus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHpPlus() {
        return hpPlus;
    }

    public void setHpPlus(int hpPlus) {
        this.hpPlus = hpPlus;
    }

    @Override
    public String toString() {
        return "Item " +
                "name " + name + '\'' +
                " hp restore " + hpPlus ;
    }
}
