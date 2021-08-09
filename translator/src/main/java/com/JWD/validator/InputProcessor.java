package com.JWD.validator;

import com.JWD.exception.InvalidInputException;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner;
    {
        scanner = new Scanner(System.in);
    }

    private final Closeable[] closeables;

    public InputProcessor(){
        this.closeables = new Closeable[]{scanner};
    }

    private boolean isIncorrectCharacter(char c){
        return "+=-_'.,/!@#$%^&*()~\"\\1234567890".indexOf(c) != -1;
    }

    private boolean isCorrectDigit(char c){
        return "0123456".indexOf(c) != -1;
    }

    public String read() throws InvalidInputException {
        String s = scanner.nextLine();
        for (int i = 0;i < s.length();i++){
            if (isIncorrectCharacter(s.charAt(i)))throw new InvalidInputException("Вы ввели недопустимые символы!Попробуйте еще:");
        }
        return s;
    }

    public int choice() throws InvalidInputException {
        String s = scanner.nextLine();
        if (s.length() > 1)throw new InvalidInputException("Вы ввели недопустимое выражение!Try again");
        if (isCorrectDigit(s.charAt(0)))return Integer.parseInt(s);
        else throw new InvalidInputException("Вы ввели недопустимое выражение!Try again");
    }

    public void cleanUpCloseables() {
        for (final Closeable closeable : closeables) {
            try {
                closeable.close();
                System.out.println("Resource is closed, " + closeable.getClass());

            } catch (final IOException e) {
                System.out.println("Something went wrong during closing " + closeable.getClass());
                e.printStackTrace();
            }
        }
    }
}
