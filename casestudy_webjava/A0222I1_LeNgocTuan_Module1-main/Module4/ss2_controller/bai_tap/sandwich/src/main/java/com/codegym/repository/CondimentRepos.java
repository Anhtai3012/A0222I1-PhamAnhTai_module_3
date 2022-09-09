package com.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CondimentRepos implements ICondimentRepos {
    static List<String> list = new ArrayList<>();

    static {
        list.add("Lettuce");
        list.add("Tomato");
        list.add("Mustard");
        list.add("Sprouts");
    }
    @Override
    public List<String> getList() {
        return list;
    }
}
