package View.panels;

import View.utils.*;
import Controller.AccountController;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransferPanel extends InputPanel implements ActionListener{
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
    try {
      if (actionEvent.getSource() == submitButton) {
        amountData = inputField.getText();
        System.out.println(amountData);
        getController().processTransactions('T', amountData);
      }
      JOptionPane.showMessageDialog(null, "Complete to Transfer", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }
    catch (RuntimeException e) {
      JOptionPane.showMessageDialog(null, "Transfer Error", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
}
