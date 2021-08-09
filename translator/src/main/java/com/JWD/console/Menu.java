package com.JWD.console;

import com.JWD.exception.InvalidInputException;
import com.JWD.exception.NotFoundTranslateException;
import com.JWD.pair.Pair;
import com.JWD.service.Translator;
import com.JWD.service.impl.TranslatorImpl;
import com.JWD.validator.InputProcessor;

public class Menu {

    private final Translator translator = new TranslatorImpl();
    private final InputProcessor inputProcessor = new InputProcessor();

    private static final String WELCOME_MESSAGE = "Press:" +
            "\n 0 - Exit" +
            "\n 1 - Save" +
            "\n 2 - Translate from English" +
            "\n 3 - Translate from Russian" +
            "\n 4 - Count of pairs" +
            "\n 5 - Print all pairs" +
            "\n 6 - Make quiz";
    public static final int EXIT = 0, SAVE = 1, TRANSLATE_FROM_ENGLISH = 2,
            TRANSLATE_FROM_RUSSIAN = 3, COUNT = 4, PRINT = 5, QUIZ = 6, RESTART_VALUE = 999;
    public static final String DELIMITER = "\n==============================================\n";
    public static void printConsole(String s){
        System.out.println(s);
    }

    public void start() {
        processMenu();
        inputProcessor.cleanUpCloseables();
    }

    private void processMenu() {
        boolean isRunning = true;
        while (isRunning){
            int buff;
            printConsole(DELIMITER);
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);
            try{
                buff = inputProcessor.choice();
            }catch (InvalidInputException e){
                buff = RESTART_VALUE;
                printCaughtException(e);
            }
            switch (buff){
                case EXIT:
                    isRunning = false;
                    printConsole("App closes.");
                    break;
                case SAVE:
                    save();
                    break;
                case TRANSLATE_FROM_ENGLISH:
                    translateFromEnglish();
                    break;
                case TRANSLATE_FROM_RUSSIAN:
                    translateFromRussian();
                    break;
                case COUNT:
                    count();
                    break;
                case PRINT:
                    printAll();
                    break;
                case QUIZ:
                    quiz();
                    break;
                default:
                    printConsole("Invalid choice. Restarting app." + DELIMITER);
            }
        }
    }

    private void save()  {
        printConsole("Input Russian word:");
        try {
            String ru = inputProcessor.read();
            printConsole("Input English word:");
            String en = inputProcessor.read();
            Pair pair = new Pair(ru, en);
            translator.save(pair);
            printConsole("Pair was saved.");
        }catch (InvalidInputException e){
            printCaughtException(e);
        }
    }

    private void translateFromEnglish() {
        try {
            printConsole("Input the English word:");
            String en = inputProcessor.read();
            printConsole("Translate of this word is : " + translator.findTranslateFromEn(en));
        }catch (InvalidInputException | NotFoundTranslateException e){
            printCaughtException(e);
        }
    }

    private void translateFromRussian() {
        try {
            printConsole("Input the Russian word:");
            String ru = inputProcessor.read();
            printConsole("Translate of this word is : " + translator.findTranslateFromRu(ru));
        }catch (InvalidInputException | NotFoundTranslateException e){
            printCaughtException(e);
        }
    }

    private void count(){
        printConsole("Count of pairs is : " + translator.count());
    }

    private void printAll(){
        translator.printAll();
    }

    private void printCaughtException(Exception e){
        printConsole("Exception: Parameters passed to Calculator is invalid. Exception message is " + e.getMessage());
    }

    private void quiz(){
        try {
            translator.makeQuiz();
        }catch (InvalidInputException | NotFoundTranslateException exception){
            printCaughtException(exception);
        }
    }
}
