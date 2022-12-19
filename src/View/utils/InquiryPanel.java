package View.utils;

import Controller.AccountController;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InquiryPanel extends MyPanel{
  private MyButton showButton;
  private JPanel jPanel;
  private JLabel jLabel;
  public InquiryPanel(AccountController controller) {
    super(controller);
    jPanel = new JPanel(new GridLayout(3, 0));
    jLabel = new JLabel();
    showButton = new MyButton("조회");

    jPanel.add(showButton);
    jPanel.add(jLabel);
    add("Center", jPanel);
    jLabel.setHorizontalAlignment(JLabel.CENTER);
  }
  public MyButton getShowButton() {
    return showButton;
  }
  public JLabel getJLabel()  {return jLabel;}
}
