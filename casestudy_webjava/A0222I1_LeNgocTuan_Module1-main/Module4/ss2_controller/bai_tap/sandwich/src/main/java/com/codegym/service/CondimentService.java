package com.codegym.service;

import com.codegym.repository.ICondimentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentService implements ICondimentService {
    @Autowired
    ICondimentRepos condimentRepos;

    @Override
    public List<String> getList() {
        return condimentRepos.getList();
    }
    public String getCondiment(List<String> condiment) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sandwich you choose have condiment: ");
        for (String str : condiment) {
            stringBuilder.append(str).append(", ");
        }
        return stringBuilder.toString();
    }
}
