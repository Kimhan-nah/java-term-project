package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;
import javax.swing.JButton;

public class BalanceInquiryPanel extends inquiryPanel implements ActionListener{
  private MyButton showButton;
  public BalanceInquiryPanel(AccountController controller) {
    super(controller);
    showButton = getShowButton();
    showButton.setText("잔금 조회");
    showButton.addActionListener(this);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    getController().processTransactions('B', null);
  }

}
