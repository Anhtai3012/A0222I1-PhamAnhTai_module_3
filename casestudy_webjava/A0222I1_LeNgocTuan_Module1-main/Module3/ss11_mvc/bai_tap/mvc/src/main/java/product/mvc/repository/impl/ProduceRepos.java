package product.mvc.repository.impl;

import product.mvc.models.Produce;
import product.mvc.repository.IProduceRepos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProduceRepos implements IProduceRepos {
    public static Map<Integer, Produce> list;

    static {
        list = new TreeMap<>();
        list.put(1, new Produce(1, "Pen", 10, "Black", "Dragon"));
        list.put(2, new Produce(2, "Pencil", 7, "Red", "Sky"));
    }

    @Override
    public List<Produce> mapToList() {
        List<Produce> produceList = new ArrayList<>();
        for (Map.Entry<Integer, Produce> entry : list.entrySet()) {
            produceList.add(entry.getValue());
        }
        return produceList;
    }

    @Override
    public void addNew(Produce produce) {
        list.put(produce.getId(), produce);
    }

    @Override
    public Produce searchById(int id) {
        return list.get(id);
    }

    @Override
    public Produce searchByName(String name) {
        for (Map.Entry<Integer, Produce> entry : list.entrySet()) {
            if (entry.getValue().getNameProduce().equalsIgnoreCase(name)) return entry.getValue();
        }
        return null;
    }

    @Override
    public void removeProduceById(int id) {
        list.remove(id);
    }

    @Override
    public Produce editProduceById(int id, String name, int price, String other, String manufacturer) {
        return list.get(id).setNameProduce(name).setPrice(price).setOther(other).setManufacturer(manufacturer);
    }
}
