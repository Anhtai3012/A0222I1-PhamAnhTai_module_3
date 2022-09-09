package com.codegym.service;

import java.util.List;

public interface ICondimentService {
    List<String> getList();

    String getCondiment(List<String> condiment);

}
