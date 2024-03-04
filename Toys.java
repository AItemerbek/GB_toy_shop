public class Toys {
    protected String id;
    protected String name;
    protected int balance;
    protected float chance;

    protected Toys(String id, String name, int balance, float chance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.chance = chance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getChance() {
        return chance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString(){
        return ("id: " + id + "; name: " + name + "; balance: " + balance + "; chance: " + chance);
    }
}
