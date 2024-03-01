import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Item> item;

    public Backpack() {
        this.item = new ArrayList<>();
    }
    public void addItem(Item item1){
        item.add(item1);
        System.out.println(item1.getName()+" has been added to your backpack");
    }
public void removeItem(Item item1){
        item.remove(item1);
    System.out.println(item1.getName()+" has been used");
}

public void printItem(){
        for (int i = 0;i<item.size();i++){
            System.out.println(item.get(i));
        }
}

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
