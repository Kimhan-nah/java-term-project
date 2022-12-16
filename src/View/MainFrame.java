package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myButton extends JButton {
  private Font font;
  public myButton(String text) {
    super(text);
    font = new Font("Impact Roman", Font.BOLD, 30);
    setFont(font);
  }
}

class MainPanel extends JPanel {
  private myButton depositButton;
  private myButton withdrawButton;
  private myButton transferButton;
  private myButton balanceInquiryButton;
  private myButton detailsButton;
  private myButton quitButton;

  public MainPanel() {
    setLayout(new GridLayout(2, 3));

    depositButton = new myButton("Deposit");
    withdrawButton = new myButton("Withdraw");
    transferButton = new myButton("Transfer");
    balanceInquiryButton = new myButton("Balance Inquiry");
    detailsButton = new myButton("Details");
    quitButton = new myButton("Quit");

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
//public class MainFrame extends JFrame {
public class MainFrame extends MyFrame {
  private CardLayout cardLayout;
  public MainFrame(String title) {
    super(title);
    cardLayout = new CardLayout();
    MainPanel mainPanel = new MainPanel();   // init panel (main panel)
    DepositPanel depositPanel = new DepositPanel();
    WithdrawPanel withdrawPanel = new WithdrawPanel();
    TransferPanel transferPanel = new TransferPanel();
    BalanceInquiryPanel balanceInquiryPanel = new BalanceInquiryPanel();
    DetailsPanel detailsPanel = new DetailsPanel();

    setLayout(cardLayout);

    // adds view to card layout with unique constraints
    add(mainPanel, "main");
    add(depositPanel, "deposit");
    add(withdrawPanel, "withdraw");
    add(transferPanel, "transfer");
    add(balanceInquiryPanel, "inquiry");
    add(detailsPanel, "details");

    // switch view according to its constraints on click
    mainPanel.viewDeposit(e -> cardLayout.show(MainFrame.this.getContentPane(), "deposit"));
    mainPanel.viewTransfer(e -> cardLayout.show(MainFrame.this.getContentPane(), "transfer"));
    mainPanel.viewWithdraw(e -> cardLayout.show(MainFrame.this.getContentPane(), "withdraw"));
    mainPanel.viewBalance(e -> cardLayout.show(MainFrame.this.getContentPane(), "inquiry"));
    mainPanel.viewDetails(e -> cardLayout.show(MainFrame.this.getContentPane(), "details"));

    depositPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    withdrawPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    transferPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    balanceInquiryPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    detailsPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));

    setVisible(true);
  }
}
