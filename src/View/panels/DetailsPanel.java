package View.panels;

import View.utils.*;
import java.awt.*;
import javax.swing.*;

public class DetailsPanel extends MyPanel {
  private JButton submitButton;
  public DetailsPanel() {
    JPanel depositPanel = new JPanel(new GridLayout(3, 0));
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    submitButton = new MyButton("확인");

    // TODO : Add Details
    buttonPanel.add(submitButton);
    depositPanel.add(buttonPanel);
    add("Center", depositPanel);
    setVisible(true);

  }
}
