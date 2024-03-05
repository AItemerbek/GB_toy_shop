
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
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

    public static void menu(){
        System.out.println("Добро пожаловать в автомат розыгрыша игрушек");
        while (true){
            System.out.println("Чтобы просмотреть меню нажмите 1");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    View.showMenu();
                    break;
                case "2":
                    View.showToys(ToysManager.getAllToys());
                    break;
                case "3":
                    addToy();
                    break;
                case "4":
                    ToysManager.chooseRandomToy();
                    break;
                case "0":
                    return;
                default:
            }
        }
    }
}
