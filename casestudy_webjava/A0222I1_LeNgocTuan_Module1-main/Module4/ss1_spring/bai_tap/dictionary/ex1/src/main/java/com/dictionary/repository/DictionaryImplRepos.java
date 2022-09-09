package com.dictionary.repository;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class DictionaryImplRepos implements DictionaryRepos {
    static Map<String, String> map = new TreeMap<>();

    static {
        map.put("cat", "Meo");
        map.put("pig", "Heo");
        map.put("dog", "Cho");
    }

    @Override
    public String searchText(String key) {
        if (map.get(key) != null) {
            return map.get(key);
        }
        return "Not Found";
    }
}