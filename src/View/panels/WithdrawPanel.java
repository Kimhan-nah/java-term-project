package View.panels;

import View.utils.*;
import java.awt.*;
import javax.swing.*;

public class WithdrawPanel extends MyPanel {
  private JTextField inputField;
  private JButton submitButton;
  public WithdrawPanel() {
    JPanel depositPanel = new JPanel(new GridLayout(3, 0));
    JLabel depositAmountLabel = new JLabel("인출할 금액을 아래에 입력하고 확인 버튼을 눌러주세요 ");
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    inputField = new JTextField();
    submitButton = new MyButton("확인");

    buttonPanel.add(submitButton);
    depositPanel.add(depositAmountLabel);
    depositPanel.add(inputField);
    depositPanel.add(buttonPanel);
    add("Center", depositPanel);
    depositAmountLabel.setHorizontalAlignment(JLabel.CENTER);
    setVisible(true);
  }

}
