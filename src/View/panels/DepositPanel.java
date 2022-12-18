package View.panels;

import View.utils.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Controller.AccountController;

public class DepositPanel extends InputPanel implements ActionListener {
  private MyButton submitButton;
  private JTextField inputField;
  private String amountData;

  public DepositPanel(AccountController controller) {
    super(controller);

    submitButton = getSubmitButton();
    inputField = getInputField();

    setLabel("입금할 금액을 입력하고 확인 버튼을 누르시오");
    submitButton.addActionListener(this);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    try {
      if (actionEvent.getSource() == submitButton) {
        amountData = inputField.getText();
        System.out.println(amountData);
        getController().processTransactions('D', amountData);
        JOptionPane.showMessageDialog(null, "Complete to Deposit", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
      }
    }
    catch (RuntimeException e) {
      JOptionPane.showMessageDialog(null, "Deposit Error", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
}
