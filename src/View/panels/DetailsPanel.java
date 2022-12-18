package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;

public class DetailsPanel extends InquiryPanel implements ActionListener{
  private MyButton showButton;
  public DetailsPanel(AccountController controller) {
    super(controller);
    showButton = getShowButton();
    showButton.setText("최근 거래 내역 조회");
    showButton.addActionListener(this);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    getController().processTransactions('L', null);
  }
}
