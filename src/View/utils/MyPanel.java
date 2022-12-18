package View.utils;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPanel extends JPanel {
  private JButton backButton;
  // TEST
  private JLabel label;
  private JTextField inputField;
  private JButton submitButton;

  public MyPanel() {
    JToolBar toolBar = new JToolBar();
    JPanel jpanel = new JPanel(new GridLayout(3, 0));
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    backButton = new JButton("Go Back");
    label = new JLabel("init label");
    inputField = new JTextField();
    submitButton = new MyButton("CHECK");

    setLayout(new BorderLayout());
    add("North", toolBar);
    toolBar.add(backButton);
    toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));

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
  public void backButton(ActionListener actionListener) {
    backButton.addActionListener(actionListener);
  }

  // TODO actionPerformed?
}
