package View;

import View.panels.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Controller.AccountController;

public class MainFrame extends JFrame {
//  public class MainFrame extends MyFrame {
  private CardLayout cardLayout;
  private AccountController controller;
  public MainFrame(String title, AccountController controller) {
    super(title);

    cardLayout = new CardLayout();
    this.controller = controller;
    MainPanel mainPanel = new MainPanel();   // init panel (main panel)
    DepositPanel depositPanel = new DepositPanel(controller);
    WithdrawPanel withdrawPanel = new WithdrawPanel(controller);
    TransferPanel transferPanel = new TransferPanel(controller);
    BalanceInquiryPanel balanceInquiryPanel = new BalanceInquiryPanel(controller);
    DetailsPanel detailsPanel = new DetailsPanel(controller);

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
    mainPanel.quit(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    depositPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    withdrawPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    transferPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    balanceInquiryPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));
    detailsPanel.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "main"));

    setBounds(300, 300, 500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
