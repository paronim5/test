

public class Enemy {
    private String name;
    private int health;
    private int attackDamage;


    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
        this.attackDamage = 5;

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        return(int)(Math.random()*15+1+ attackDamage);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}

