package product.mvc.service;

import product.mvc.models.Produce;

import java.util.List;

public interface IProduceService {
    List<Produce> mapToList();

    void addNew(Produce produce);

    Produce searchById(int id);

    Produce searchByName(String name);

    void removeProduceById(int id);

    Produce editProduceById(int id, String name, int price, String other, String manufacturer);
}
