package csdn.fruitmarket.controller;

import csdn.fruitmarket.Dao.FruitDao;
import csdn.fruitmarket.DaoImpl.FruitJDBCDaoImpl;
import csdn.fruitmarket.model.Fruit;
import csdn.fruitmarket.service.FruitService;
import csdn.fruitmarket.ui.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class AdminDialogController extends AbstractAdminDialog {
    private FruitService fruitService = new FruitService();

    public AdminDialogController(){super();}
    public AdminDialogController(Frame owner, boolean modal){
        super(owner,modal);
        queryFruitItem();
    }

    @Override
    public void deleteFruitItem() {
        boolean ifDelete = fruitService.deleteFruit(delNumberText.getText());
        if (ifDelete){queryFruitItem();}
        else{
            JOptionPane.showMessageDialog(this,"no such a NO, please check data!");
        }
    }

    @Override
    public void updateFruitItem() {
        Fruit fruit = new Fruit(Integer.parseInt(updateNumberText.getText()),updateNameText.getText(),Double.parseDouble(updatePriceText.getText()),updateUnitText.getText());
        boolean ifUpdate = fruitService.updateFruit(fruit);
        if (ifUpdate){queryFruitItem();}
        else{
            JOptionPane.showMessageDialog(this,"no such a NO, please check data!");
        }
    }

    @Override
    public void addFruitItem() {
        Fruit fruit = new Fruit(Integer.parseInt(addNumberText.getText()),addNameText.getText(),Double.parseDouble(addPriceText.getText()),addUnitText.getText());
        boolean ifAdd = fruitService.addFruit(fruit);
        if (ifAdd){queryFruitItem();}
        else{
            JOptionPane.showMessageDialog(this,"no repreated NO!");
        }
    }

    @Override
    public void queryFruitItem() {
        String[] head={"Fruit No.","Name","Price","Unit"};
        String[][] tbody=list2Array(fruitService.getAllFruit());
        TableModel model = new DefaultTableModel(tbody,head);
        table.setModel(model);
    }

    private String[][] list2Array(List<Fruit> allFruit) {
        String[][] body = new String[allFruit.size()][4];
        for (int i=0;i< allFruit.size();i++){
            Fruit fruit = allFruit.get(i);
            body[i][0]=String.valueOf(fruit.getNumber());
            body[i][1]=fruit.getName();
            body[i][2]=String.valueOf(fruit.getPrice());
            body[i][3]=fruit.getUnit();
        }
        return body;
    }
}
