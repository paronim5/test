import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class GameSens {
    private Charecter player;
    private Map map;
    private Item item;
    Scanner sc = new Scanner(System.in);
    public GameSens() {
        this.player  =new Charecter("name1");
        this.map = new Map("map");
        this.item = new Item("item", 30);
    }

    public void checkRoom(){
        System.out.println(player.getRow() + "row");
        System.out.println(player.getCol()+ "col");
    }
    public void fight() {
        Room currentRoom = map.getCurrentRoom(player.getRow(), player.getCol());
        List<Enemy> enemy = currentRoom.getEnemyArrayList();
        if (enemy.isEmpty()) {
            System.out.println("There are no enemies in this room ");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("You have met an enemy in this room!");

            System.out.println("You are fighting with " + enemy.get(0).getName());
            while (player.isAlive() && enemy.get(0).isAlive()) {
                System.out.println("Your hp: " + player.getHp());
                System.out.println("Enemy hp: " + enemy.get(0).getHealth());
                System.out.println("What to do?");
                System.out.println("1. Attack");
                System.out.println("2. Run");
                System.out.println("3. Heal");


                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        int playerDamage = player.attack();
                        int enemyDamage = enemy.get(0).attack();
                        enemy.get(0).takeDamage(playerDamage);
                        player.takeDamage(enemyDamage);
                        System.out.println("You deal " + playerDamage + " damage to the enemy");
                        System.out.println("Enemy deals " + enemyDamage + " damage to you");
                        break;
                    case 2:
                        if((int)(Math.random() * 3 + 1) == 1){
                        System.out.println("You run away from enemy.");
                        }
                        else {
                            System.out.println("You have to fight");
                            int playerDamage2 = player.attack();
                            int enemyDamage2 = enemy.get(0).attack();
                            enemy.get(0).takeDamage(playerDamage2);
                            player.takeDamage(enemyDamage2);
                            System.out.println("You deal " + playerDamage2+ " damage to the enemy");
                            System.out.println("Enemy deals " + enemyDamage2  + " damage to you");
                            break;
                        }
                        return;
                    case 3:
                        player.heal(item);
                }
            }

            if (player.isAlive() == false) {
                System.out.println("You lose((( Gl next time");
            }
    }
    public void gameLoop() {
        startText();
        while (player.isAlive() /*&& (player.getRow() == 2 && player.getCol() == 3) == false*/) {
if ((player.getRow() == 2 && player.getCol() == 1) == false){
            move();
            checkRoom();
            checkEnemy();
            checkItem();
}else {
    endText();
    player.setHp(-9);
}
            }
        }

    public void checkEnemy(){
        Room currentRoom = map.getCurrentRoom(player.getRow(), player.getCol());
        List<Enemy> enemies = currentRoom.getEnemyArrayList();
        if (!enemies.isEmpty()) {
            System.out.println("You have met an enemy!");
                fight();
                if (player.isAlive()==false) {
                    System.out.println("Game over! You died.");
            }
        }
    }




    public void checkItem(){
        Room currentRoom = map.getCurrentRoom(player.getRow(), player.getCol());
        List<Item> items = new ArrayList<>(currentRoom.getItemArrayList());
        if (!items.isEmpty()) {
            System.out.println("You found some items!");
            for (Item item : items) {
                System.out.println("You picked up: " + item.getName());
                player.pickUpItem(item, currentRoom);
                checkBackpack();
            }
            currentRoom.clearItems();
        }
    }

    public void checkBackpack(){ //add item into backpack
     player.checkInvent();
    }
    private void printCurrentRoomInfo() {
        Room currentRoom = map.getCurrentRoom(player.getRow(), player.getCol());
        System.out.println("You are now in the " + currentRoom.getName() + "."+ currentRoom.getNumber());

    }
    public void move() {
        printCurrentRoomInfo();
        System.out.print("Enter direction " +
                "\n(north, south, east, west): ");
        String direction = sc.nextLine().toLowerCase();

        switch (direction) {
            case "north":
                if (player.getRow() > 0)
                    player.setRow(player.getRow()-1);//row--
                else
                    System.out.println("There is no exit to the north.");
                break;
            case "south":
                if (player.getRow() < map.getRows() - 1){
                  player.setRow(player.getRow()+1); // row++
                }
                else
                    System.out.println("There is no exit to the south.");
                break;
            case "west":
                if (player.getCol() > 0)
                    player.setCol(player.getCol()-1);//col--
                else
                    System.out.println("There is no exit to the west.");
                break;
            case "east":
                if (player.getCol() < map.getCols() - 1)
                    player.setCol(player.getCol()+1);//col++
                else
                    System.out.println("There is no exit to the east.");
                break;
            default:
                System.out.println("Invalid direction. Please enter 'north', 'south', 'west', or 'east'.");
                break;
        }

    }
    public void startText(){
        System.out.println("Hello ");
        System.out.println("I am happy to see you in my simple text game");
        System.out.println("Your goal is to reach station which situated here row: 2, col: 1");
        System.out.println("Good luck!");
    }
    public void endText(){
        System.out.println("Congratulations!!!");
        System.out.println("You have won my simple text game");
    }
}

