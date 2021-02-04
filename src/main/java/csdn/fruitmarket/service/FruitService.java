package csdn.fruitmarket.service;

import csdn.fruitmarket.Dao.FruitDao;
import csdn.fruitmarket.DaoImpl.FruitJDBCDaoImpl;
import csdn.fruitmarket.model.Fruit;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class FruitService {
    private FruitDao fruitDao=new FruitJDBCDaoImpl();

    public List<Fruit> getAllFruit(){
        return fruitDao.getFruit();
    }

    public boolean addFruit(Fruit fruit){
        List<Fruit> fruits = fruitDao.getFruit();
        for (Fruit f:fruits){
            if (f.getNumber()==fruit.getNumber()) return false;
        }
        fruitDao.save(fruit);
        return true;
    }

    public boolean updateFruit(Fruit fruit){
        List<Fruit> list = fruitDao.getFruit();
        for (Fruit f:list){
            if (f.getNumber()==fruit.getNumber()){
                fruitDao.update(fruit);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFruit(String str){
        List<Fruit> fruits = fruitDao.getFruit();
        for (Fruit f:fruits){
            if (f.getNumber()==Integer.parseInt(str)){
                fruitDao.delete(f);
                return true;
            }
        }
        return false;
    }
}
