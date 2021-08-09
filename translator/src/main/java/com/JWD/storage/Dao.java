package com.JWD.storage;

import com.JWD.exception.InvalidInputException;
import com.JWD.exception.NotFoundTranslateException;
import com.JWD.pair.Pair;
import com.JWD.validator.InputProcessor;

import java.util.*;

public class Dao {
    private final Map<String, String> hashmap = new HashMap<>();
    {
        hashmap.put("кот", "cat");
        hashmap.put("собака", "dog");
        hashmap.put("мяч", "ball");
        hashmap.put("телефон", "phone");
        hashmap.put("картинка", "picture");
        hashmap.put("приложение", "application");
        hashmap.put("глаз", "eye");
        hashmap.put("машина", "car");
        hashmap.put("деньги", "money");
        hashmap.put("обезьяна", "monkey");
    }

    InputProcessor inputProcessor;
    {
        inputProcessor = new InputProcessor();
    }

    public void printAll(){

        for (Map.Entry<String, String> i: hashmap.entrySet()) {
            System.out.println(i.getKey() + "||" + i.getValue());
        }
    }

    public void push(Pair pair){
        hashmap.remove(pair.getKey());
        if (hashmap.containsValue(pair.getValue())){
            for (Map.Entry<String, String> i:hashmap.entrySet()) {
                if (i.getValue().equals(pair.getValue())){
                    hashmap.remove(i.getKey());
                    break;
                }
            }
        }
        hashmap.put(pair.getKey(), pair.getValue());
    }

    public String searchTranslateFromEn(String str) throws NotFoundTranslateException {
        for (Map.Entry<String,String> pair:hashmap.entrySet()) {
            if (pair.getValue().equals(str))return pair.getKey();
        }
        throw new NotFoundTranslateException("Не удалось найти перевод слова с анлийского на русский!");
    }

    public String searchTranslateFromRu(String str) throws NotFoundTranslateException {
        for (Map.Entry<String,String> pair:hashmap.entrySet()) {
            if (pair.getKey().equals(str))return pair.getValue();
        }
        throw new NotFoundTranslateException("Не удалось найти перевод слова с русского на английский!");
    }

    public int count(){
        return hashmap.size();
    }

    public void makeQuiz() throws NotFoundTranslateException, InvalidInputException {
        Set<String> set = new HashSet<>();
        Map<String, Pair> mistakes = new HashMap<>();
        String[] strings = new String[2];
        Random generator = new Random();
        Object[] values = hashmap.values().toArray();
        Object[] keys = hashmap.keySet().toArray();
        int kolRight = 0;
        System.out.println("Translate next 5 words : ");
        while (set.size() != 5){
            set.add((String) values[generator.nextInt(values.length)]);
        }
        for (String s: set) {
            strings[0] = null;
            strings[1] = null;
            strings[generator.nextInt(strings.length)] = searchTranslateFromEn(s);
                while (Objects.isNull(strings[0])){
                    String str = (String)keys[generator.nextInt(keys.length)];
                    if (!str.equals(strings[1]))strings[0] = str;
                }
                while (Objects.isNull(strings[1])){
                    String str = (String)keys[generator.nextInt(keys.length)];
                    if (!str.equals(strings[0]))strings[1] = str;
                }
                boolean flag = true;
                while (flag) {
                    System.out.println(s);
                    System.out.println("1) " + strings[0]);
                    System.out.println("2) " + strings[1]);
                    int choice = inputProcessor.choice();
                    Pair pair;
                    switch (choice) {
                        case 1:
                            if (searchTranslateFromEn(s).equals(strings[0])) kolRight++;
                            else {
                                pair = new Pair(strings[0], searchTranslateFromEn(s));
                                mistakes.put(s, pair);
                            }
                            flag = false;
                            break;
                        case 2:
                            if (searchTranslateFromEn(s).equals(strings[1])) kolRight++;
                            else {
                                pair = new Pair(strings[1], searchTranslateFromEn(s));
                                mistakes.put(s, pair);
                            }
                            flag = false;
                            break;
                        default:
                            System.out.println("Вы ввели неверную цифру!Try again:");
                    }
                }
        }
        if(mistakes.isEmpty()) System.out.println("Нет ошибок! Поздравляем");
        else {
            System.out.println("Ваши ошибки:");
            for (Map.Entry<String, Pair> i : mistakes.entrySet()) {
                System.out.println("В слове " + i.getKey() + "\nВы ответили :" + i.getValue().getKey() + "\nПравильный ответ :" + i.getValue().getValue());
            }
        }
        System.out.println("Процент решенных вопросов равен : " + (kolRight*100)/5);
    }
}
