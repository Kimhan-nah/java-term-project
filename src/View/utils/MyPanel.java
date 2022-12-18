package View.utils;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPanel extends JPanel {
  private JButton backButton;

  public MyPanel() {
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
}
