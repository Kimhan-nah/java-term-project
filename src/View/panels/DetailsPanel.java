package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;
import javax.swing.JLabel;

public class DetailsPanel extends InquiryPanel implements ActionListener{
  private MyButton showButton;
  public DetailsPanel(AccountController controller) {
    super(controller);
    showButton = getShowButton();
    showButton.setText("최근 거래 내역 조회하기");
    showButton.addActionListener(this);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    try {
      String data = getController().processTransactions('L', null);
      JLabel label = getJLabel();
      label.setText("최근 거래 내역 : " + data);
    }
    catch (Exception e) {
    }
  }
}
