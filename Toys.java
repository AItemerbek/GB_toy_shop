public class Toys {
    private static int nextId = 100001;
    protected String id;
    protected String name;
    protected int balance;
    protected float chance;

    public Toys(String name, int balance, float chance) {
        this.id = generateUniqueId();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setChance(float chance) {
        this.chance = chance;
    }

    private String generateUniqueId() {
        return String.valueOf(nextId++);
    }

    @Override
    public String toString(){
        return ("id: " + id + "; name: " + name + "; balance: " + balance + "; chance: " + chance);
    }
}
