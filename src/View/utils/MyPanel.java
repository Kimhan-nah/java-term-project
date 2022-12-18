package View.utils;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import Controller.AccountController;

public class MyPanel extends JPanel {
  private JButton backButton;
  private AccountController controller;
  public MyPanel(AccountController controller) {
    this.controller = controller;
    JToolBar toolBar = new JToolBar();
    backButton = new JButton("Go Back");

    setLayout(new BorderLayout());
    add("North", toolBar);
    toolBar.add(backButton);
    toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
  }
  public void backButton(ActionListener actionListener) {
    backButton.addActionListener(actionListener);
  }
  public AccountController getController() {
    return controller;
  }
}
