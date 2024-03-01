import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private Room[][] rooms;
    private String[] enemyNames = {"Goblin", "Orc", "Skeleton", "Spider", "Zombie"};
    private String[] itemNames = {"Pill", "Syringe", "Potion", "Elixir", "Tonic"};
    public Map(String filename) {
        rooms = new Room[3][3];
        loadRoomsFromFile(filename);
        spawnEnemies();
        spawnItems();
}


    public void loadRoomsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String name = "";
            int row = 0;
            int col = 0;
          //  int number = 0;
            List<String> exits = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("RN:")) {
                    name = line.substring(4).trim();
               // } else if (line.startsWith("ID:")) {
              //      number = Integer.parseInt(line.substring(4).trim());
                } else if (line.startsWith("Exit:")) {
                    exits.add(line.substring(6).trim());
                } else if (line.equals("abcdef")) {
                    rooms[row][col] = new Room(name, row * rooms.length + col + 1, exits);

                    col++;
                    if (col == rooms[row].length) {
                        col = 0;
                        row++;
                    }
                    name = "";
                    exits = new ArrayList<>();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Room getCurrentRoom(int row, int col) {
        return rooms[row][col];
    }
   /* public void printAllRooms() {
        for (Room[] row : rooms) {
            for (Room room : row) {
                if (room != null) {
                    System.out.println("Name: " + room.getName());
                    System.out.println("Number: " + room.getNumber());
                    System.out.println("Exits: " + room.getExits());
                    System.out.println();
                }
            }
        }
    }*/
    private void spawnEnemies() {

        for (Room[] row : rooms) {
            for (Room room : row) {
                if (room != null) {
                    List<Enemy> enemies = room.getEnemyArrayList();
                    String enemyName = getRandomEnemyName();
                        enemies.add(new Enemy(enemyName ,  (int)(Math.random() * 50 + 50)));

                }
            }
        }
    }
    private void spawnItems() {
        for (Room[] row : rooms) {
            for (Room room : row) {
                if (room != null) {
                    ArrayList<Item> items = room.getItemArrayList();
                    if (items == null) {
                        items = new ArrayList<>();
                        room.setItemArrayList(items);
                    }
                    String itemName = getRandomItemName();
                    items.add(new Item(itemName,30));
                }
            }
        }
    }
    public int getRows() {
        return rooms.length;
    }

    public int getCols() {
        return rooms[0].length;
    }


    private String getRandomEnemyName() {
        Random random = new Random();
        int index = random.nextInt(enemyNames.length);
        return enemyNames[index];
    }
    private String getRandomItemName() {
        Random random = new Random();
        int index = random.nextInt(itemNames.length);
        return itemNames[index];
    }
}
