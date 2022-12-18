package View.panels;

import View.utils.*;
import java.awt.*;
import javax.swing.*;

public class BalanceInquiryPanel extends MyPanel {
  private JButton submitButton;
  public BalanceInquiryPanel() {
    JPanel depositPanel = new JPanel(new GridLayout(3, 0));
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    submitButton = new MyButton("확인");

    // TODO : add panel to inquiry balance
    buttonPanel.add(submitButton);
    depositPanel.add(buttonPanel);
    add("Center", depositPanel);
    setVisible(true);

  }

}
