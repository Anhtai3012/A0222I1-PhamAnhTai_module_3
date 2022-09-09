package com.dictionary.service;

import com.dictionary.repository.DictionaryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryImpl implements Dictionary {
    @Autowired
    private DictionaryRepos dictionaryRepos;

    @Override
    public String searchText(String key) {
        return dictionaryRepos.searchText(key);
    }
}
