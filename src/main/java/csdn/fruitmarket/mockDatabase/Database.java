package csdn.fruitmarket.mockDatabase;

import csdn.fruitmarket.model.Fruit;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Fruit> fruits = new ArrayList<>();
    static {
        fruits.add(new Fruit(1,"apple",5.0,"kg"));
    }
}
