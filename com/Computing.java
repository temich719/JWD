package JWD.com;

import java.util.Scanner;

public class Computing {

    protected Scanner scanner = new Scanner(System.in);

    protected char sign;

    protected int compute(int a, int b, char sign){
        switch (sign){
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
            case '/':return a/b;
            case '^':return (int) Math.pow(a, b);
            case 's':return (int) Math.sqrt(a);
            default:return -1;
        }
    }

    protected char defineSign(){
        Menu.printChoice();
        this.sign = scanner.nextLine().charAt(0);
        switch (sign){
            case '1':return '+';
            case '2':return '-';
            case '3':return '*';
            case '4':return '/';
            case '5':return '^';
            case '6':return 's';
            default:return '1';
        }
    }

    protected String getOperand(){
        return scanner.nextLine();
    }
}
