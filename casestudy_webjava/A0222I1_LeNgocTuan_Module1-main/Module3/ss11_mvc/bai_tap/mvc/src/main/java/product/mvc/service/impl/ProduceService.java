package product.mvc.service.impl;

import product.mvc.models.Produce;
import product.mvc.repository.impl.ProduceRepos;
import product.mvc.service.IProduceService;

import java.util.List;

public class ProduceService implements IProduceService {
    public static ProduceRepos repos = new ProduceRepos();

    @Override
    public List<Produce> mapToList() {
        return repos.mapToList();
    }

    @Override
    public void addNew(Produce produce) {
        repos.addNew(produce);
    }

    @Override
    public Produce searchById(int id) {
        return repos.searchById(id);
    }

    @Override
    public Produce searchByName(String name) {
        return repos.searchByName(name);
    }

    @Override
    public void removeProduceById(int id) {
        repos.removeProduceById(id);
    }

    @Override
    public Produce editProduceById(int id, String name, int price, String other, String manufacturer) {
        return repos.editProduceById(id, name, price, other, manufacturer);
    }
}
