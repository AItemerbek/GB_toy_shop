
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addToy();
        System.out.println(ToysManager.getAllToys());
    }

    public static void addToy(){
        System.out.print("Введите имя игрушки: ");
        String name = scanner.nextLine();
        System.out.print("Введите количество игрушек, шт.: ");
        int balance = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите шанс выпадения игрушки, %: ");
        float chance = Float.parseFloat(scanner.nextLine());
        ToysManager.createToy(name,balance,chance);
    }
}
