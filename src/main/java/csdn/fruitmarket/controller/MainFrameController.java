package csdn.fruitmarket.controller;

import csdn.fruitmarket.ui.AbstractMainFrame;

public class MainFrameController extends AbstractMainFrame {
    @Override
    public void showAdminDialog() {
        new AdminDialogController(this,true).setVisible(true);
    }
}
