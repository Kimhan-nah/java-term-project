package View.panels;

import View.utils.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class DepositPanel extends MyPanel {
  private JTextField inputField;
  private JButton submitButton;

  public DepositPanel() {
    JPanel depositPanel = new JPanel(new GridLayout(3, 0));
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    JLabel depositAmountLabel = new JLabel("입금할 금액을 아래에 입력하고 확인 버튼을 눌러주세요 ");
    inputField = new JTextField();
    submitButton = new MyButton("확인");

    buttonPanel.add(submitButton);
    depositPanel.add(depositAmountLabel);
    depositPanel.add(inputField);
    depositPanel.add(buttonPanel);
    depositAmountLabel.setHorizontalAlignment(JLabel.CENTER);
    add("Center", depositPanel);
    setVisible(true);
  }

}
