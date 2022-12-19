package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceInquiryPanel extends InquiryPanel implements ActionListener{
  private MyButton showButton;
  public BalanceInquiryPanel(AccountController controller) {
    super(controller);
    showButton = getShowButton();
    showButton.setText("잔금 조회하기");
    showButton.addActionListener(this);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    try {
      String data = getController().processTransactions('B', null);
      JLabel label = getJLabel();
      label.setText("계좌 잔액 : " + data);
    }
    catch (RuntimeException e) {
    }
  }

}
