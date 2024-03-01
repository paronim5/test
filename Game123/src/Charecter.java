
import java.util.Scanner;

public class Charecter {
    private String name;
    private int hp;
    private Backpack backpack;
    private int power;
    private int row  =0;
    private int col =0;
     Scanner scanner;




    public Charecter(String name) {
        this.name = name;
        this.hp = 100;
        this.backpack = new Backpack();
        this.power = 10;
        this.scanner = new Scanner(System.in);

    }
    public void heal(Item item1){
        if(!backpack.getItem().isEmpty() &&hp+ item1.getHpPlus()<100){
        hp=hp +item1.getHpPlus();
        System.out.println("You have healed "+ item1.getHpPlus()+" Hp");
        backpack.removeItem(item1);
        }else{
            System.out.println("You can't heal");
        }
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int attack() {
        return (int)(Math.random()*15+5+ power);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
    public void checkInvent(){
        backpack.printItem();
    }

    public void pickUpItem(Item item, Room currentRoom) {
        if (currentRoom.getItemArrayList().contains(item)) { // check if we have an item in this room
           backpack.addItem(item);
            currentRoom.getItemArrayList().remove(item); // when we add an item to the backpack we have to delete item from room
            System.out.println("You picked up " + item.getName());
        }
    }

}


