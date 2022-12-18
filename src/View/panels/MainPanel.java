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

    depositButton = new MyButton("입금");
    withdrawButton = new MyButton("출금");
    transferButton = new MyButton("이체");
    balanceInquiryButton = new MyButton("잔금 조회");
    detailsButton = new MyButton("최근 거래 내역 조회");
    quitButton = new MyButton("종료");

    add(depositButton);
    add(withdrawButton);
    add(transferButton);
    add(balanceInquiryButton);
    add(detailsButton);
    add(quitButton);

//    quitButton.addActionListener();
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
    detailsButton.addActionListener(actionListener);
  }
  public void quit(ActionListener actionListener) {
//    quitButton.addActionListener();
    quitButton.addActionListener(actionListener);
  }
}
