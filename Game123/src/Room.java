import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private String name;
    List<String> exits ;
    ArrayList<Enemy> enemyArrayList;
    ArrayList<Item> itemArrayList;

    public Room( String name,int number, List<String> exits) {
        this.name = name;
        this.number = number;
        this.exits = exits;
        this.enemyArrayList = new ArrayList<>();
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getExits() {
        return exits;
    }

    public void setExits(List<String> exits) {
        this.exits = exits;
    }

    public ArrayList<Enemy> getEnemyArrayList() {
        return enemyArrayList;
    }

    public void setEnemyArrayList(ArrayList<Enemy> enemyArrayList) {
        this.enemyArrayList = enemyArrayList;
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @Override
    public String toString() {
        return "Room " +
                "number " + number +
                ", name " + name ;
    }
    public void clearItems() {
        itemArrayList.clear();
    }
}
