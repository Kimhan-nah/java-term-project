package View;

import java.awt.*;
import javax.swing.*;

public class DepositPanel extends MyPanel {
  private JTextField depositAmountField;
  private JButton submitButton;

  DepositPanel() {
    JLabel depositAmountLabel = new JLabel("입금할 금액 : ");
    depositAmountField = new JTextField(25);
    submitButton = new JButton("Add User");
    submitButton.setPreferredSize(new Dimension(278, 40));

    add(depositAmountField);
    add(submitButton);

    setVisible(true);
  }

}
