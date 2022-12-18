package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;
import javax.swing.JTextField;

public class TransferPanel extends inputPanel implements ActionListener{
  private MyButton submitButton;
  private JTextField inputField;
  private String amountData;
  public TransferPanel(AccountController controller) {
    super(controller);
    submitButton = getSubmitButton();
    inputField = getInputField();

    submitButton.addActionListener(this);
    setLabel("이체할 금액을 입력하고 확인 버튼을 누르시오");
    setVisible(true);
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == submitButton) {
      amountData = inputField.getText();
      System.out.println(amountData);
      getController().processTransactions('T', amountData);
    }
  }
}
