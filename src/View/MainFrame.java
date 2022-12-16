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
//    setText("Morph");
//    addActionListener(new myListener());
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

    depositButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new DepositFrame();
        setVisible(false);
      }
    });

    add(depositButton);
    add(withdrawButton);
    add(transferButton);
    add(balanceInquiryButton);
    add(detailsButton);
    add(quitButton);
  }

}
//public class MainFrame extends JFrame {
public class MainFrame extends MyFrame {
  public MainFrame(String title) {
    super(title);
    MainPanel main_panel = new MainPanel();   // init panel (main panel)
    // set layout
//    setLayout(new BorderLayout());

    add("Center", main_panel);
    // frame width & height
//    int FRAME_WIDTH = 1200;
//    int FRAME_HEIGHT = 700;
//    int FRAME_X = 100;
//    int FRAME_Y = 100;

    // size of our application frame
//    setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
