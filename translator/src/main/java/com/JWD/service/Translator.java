package com.JWD.service;

import com.JWD.exception.InvalidInputException;
import com.JWD.exception.NotFoundTranslateException;
import com.JWD.pair.Pair;

public interface Translator {
    void save(Pair pair);
    String findTranslateFromEn(String s) throws NotFoundTranslateException;
    String findTranslateFromRu(String s) throws NotFoundTranslateException;
    int count();
    void printAll();
    void makeQuiz() throws InvalidInputException, NotFoundTranslateException;
}
