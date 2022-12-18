package View.panels;

import View.utils.*;
import java.awt.*;
import javax.swing.*;

public class TransferPanel extends MyPanel {
  private JTextField inputField;
  private JButton submitButton;

  public TransferPanel() {
    JPanel depositPanel = new JPanel(new GridLayout(3, 0));
    JLabel transferAmountLabel  = new JLabel("이체할 금액을 아래에 입력하고 확인 버튼을 눌러주세요 ");
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    inputField = new JTextField();
    submitButton = new MyButton("확인");

    buttonPanel.add(submitButton);
    depositPanel.add(transferAmountLabel);
    depositPanel.add(inputField);
    depositPanel.add(buttonPanel);
    add("Center", depositPanel);
    transferAmountLabel.setHorizontalAlignment(JLabel.CENTER);
    setVisible(true);
  }

}
