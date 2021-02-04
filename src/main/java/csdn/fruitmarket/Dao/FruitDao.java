package csdn.fruitmarket.Dao;

import csdn.fruitmarket.model.Fruit;

import java.util.List;

public interface FruitDao {
    int save(Fruit fruit);
    List<Fruit> getFruit();
    int delete(Fruit fruit);
    int update(Fruit fruit);
    Fruit getFruitById(int id);
}
