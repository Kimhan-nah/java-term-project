package View.panels;

import View.utils.MyButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  private MyButton depositButton;
  private MyButton withdrawButton;
  private MyButton transferButton;
  private MyButton balanceInquiryButton;
  private MyButton detailsButton;
  private MyButton quitButton;

  public MainPanel() {
    setLayout(new GridLayout(2, 3));

    depositButton = new MyButton("Deposit");
    withdrawButton = new MyButton("Withdraw");
    transferButton = new MyButton("Transfer");
    balanceInquiryButton = new MyButton("Balance Inquiry");
    detailsButton = new MyButton("Details");
    quitButton = new MyButton("Quit");

    add(depositButton);
    add(withdrawButton);
    add(transferButton);
    add(balanceInquiryButton);
    add(detailsButton);
    add(quitButton);
  }
  public void viewDeposit(ActionListener actionListener) {
    depositButton.addActionListener(actionListener);
  }
  public void viewWithdraw(ActionListener actionListener) {
    withdrawButton.addActionListener(actionListener);
  }
  public void viewTransfer(ActionListener actionListener) {
    transferButton.addActionListener(actionListener);
  }
  public void viewBalance(ActionListener actionListener) {
    balanceInquiryButton.addActionListener(actionListener);
  }
  public void viewDetails(ActionListener actionListener) {
    balanceInquiryButton.addActionListener(actionListener);
  }
}
