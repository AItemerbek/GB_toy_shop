import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Toys toy = createToy();
        System.out.println(toy);
    }

    static Toys createToy(){
        System.out.println("Введите название игрушки: ");
        String name = scanner.nextLine();
        System.out.println("Введите количество игрушек в розыгрыше, шт.:");
        int balance = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите шанс выпадения игрушки, %: ");
        float chance = Float.parseFloat(scanner.nextLine());
        return new Toys(name,balance,chance);
    }
}
