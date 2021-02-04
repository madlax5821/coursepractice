package csdn.fruitmarket.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractAdminDialog extends JDialog{
    private JLabel tableLable = new JLabel("Fruit List");
    private JScrollPane tablePanel = new JScrollPane();
    protected JTable table = new JTable();
    private JLabel numberLabel = new JLabel("Fruit NO.");
    private JLabel nameLabel = new JLabel("Fruit Name");
    private JLabel priceLabel = new JLabel("Fruit Price");
    private JLabel unitLabel = new JLabel("Fruit Unit");

    protected JTextField addNumberText = new JTextField(6);
    protected JTextField addNameText = new JTextField(6);
    protected JTextField addPriceText = new JTextField(6);
    protected JTextField addUnitText = new JTextField(6);
    private JButton addBtn = new JButton("Add Fruit");

    protected JTextField updateNumberText = new JTextField(6);
    protected JTextField updateNameText = new JTextField(6);
    protected JTextField updatePriceText = new JTextField(6);
    protected JTextField updateUnitText = new JTextField(6);
    private JButton updateBtn = new JButton("Modify Fruit");

    protected JTextField delNumberText = new JTextField(6);
    private JButton delBtn = new JButton("Delete Fruit");

    public AbstractAdminDialog(){this(null,true);}

    public AbstractAdminDialog(Frame owner, boolean modal){
        super(owner,modal);
        this.init();
        this.addComponent();
        this.addListener();
    }

    private void init(){
        this.setTitle("Goods Admin");
        this.setSize(1200,800);
        this.setResizable(false);
    }

    private void addComponent(){
        this.setLayout(null);
        tableLable.setBounds(265,20,70,25);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setEnabled(false);
        tablePanel.setBounds(50,50,500,200);
        tablePanel.setViewportView(table);
        this.add(tablePanel);

        numberLabel.setBounds(50,250,70,25);
        nameLabel.setBounds(150,250,70,25);
        priceLabel.setBounds(250,250,70,25);
        unitLabel.setBounds(350,250,70,25);
        this.add(numberLabel);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(unitLabel);

        addNumberText.setBounds(50,280,80,25);
        addNameText.setBounds(150,280,80,25);
        addPriceText.setBounds(250,280,80,25);
        addUnitText.setBounds(350,280,80,25);
        this.add(addNumberText);
        this.add(addNameText);
        this.add(addPriceText);
        this.add(addUnitText);
        addBtn.setBounds(460,280,90,25);
        this.add(addBtn);

        updateNumberText.setBounds(50,310,80,25);
        updateNameText.setBounds(150,310,80,25);
        updatePriceText.setBounds(250,310,80,25);
        updateUnitText.setBounds(350,310,80,25);
        this.add(updateNumberText);
        this.add(updateNameText);
        this.add(updatePriceText);
        this.add(updateUnitText);
        updateBtn.setBounds(460,310,90,25);
        this.add(updateBtn);

        delNumberText.setBounds(50,340,80,25);
        this.add(delNumberText);
        delBtn.setBounds(460,340,90,25);
        this.add(delBtn);
    }

    private void addListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {addFruitItem();}
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {updateFruitItem();}
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {deleteFruitItem();}
        });
    }

    public abstract void deleteFruitItem();

    public abstract void updateFruitItem();

    public abstract void addFruitItem();

    public abstract void queryFruitItem();




}
