package csdn.fruitmarket.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMainFrame extends JFrame {
    private JLabel titleLabel = new JLabel(new ImageIcon("/home/madlax/Downloads/fruit market.jpg"));
    private JButton btn = new JButton("enter");

    private void init(){
        this.setTitle("Welcome!");
        this.setSize(1200,1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent(){
        this.add(this.titleLabel, BorderLayout.NORTH);
        JPanel btnPanel = new JPanel();
        this.add(btnPanel,BorderLayout.CENTER);
        btnPanel.setLayout(null);
        btn.setBounds(400,45,400,100);
        btnPanel.add(btn);
    }

    private void addListener(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { showAdminDialog();}
        });
    }

    public AbstractMainFrame(){
        this.init();
        this.addComponent();
        this.addListener();
    }

    public abstract void showAdminDialog();
}
