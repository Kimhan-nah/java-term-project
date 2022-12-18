package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;
import javax.swing.JTextField;

public class WithdrawPanel extends inputPanel implements ActionListener {
  private MyButton submitButton;
  private JTextField inputField;
  private String amountData;
  public WithdrawPanel(AccountController controller) {
    super(controller);
    submitButton = getSubmitButton();
    inputField = getInputField();

    submitButton.addActionListener(this);
    setLabel("출금할 금액을 입력하고 확인 버튼을 누르시오");
    setVisible(true);
  }

  public void actionPerformed(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == submitButton) {
      amountData = inputField.getText();
      System.out.println(amountData);
      getController().processTransactions('W', amountData);
    }
  }

}
