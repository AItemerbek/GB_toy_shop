
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void addToy() {
        int balance;
        float chance;
        System.out.print("Введите имя игрушки: ");
        String name = scanner.nextLine();
        while (true) {
            System.out.print("Введите количество игрушек, шт.: ");
            try {
                balance = Integer.parseInt(scanner.nextLine());
                if (balance > 0) break;
                else {
                    System.out.println("Количество игрушек не может быть меньше 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            }
        }
        while (true) {
            System.out.print("Введите шанс выпадения игрушки, %: ");
            try {
                chance = Float.parseFloat(scanner.nextLine());
                if (chance >= 0.1 && chance <= 99.9) break;
                else {
                    System.out.println("Шанс выпадения не может быть меньше 0,1 % или больше 99,9%");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            }
        }
        ToysManager.createToy(name, balance, chance);
    }

    public static void addNewChance() {
        System.out.print("Введите ID игрушки, шанс выпадения которой Вы хотите изменить: ");
        String id = scanner.nextLine();
        float chance;
        while (true) {
            System.out.print("Введите шанс выпадения игрушки, %: ");
            try {
                chance = Float.parseFloat(scanner.nextLine());
                if (chance >= 0.1 && chance <= 99.9) break;
                else {
                    System.out.println("Шанс выпадения не может быть меньше 0,1 % или больше 99,9%");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            }
        }
        ToysManager.updateToyChance(id, chance);
    }


    public static void menu() {
        System.out.println("Добро пожаловать в автомат розыгрыша игрушек");
        while (true) {
            System.out.println("Чтобы просмотреть меню нажмите 1");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();
            switch (choice) {
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
                case "5":
                    ToysManager.moveLastWinningToyToFile();
                    break;
                case "6":
                    View.showWiningToys();
                    break;
                case "7":
                    addNewChance();
                    break;
                case "0":
                    return;
                default:
            }
        }
    }
}
