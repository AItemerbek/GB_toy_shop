import java.util.List;

public class View {

    public static void showToys(List<Toys> toys){
        System.out.println("Список доступных игрушек");
        System.out.println("ID, название, остаток шт., шанс выпадения %");
        for (Toys toy : toys) {
            System.out.println(toy);
        }
    }

    public static void showMenu(){
        System.out.println("1 - Просмотр меню");
        System.out.println("2 - Показать все доступные игрушки");
        System.out.println("3 - Добавить игрушку");
        System.out.println("4 - Запустить розыгрыш");
        System.out.println("5 - Получить приз");
        System.out.println("0 - выход");
    }
}
