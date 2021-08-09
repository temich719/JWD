package com.JWD.service.impl;

import com.JWD.exception.InvalidInputException;
import com.JWD.exception.NotFoundTranslateException;
import com.JWD.pair.Pair;
import com.JWD.service.Translator;
import com.JWD.storage.Dao;

public class TranslatorImpl implements Translator {

    private static final Dao dao = new Dao();

    @Override
    public void save(Pair pair) {
        dao.push(pair);
    }

    @Override
    public String findTranslateFromEn(String s) throws NotFoundTranslateException {
        return dao.searchTranslateFromEn(s);
    }

    @Override
    public String findTranslateFromRu(String s) throws NotFoundTranslateException {
        return dao.searchTranslateFromRu(s);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void printAll() {
        dao.printAll();
    }

    @Override
    public void makeQuiz() throws InvalidInputException, NotFoundTranslateException {
        dao.makeQuiz();
    }
}
