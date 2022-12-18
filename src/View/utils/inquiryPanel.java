package View.utils;

import Controller.AccountController;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class inquiryPanel extends MyPanel{
  private MyButton showButton;
  public inquiryPanel(AccountController controller) {
    super(controller);
    JPanel jpanel = new JPanel(new GridLayout(3, 0));
    showButton = new MyButton("조회");

    jpanel.add(showButton);
    add("Center", jpanel);
  }
  public MyButton getShowButton() {
    return showButton;
  }
}
