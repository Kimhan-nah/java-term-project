package View.utils;

import java.awt.*;
import javax.swing.*;
import Controller.AccountController;

public class inputPanel extends MyPanel {
  private JLabel label;
  private JTextField inputField;
  private MyButton submitButton;

  public inputPanel(AccountController controller) {
    super(controller);
    JPanel jpanel = new JPanel(new GridLayout(3, 0));
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    label = new JLabel("init label");
    inputField = new JTextField();
    submitButton = new MyButton("CHECK");


    buttonPanel.add(submitButton);
    jpanel.add(label);
    jpanel.add(inputField);
    jpanel.add(buttonPanel);
    label.setHorizontalAlignment(JLabel.CENTER);
    add("Center", jpanel);
  }

  public void setLabel(String str) {
    label.setText(str);
  }

  public MyButton getSubmitButton() {
    return submitButton;
  }
  public JTextField getInputField() {
    return inputField;
  }
}
