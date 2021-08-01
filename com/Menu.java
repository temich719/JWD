package JWD.com;

public class Menu {
    public static void printMenu(){
        System.out.println("1.Вычислить выражение\n" +
                           "2.Выход из программы");
    }

    public static void inputFirstOperand(){
        System.out.print("Введите первое число:   ");
    }

    public static void inputSecondOperand(){
        System.out.print("Введите второе число:   ");
    }

    public static void printChoice(){
        System.out.println("Выберете операцию:\n" +
                           "1.+\n" +
                           "2.-\n" +
                           "3.*\n" +
                           "4./\n" +
                           "5.^\n" +
                           "6.sqrt");
    }

    public static void lastMessage(){
        System.out.println("Программа завершила работу.");
    }
}
